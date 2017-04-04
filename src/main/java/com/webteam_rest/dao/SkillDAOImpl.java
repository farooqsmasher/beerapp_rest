package com.webteam_rest.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.Skill;

@Repository
public class SkillDAOImpl implements SkillDAO {
	@Autowired
  SessionFactory sessionFactory;

	@Override
	public void saveSkill(Skill skill) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(skill);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}
	}

	@Override
	public List<Skill> getAllskills() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From Skill").getResultList();
	}

	@Override
	public Skill getAllSkillsById(Long id) throws DataServiceException {
		try {
			List<Skill> list = this.sessionFactory.getCurrentSession().createQuery(" From Skill j  where j.id=" + id)
					.getResultList();

			for (Skill skill : list) {
				return skill;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}

}
