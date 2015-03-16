package com.distribution.dao;

import com.distribution.entity.UserEntity;

public interface UserMapper {
	public UserEntity getUserLevel(String username);
	
	/**
	 * 通过用户名获取店仓ID
	 * @param usernm
	 * @return 店仓ID
	 */
	public String getOrgIdByUserNm(String usernm);
}
