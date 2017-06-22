package com.webteam_rest.vo;

import com.webteam_rest.model.UserCred;

public class UserVO {
	private UserCred user;
	private String token;
	
	
	public UserCred getUser() {
		return user;
	}
	public void setUser(UserCred user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
