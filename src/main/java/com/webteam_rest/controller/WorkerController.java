package com.webteam_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webteam_rest.controller.util.ServiceResponseUtils;
import com.webteam_rest.model.UserCred;
import com.webteam_rest.model.Worker;
import com.webteam_rest.services.UserCredService;
import com.webteam_rest.services.WorkerService;
import com.webteam_rest.services.exception.BusinessServiceException;
import com.webteam_rest.util.FileUtil;
import com.webteam_rest.util.StringUtil;
import com.webteam_rest.vo.ServiceResponse;

@Controller

@RequestMapping("/worker")

public class WorkerController {
	@Autowired
	WorkerService workerService;
	
	@Autowired
	UserCredService userCredService;
	
	FileUtil fileUtil = new FileUtil();
	StringUtil stringUtil = new StringUtil();
	
	@Value("${files_location}")
	private String rootDirectory;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ServiceResponse saveCC(@RequestBody Worker worker) {
		ServiceResponse serviceResponse = null;
		try {
			UserCred userCred= userCredService.doGetUserByUsername(worker.getEmailId());
			
			if(userCred==null){
			workerService.doSaveWorker(worker);
			serviceResponse = ServiceResponseUtils.dataResponse("1", "data saved successfully", worker);
			}else{
			serviceResponse = ServiceResponseUtils.dataResponse("3", "username already exists", null);
			}
			
		} catch (BusinessServiceException e) {
			// e.printStackTrace();
			serviceResponse = ServiceResponseUtils.dataResponse("0", e.toString(), null);

		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return serviceResponse;

	}

	

	}
	

