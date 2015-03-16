package com.distribution.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.distribution.dao.UserMapper;
import com.distribution.entity.UserEntity;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private UserMapper userMapper;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {

		UserDetails user = null;

		try {

			// 搜索数据库以匹配用户登录名.
			// 我们可以通过dao使用JDBC来访问数据库
			UserEntity userEntity = userMapper.getUserLevel(username);
			
			logger.info("username:" + userEntity.getUser_nm());
			logger.info("pwd:" + userEntity.getUser_pwd());
			logger.info("access:" + userEntity.getUser_access());
			// Populate the Spring User object with details from the dbUser
			// Here we just pass the username, password, and access level
			// getAuthorities() will translate the access level to the correct
			// role type

			user = new User(userEntity.getUser_nm(), userEntity.getUser_pwd()
					.toLowerCase(), true, true, true, true,
					getAuthorities(userEntity.getUser_access()));
			
		} catch (Exception e) {
			logger.error("Error in retrieving user");
			throw new UsernameNotFoundException("Error in retrieving user");
		}

		return user;
	}
	/**
	 * 设置访问角色权限
	 * 
	 * @param access
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public Collection<GrantedAuthority> getAuthorities(Integer access) {

		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

		// 所有的用户默认拥有ROLE_USER权限
//		if(access.compareTo(0) == 0){
			authList.add(new GrantedAuthorityImpl("ROLE_USER"));
//		}
		// 如果参数access为-1.则拥有ROLE_BOSS权限
		if (access.compareTo(-1) == 0) {
			authList.add(new GrantedAuthorityImpl("ROLE_BOSS"));
		}
		// 如果参数access为1.则拥有ROLE_SHOP权限
		if (access.compareTo(1) == 0) {
			authList.add(new GrantedAuthorityImpl("ROLE_SHOP"));
		}
		// 如果参数access为2.则拥有ROLE_INV权限
		if (access.compareTo(2) == 0) {
			authList.add(new GrantedAuthorityImpl("ROLE_INV"));
		}
		// 如果参数access为3.则拥有ROLE_PRO权限
		if (access.compareTo(3) == 0) {
			authList.add(new GrantedAuthorityImpl("ROLE_PRO"));
		}
		return authList;
	}
}
