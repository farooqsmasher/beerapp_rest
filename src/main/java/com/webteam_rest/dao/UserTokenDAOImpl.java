package com.webteam_rest.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.UserToken;

@Repository
public class UserTokenDAOImpl implements UserTokenDAO {

	@Autowired
	SessionFactory sessionFactory;

	
	@Transactional
	@Override
	public void saveUserToken(UserToken userToken) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(userToken);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
	}

	@Transactional
	@Override
	public void deleteUserToken(Long userId) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession()
			.createQuery(" delete UserToken u  where u.userId=" +userId).executeUpdate();
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data delete fail", dataAccessException);
		}
		
	}

	@Transactional
	@Override
	public UserToken getUserToken(UserToken userToken) throws DataServiceException {
		try {

			List<UserToken> list = this.sessionFactory.getCurrentSession()
					.createQuery(" From UserToken u  where u.userId=" +userToken.getUserId()+" and u.token='"+userToken.getToken()+"'").getResultList();

			for (UserToken ite : list) {
				return ite;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}

}
