package com.webteam_rest.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.Worker;

@Repository
public class WorkerDAOImpl implements WorkerDAO{
	
	@Autowired
    SessionFactory sessionFactory;
	@Override
	public void saveWorker(Worker worker) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(worker);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}

	}

	@Override
	public List<Worker> getAllWorkers() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From Worker").getResultList();
	}

	@Override
	public Worker getAllworkerById(Long id) throws DataServiceException {
		try {

			List<Worker> list = this.sessionFactory.getCurrentSession().createQuery(" From Worker w  where w.id=" + id)
					.getResultList();

			for (Worker worker : list) {
				return worker;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}

	@Override
	public void update(Worker worker) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().merge(worker);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
		
	}

	@Override
	public void delete(Worker worker) throws DataServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Worker getAllworkerByUserId(Long userId) throws DataServiceException {
		try {

			List<Worker> list = this.sessionFactory.getCurrentSession().createQuery(" From Worker w  where w.user.id=" + userId)
					.getResultList();

			for (Worker worker : list) {
				return worker;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}

}
