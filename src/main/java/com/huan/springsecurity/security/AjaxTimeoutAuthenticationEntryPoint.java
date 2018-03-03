package com.huan.springsecurity.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

/**
 * 匿名用户访问认证资源，且没有权限时候的处理。
 * 
 * @描述
 * @作者 huan
 * @时间 2018年2月6日 - 下午9:01:08
 */
public class AjaxTimeoutAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

	public AjaxTimeoutAuthenticationEntryPoint(String loginFormUrl) {
		super(loginFormUrl);
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
		if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.write("session-time-out");
			writer.close();
		} else {
			super.commence(request, response, authException);
		}
	}

}
