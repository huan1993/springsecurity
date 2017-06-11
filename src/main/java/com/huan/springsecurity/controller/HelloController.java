package com.huan.springsecurity.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 * 
 * @描述
 * @作者 huan
 * @时间 2017年5月30日 - 下午2:20:14
 */
@RestController
public class HelloController {

	@GetMapping("hello")
	public Object hello() {
		Map<String, String> ret = new HashMap<>(2);
		ret.put("hello", "word");
		ret.put("code", "200");
		return ret;
	}

	@GetMapping("world")
	@PreAuthorize("hasRole('ADMIN')")
	public String world() {
		return "拥有ADMIN的角色才可以访问";
	}

	@PreAuthorize("hasRole('xxx')")
	@GetMapping("no-auth")
	public String noAuth() {
		return "no auth";
	}

	/** 显示当前用户 */
	@GetMapping("show-current-user")
	public Authentication showCurrentUser() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

}
