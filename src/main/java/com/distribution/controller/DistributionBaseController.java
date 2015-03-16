package com.distribution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.distribution.service.UserService;

import yjj.springSecurity.util.Session;

public class DistributionBaseController {
	
	@Autowired
	private UserService userService;
	
	protected String folder(){
		return "Distribution/";
	}
	
	/**
	 * 通过用户名获取店仓ID
	 * @return
	 */
	protected String getOrgIdByUserNm(){
		return userService.getOrgIdByUserNm(new Session().getName());
	}
	
}
