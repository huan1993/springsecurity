package com.huan.springsecurity.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * 认证成功之后的处理
 * 
 * @描述
 * @作者 huan
 * @时间 2017年5月30日 - 下午3:03:09
 */
public class CustormAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		// 清除最后一次的异常信息
		clearAuthenticationAttributes(request);
		System.out.println("登录成功。。。。");
		getRedirectStrategy().sendRedirect(request, response, determineTargetUrl(request, response));
	}

}
