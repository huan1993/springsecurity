package com.huan.springsecurity.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

/**
 * 用户对象
 * 
 * @描述
 * @作者 huan
 * @时间 2017年5月30日 - 下午2:43:57
 */
public class User extends org.springframework.security.core.userdetails.User {

	public User(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	private static final long serialVersionUID = 6693462359789589590L;

}
