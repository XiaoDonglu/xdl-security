package com.xdl.security.browser;

import com.xdl.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * 浏览器安全配置
 *
 * @author xdl
 * @date 2018-10-09
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler xdlAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler xdlAuthenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        String loginPage="/xdl-signIn.html";
        String loginPage = "/authentication/require";

//        http.httpBasic()
        //表单登录
        http.formLogin()
                //登录页面
                .loginPage(loginPage)
                //登录请求
                .loginProcessingUrl("/authentication/form")
                //成功处理器
                .successHandler(xdlAuthenticationSuccessHandler)
                //失败处理器
                .failureHandler(xdlAuthenticationFailureHandler)
                .and()
                .authorizeRequests()
                //放过登录页面请求
                .antMatchers(loginPage,
                        securityProperties.getBrowser().getLoginPage())
                .permitAll()
                //所有请求需要验证
                .anyRequest().authenticated()
                .and()
                //关闭跨站请求防护功能
                .csrf().disable();
    }
}
