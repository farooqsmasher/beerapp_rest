package com.webteam_rest.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.Job;

@Repository
public class JobDAOImpl implements JobDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveJob(Job job) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(job);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}

	}

	@Override
	public List<Job> getAllJobs() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From Job").getResultList();
	}
	
	
	@Override
	public List<Job> getAllJobsByMaster(Long id) throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From Job j where j.master.id="+id).getResultList();
	}

	@Override
	public Job getAllJobsById(Long id) throws DataServiceException {
		try {

			List<Job> list = this.sessionFactory.getCurrentSession().createQuery(" From Job j  where j.id=" + id)
					.getResultList();

			for (Job job : list) {
				return job;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}

	@Override
	public void update(Job job) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().merge(job);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}

	}

	@Override
	public void delete(Job job) throws DataServiceException {
		// TODO Auto-generated method stub

	}

}
