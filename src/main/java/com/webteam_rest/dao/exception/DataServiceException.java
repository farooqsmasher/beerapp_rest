package com.webteam_rest.dao.exception;

public class DataServiceException extends Exception{
	
	private static final long serialVersionUID =1L;
	
	public DataServiceException(){
		super();
	}

	public DataServiceException(String message){
		super(message);
		
	}
	
	public DataServiceException(Throwable exception){
		super(exception);
	}
	
 public DataServiceException(String message,Throwable exception ){
	 super(message, exception);
 }

}
