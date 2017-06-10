package com.huan.springsecurity.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.AntPathMatcher;

/**
 * 自定义授权策略
 * 
 * @描述
 * @作者 huan
 * @时间 2017年6月10日 - 下午12:07:56
 */
public class CustormSecurityDecision {

	private static final Map<String, List<GrantedAuthority>> urlAuths = new ConcurrentHashMap<>();

	static {
		urlAuths.put("/xx", Arrays.asList(new SimpleGrantedAuthority("A001B001")));
		urlAuths.put("/xx/x", Arrays.asList(new SimpleGrantedAuthority("A001B001")));
		urlAuths.put("/yy", Arrays.asList(new SimpleGrantedAuthority("A001B001")));
		urlAuths.put("/zz", Arrays.asList(new SimpleGrantedAuthority("A001B001")));
	}
	AntPathMatcher pathMatcher = new AntPathMatcher();

	public boolean decision(Authentication authentication, HttpServletRequest request) {
		String uri = request.getRequestURI().replace(request.getContextPath(), "");
		for (Entry<String, List<GrantedAuthority>> entry : urlAuths.entrySet()) {
			if (pathMatcher.match(entry.getKey(), uri)) {
				Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
				for (GrantedAuthority grantedAuthority : authorities) {
					if (entry.getValue().contains(grantedAuthority)) {
						return true;
					}
				}
				return false;
			}
		}

		// 访问的是没有配置权限的功能，必须要登录用户才可以进行访问
		if (authentication.isAuthenticated() && !Objects.equals("anonymousUser", authentication.getPrincipal())) {
			return true;
		}

		// 没有登录，直接返回false
		return false;
	}

}
