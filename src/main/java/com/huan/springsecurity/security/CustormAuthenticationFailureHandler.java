package com.huan.springsecurity.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

/**
 * 认证失败之后的处理
 * 
 * @描述
 * @作者 huan
 * @时间 2017年5月30日 - 下午3:03:09
 */
public class CustormAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

		super.onAuthenticationFailure(request, response, exception);
		System.out.println("登录失败,原因:" + request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION));
	}

}
