package com.webteam_rest.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.UserCred;

@Repository
public class UserCredDAOImpl implements UserCredDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveUserCred(UserCred userCred) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(userCred);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}

	}

	@Override
	public List<UserCred> getAllUserCred() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From UserCred").getResultList();
	}

	@Override
	public UserCred getUserCredById(Long id) throws DataServiceException {
		try {

			List<UserCred> list = this.sessionFactory.getCurrentSession()
					.createQuery(" From UserCred u  where u.id=" + id).getResultList();

			for (UserCred userCred : list) {
				return userCred;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}

	@Override
	public UserCred getUserByUsernamePassword(String userName, String password) throws DataServiceException {
		try {

			List<UserCred> list = this.sessionFactory.getCurrentSession()
					.createQuery(
							" From UserCred u where u.userName='" + userName + "' and u.password='" + password + "'")
					.getResultList();

			for (UserCred userCred : list) {
				return userCred;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}

	@Override
	@Transactional
	public UserCred getUserByUsername(String userName) throws DataServiceException {
		try {

			List<UserCred> list = this.sessionFactory.getCurrentSession()
					.createQuery(
							" From UserCred u where u.userName='" + userName + "'")
					.getResultList();

			for (UserCred userCred : list) {
				return userCred;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;

	}

}
