package com.webteam_rest.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.Master;

@Repository
public class MasterDAOImpl implements MasterDAO{
	
	@Autowired
  SessionFactory sessionFactory;
	

	@Override
	public void saveMaster(Master master) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(master);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
		
	}

	@Override
	public List<Master> getAllMasters() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From Master").getResultList();
	}

	@Override
	public Master getAllMastersById(Long id) throws DataServiceException {
		try {

			List<Master> list = this.sessionFactory.getCurrentSession().createQuery(" From Master m  where m.id=" + id)
					.getResultList();

			for (Master master : list) {
				return master;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;

	}

	@Override
	public void updateMaster(Master master) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().merge(master);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
		
	}

	@Override
	public void delete(Master master) throws DataServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Master getAllMastersByUserId(Long userId) throws DataServiceException {
		try {

			List<Master> list = this.sessionFactory.getCurrentSession().createQuery(" From Master m  where m.user.id=" + userId)
					.getResultList();

			for (Master master : list) {
				return master;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;

	}
	

}
