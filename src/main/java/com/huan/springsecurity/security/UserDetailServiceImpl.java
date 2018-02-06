package com.huan.springsecurity.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 用于获取用户信息
 * 
 * @描述
 * @作者 huan
 * @时间 2017年5月30日 - 下午2:44:44
 */
public class UserDetailServiceImpl implements UserDetailsService {

	private PasswordEncoder passwordEncoder;

	public UserDetailServiceImpl(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("admin".equals(username)) {
			// 用户拥有的权限，此处应该从数据库中查询出来
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("ADMIN"));
			authorities.addAll(AuthorityUtils.createAuthorityList("01", "0102"));
			return new User(username, passwordEncoder.encode("admin"), true, true, true, true, authorities);
		}
		return null;
	}

}
