package com.webteam_rest.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.webteam_rest.dao.UserTokenDAO;
import com.webteam_rest.model.UserToken;

@Component
public class RequestHandlerInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	UserTokenDAO userTokenDAO; 
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		UserToken userToken= new UserToken();
		UserToken finalUserToken= null;
		request.getHeaderNames();
		String user = request.getHeader("user");
		String token = request.getHeader("token");
		if(user!=null){
		Long userId = Long.valueOf(user);
		userToken.setUserId(userId);
		userToken.setToken(token);
		finalUserToken = userTokenDAO.getUserToken(userToken);
		if(finalUserToken==null){
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		}else{
			return true;
		}
		}else{
			if(!request.getMethod().equalsIgnoreCase("options"))
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		}
		
	}
}
