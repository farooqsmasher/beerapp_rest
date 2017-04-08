package com.webteam_rest.vo;

import com.webteam_rest.model.Master;
import com.webteam_rest.model.UserCred;
import com.webteam_rest.model.Worker;

public class UserVO {
	private UserCred user;
	private String token;
	private Master master;
	private Worker worker;
	public Master getMaster() {
		return master;
	}
	public void setMaster(Master master) {
		this.master = master;
	}
	public Worker getWorker() {
		return worker;
	}
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
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
