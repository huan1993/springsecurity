package com.huan.springsecurity.social.qq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.web.client.RestTemplate;

/**
 * QQ登录的配置
 * 
 * @描述
 * @作者 huan
 * @时间 2018年3月3日 - 下午6:05:01
 */
public class QQLoginConfigure extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;

	@Override
	public void configure(HttpSecurity http) throws Exception {

		QQLoginFilter qqLoginFilter = new QQLoginFilter("/login/qq", restTemplate);
		qqLoginFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
		qqLoginFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
		http.authenticationProvider(new QQLoginProvider(restTemplate)).addFilterBefore(qqLoginFilter, AbstractPreAuthenticatedProcessingFilter.class);
	}
}
