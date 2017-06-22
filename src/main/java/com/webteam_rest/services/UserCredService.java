package com.webteam_rest.services;

import java.util.List;


import com.webteam_rest.model.UserCred;
import com.webteam_rest.services.exception.BusinessServiceException;

public interface UserCredService {

	void doSaveUserCred(UserCred userCred) throws BusinessServiceException;
	List<UserCred> doGetAllUserCred() throws BusinessServiceException;
	UserCred doGetUserCredById(Long id) throws BusinessServiceException;
	void doEnableUserCredById(Long id) throws BusinessServiceException;
	UserCred doGetUserByUsernamePassword(String userName, String password) throws BusinessServiceException;
	UserCred doGetUserByUsername(String userName) throws BusinessServiceException;
}
