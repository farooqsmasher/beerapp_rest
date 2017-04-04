package com.webteam_rest.vo;

public class ServiceResponse {
	
	private String statusCode;
	private String description;
	private Object data;
	
	
	public ServiceResponse(){
		
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	

	
}
