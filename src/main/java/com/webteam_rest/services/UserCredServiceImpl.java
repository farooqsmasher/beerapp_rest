package com.webteam_rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webteam_rest.dao.UserCredDAO;
import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.UserCred;
import com.webteam_rest.services.exception.BusinessServiceException;

@Service
public class UserCredServiceImpl implements UserCredService {

	@Autowired
	UserCredDAO userCredDAO;

	@Override
	@Transactional
	public void doSaveUserCred(UserCred userCred) throws BusinessServiceException {
		try {
			userCredDAO.saveUserCred(userCred);
		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}

	}

	@Override
	@Transactional
	public List<UserCred> doGetAllUserCred() throws BusinessServiceException {
		List<UserCred> userCredList = null;
		try {
			userCredList = userCredDAO.getAllUserCred();

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return userCredList;
	}

	@Override
	@Transactional
	public UserCred doGetUserCredById(Long id) throws BusinessServiceException {
		UserCred userCred = null;
		try {
			userCred = userCredDAO.getUserCredById(id);
		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}

		return userCred;
	}

	@Override
	@Transactional
	public UserCred doGetUserByUsernamePassword(String userName, String password) throws BusinessServiceException {
		UserCred userCred = null;
		try {
			userCred = userCredDAO.getUserByUsernamePassword(userName, password);

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return userCred;
	}

	@Override
	@Transactional
	public void doEnableUserCredById(Long id) throws BusinessServiceException {
		UserCred userCred = null;
		try {
			userCred = userCredDAO.getUserCredById(id);
			if (userCred != null) {
				userCred.setEnable(1);
				userCredDAO.saveUserCred(userCred);
			}

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
	}

	@Override
	@Transactional
	public UserCred doGetUserByUsername(String userName) throws BusinessServiceException {
		UserCred userCred = null;
		try {
			userCred = userCredDAO.getUserByUsername(userName);

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return userCred;
	}

}
