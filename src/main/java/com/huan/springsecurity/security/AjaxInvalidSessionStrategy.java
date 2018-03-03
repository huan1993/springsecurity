package com.huan.springsecurity.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.session.InvalidSessionStrategy;

/**
 * 处理ajax
 * 
 * @描述
 * @作者 huan
 * @时间 2018年2月6日 - 下午8:50:05
 */
public class AjaxInvalidSessionStrategy implements InvalidSessionStrategy {

	private InvalidSessionStrategy delegate;

	public AjaxInvalidSessionStrategy(InvalidSessionStrategy delegate) {
		this.delegate = delegate;
	}

	@Override
	public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		/**
		 * 如果是ajax请求就返回一个session-time-out的字符串，否则就由传递进来的delegate来进行处理
		 */
		if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.write("session-time-out");
			writer.close();
		} else {
			delegate.onInvalidSessionDetected(request, response);
		}
	}

}
