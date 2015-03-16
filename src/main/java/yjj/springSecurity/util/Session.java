package yjj.springSecurity.util;

import java.util.Collection;

import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * 使用spring-security时获取用户名密码的工具类
 * @author yinjianjun
 *
 */
public class Session {
	private UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
		    .getAuthentication()
		    .getPrincipal();
	
	public String getName(){
		return this.userDetails.getUsername();
	}
	
	public String getPassowrd(){
		return this.userDetails.getPassword();
	}
	
	public String getString(){
		return this.userDetails.toString();
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return this.userDetails.getAuthorities();
	}
	
	
}
