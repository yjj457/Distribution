package com.distribution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.distribution.dao.UserMapper;
import com.distribution.entity.TableReport;
import com.distribution.entity.UserEntity;

@Controller
@RequestMapping("auth")
public class LoginLogoutController {
	private static final Logger logger = LoggerFactory.getLogger(LoginLogoutController.class);
	
	@Autowired
	private UserMapper userMapper;

	/**
	 * 指向登录页面
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(
			@RequestParam(value = "error", required = false) boolean error,
			ModelMap model) {

		System.out.println("Received request to show login page");

		if (error == true) {
			// Assign an error message
			model.put("error",
					"You have entered an invalid username or password!");
		} else {
			model.put("error", "");
		}
		return "loginpage";
			
	}
	
	/**
	 * 
	 * logout和check为spring-security.xml中配置的登出命令不写在Controller层中
	 * 
	 */
	
	
	
	/**
	 * 指定无访问额权限页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String getDeniedPage() {

		System.out.println("Received request to show denied page");

		return "deniedpage";

	}
	
	
	
	
	@RequestMapping(value = "/testmybatis")
	public String testmybatis() {
		logger.info("111");
		UserEntity userEneity = userMapper.getUserLevel("yjj");
		System.out.println(userEneity.getUser_access());
		return "deniedpage";

	}
	
	
}