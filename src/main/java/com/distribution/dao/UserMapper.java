package com.distribution.dao;

import java.util.List;

import com.distribution.entity.UserEntity;

public interface UserMapper {
	public UserEntity getUserLevel(String username);
}
