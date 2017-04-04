package com.webteam_rest.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.WorkerSkill;

@Repository
public class WorkerSkillDAOImpl implements WorkerSkillDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void saveWorkerSkill(WorkerSkill wokerSkill) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(wokerSkill);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}

	}

	@Override
	public List<WorkerSkill> getAllWorkerSkills() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From WorkerSkill").getResultList();
	}

	@Override
	public WorkerSkill getAllWorkerByID(Long id) throws DataServiceException {
		try {

			List<WorkerSkill> list = this.sessionFactory.getCurrentSession().createQuery(" From WorkerSkill ws  where ws.id=" + id)
					.getResultList();

			for (WorkerSkill workerSkill : list) {
				return workerSkill;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}

}
