package com.xdl.security.browser;

import com.xdl.security.core.properties.SecurityProperties;
import com.xdl.security.core.validate.code.ValidateCodeFilter;
import com.xdl.security.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

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
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationSuccessHandler xdlAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler xdlAuthenticationFailureHandler;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(xdlAuthenticationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

//        String loginPage="/xdl-signIn.html";
        String loginPage = "/authentication/require";

        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                //表单登录（登录页面,登录请求,成功处理器,失败处理器）
                .formLogin()
//                .httpBasic()
                .loginPage(loginPage)
                .loginProcessingUrl("/authentication/form")
                .successHandler(xdlAuthenticationSuccessHandler)
                .failureHandler(xdlAuthenticationFailureHandler)
                .and()
                //记住我（失效时间）
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(userDetailsService)
                .and()
                //放过请求
                .authorizeRequests()
                .antMatchers(loginPage,
                        securityProperties.getBrowser().getLoginPage(),
                        "/code/image")
                .permitAll()
                //所有请求需要验证
                .anyRequest().authenticated()
                .and()
                //关闭跨站请求防护功能
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

}
