package com.webteam_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webteam_rest.controller.util.ServiceResponseUtils;
import com.webteam_rest.dao.MasterDAO;
import com.webteam_rest.dao.UserTokenDAO;
import com.webteam_rest.dao.WorkerDAO;
import com.webteam_rest.model.Master;
import com.webteam_rest.model.UserCred;
import com.webteam_rest.model.UserToken;
import com.webteam_rest.model.Worker;
import com.webteam_rest.services.UserCredService;
import com.webteam_rest.services.exception.BusinessServiceException;
import com.webteam_rest.util.StringUtil;
import com.webteam_rest.vo.ServiceResponse;
import com.webteam_rest.vo.UserVO;

@Controller

@RequestMapping("/user")

public class UserController {
	@Autowired
	UserCredService userService;

	@Autowired
	UserTokenDAO userTokenDAO;
	
	@Autowired
	MasterDAO masterDAO;
	
	@Autowired
	WorkerDAO workerDAO;

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ServiceResponse userLogin(@RequestBody UserCred user) {
		ServiceResponse serviceResponse = null;
		try {
			UserVO userVO = new UserVO();
			UserCred responseUser = userService.doGetUserByUsernamePassword(user.getUserName(), user.getPassword());
			userVO.setUser(responseUser);
			if (responseUser != null) {
				UserToken userToken = new UserToken();
				userToken.setUserId(responseUser.getId());
				StringUtil stringUtil = new StringUtil();
				userToken.setToken(stringUtil.getUniqueString());
				try{
					if(responseUser.getRole().equalsIgnoreCase("M")){
						Master master = masterDAO.getAllMastersByUserId(responseUser.getId());
						userVO.setMaster(master);
					}else{
						Worker worker = workerDAO.getAllworkerByUserId(responseUser.getId());
						userVO.setWorker(worker);
					}
				}catch(Exception ee){
					
				}
				try {
					userTokenDAO.saveUserToken(userToken);
					userVO.setToken(userToken.getToken());
				} catch (Exception ee) {

				}
				responseUser.setPassword(null);
				serviceResponse = ServiceResponseUtils.dataResponse("1", "login success", userVO);
			} else {
				serviceResponse = ServiceResponseUtils.dataResponse("0", "invalid credentials", null);
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

	@RequestMapping(value = "/enable/{id}", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse deleteCC(@PathVariable(value = "id") Long id) {
		ServiceResponse serviceResponse = null;
		try {
			userService.doEnableUserCredById(id);
			serviceResponse = ServiceResponseUtils.dataResponse("1", "user enabled successfully", null);

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

	@RequestMapping(value = "/logout/{userId}", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse logout(@PathVariable(value = "userId") Long id) {
		ServiceResponse serviceResponse = null;
		try {
			userTokenDAO.deleteUserToken(id);
			serviceResponse = ServiceResponseUtils.dataResponse("1", "user logout successfully", null);

		} catch (Exception e) {
			serviceResponse = ServiceResponseUtils.dataResponse("0", e.toString(), null);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return serviceResponse;
	}

}
