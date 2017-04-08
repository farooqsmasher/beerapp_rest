package com.webteam_rest.dao;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.UserToken;

public interface UserTokenDAO {
	
	void saveUserToken(UserToken userToken) throws DataServiceException;
	void deleteUserToken(Long userId) throws DataServiceException;
	UserToken getUserToken(UserToken userToken) throws DataServiceException;
	
}
