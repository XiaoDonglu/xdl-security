package com.xdl.security.core.authentication.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * 短信验证码配置
 *
 * @author xdl
 * @date 2018-10-11
 */
@Component
public class SmsCodeAuthenticationSecurityConfig
        extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private AuthenticationSuccessHandler xdlAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler xdlAuthenticationFailureHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        //短信验证码登录过滤器
        SmsCodeAuthenticationFilter filter = new SmsCodeAuthenticationFilter();
        filter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        filter.setAuthenticationSuccessHandler(xdlAuthenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(xdlAuthenticationFailureHandler);

        //短信验证码登录校验逻辑
        SmsCodeAuthenticationProvider provider = new SmsCodeAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);

        http.authenticationProvider(provider)
                .addFilterAfter(filter, UsernamePasswordAuthenticationFilter.class);
    }
}
