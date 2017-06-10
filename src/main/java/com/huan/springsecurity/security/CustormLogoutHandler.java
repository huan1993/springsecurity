package com.huan.springsecurity.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

/**
 * 系统登出
 * 
 * @描述
 * @作者 huan
 * @时间 2017年6月10日 - 上午9:40:59
 */
public class CustormLogoutHandler implements LogoutHandler {

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		System.out.println("退出系统.......");
	}

}
