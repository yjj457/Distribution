package com.distribution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribution.dao.UserMapper;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	
	/**
	 * 通过用户名获取店仓ID
	 * @param usernm
	 * @return
	 */
	public String getOrgIdByUserNm(String usernm){
		return userMapper.getOrgIdByUserNm(usernm);
	}
}
