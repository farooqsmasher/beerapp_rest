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
import com.webteam_rest.model.Master;
import com.webteam_rest.model.UserCred;
import com.webteam_rest.services.MasterService;
import com.webteam_rest.services.UserCredService;
import com.webteam_rest.services.exception.BusinessServiceException;
import com.webteam_rest.util.FileUtil;
import com.webteam_rest.util.StringUtil;
import com.webteam_rest.vo.ServiceResponse;

@Controller

@RequestMapping("/master")

public class MasterController {

	@Autowired
	MasterService masterService;

	@Autowired
	UserCredService userCredService;

	FileUtil fileUtil = new FileUtil();
	StringUtil stringUtil = new StringUtil();

	@Value("${files_location}")
	private String rootDirectory;

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ServiceResponse saveCC(@RequestBody Master master) {
		ServiceResponse serviceResponse = null;
		try {
			UserCred userCred = userCredService.doGetUserByUsername(master.getCompanyEmail());
			if (userCred == null) {
				masterService.doSaveMaster(master);
				serviceResponse = ServiceResponseUtils.dataResponse("1", "data saved successfully", master);
			} else {
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
