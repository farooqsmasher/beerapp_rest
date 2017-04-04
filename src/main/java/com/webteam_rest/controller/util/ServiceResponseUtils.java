package com.webteam_rest.controller.util;

import java.io.Serializable;

import com.webteam_rest.vo.ServiceResponse;

public class ServiceResponseUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static ServiceResponse serviceResponse;
	
	 public static ServiceResponse dataResponse(String code, String description, Object type) {
		    serviceResponse = new ServiceResponse();
		    serviceResponse.setStatusCode(code);
		    serviceResponse.setDescription(description);
		    serviceResponse.setData(type);
		    return serviceResponse;

		  }

}
