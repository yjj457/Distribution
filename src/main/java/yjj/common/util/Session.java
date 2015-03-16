package yjj.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * 操作session
 * @author yinjianjun
 *
 */

public class Session {
	
	
	/**
	 * 写入用户名密码
	 * @param request
	 */
	public void setUserSession(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		session.setAttribute("username", request.getAttribute("username"));
		session.setAttribute("password", request.getAttribute("password"));
	}
}
