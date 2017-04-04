package com.webteam_rest.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.JobSkill;

@Repository
public class JobSkillDAOImpl implements JobSkillDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void saveJobSkill(JobSkill wokerSkill) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(wokerSkill);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}

	}

	@Override
	public List<JobSkill> getAllJobSkills() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From JobSkill").getResultList();
	}

	@Override
	public JobSkill getAllJobByID(Long id) throws DataServiceException {
		try {

			List<JobSkill> list = this.sessionFactory.getCurrentSession().createQuery(" From JobSkill ws  where ws.id=" + id)
					.getResultList();

			for (JobSkill jobSkill : list) {
				return jobSkill;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}

}
