package com.webteam_rest.dao;

import java.util.List;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.UserCred;

public interface UserCredDAO {
	
	void saveUserCred(UserCred userCred) throws DataServiceException;
	List<UserCred> getAllUserCred() throws DataServiceException;
	UserCred getUserCredById(Long id) throws DataServiceException;
	UserCred getUserByUsernamePassword(String userName, String password) throws DataServiceException;
	UserCred getUserByUsername(String userName) throws DataServiceException;
}
