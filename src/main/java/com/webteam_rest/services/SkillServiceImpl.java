package com.webteam_rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webteam_rest.dao.SkillDAO;
import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.Job;
import com.webteam_rest.model.Skill;
import com.webteam_rest.services.exception.BusinessServiceException;

@Service

public class SkillServiceImpl implements SkillService {
	
	@Autowired
	SkillDAO skillDAO;

	@Override
	@Transactional
	public void doSaveSkill(Skill skill) throws BusinessServiceException {
		try{
			skillDAO.saveSkill(skill);;
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
	}

	@Override
	@Transactional
	public List<Skill> doGetAllskills() throws BusinessServiceException {
		List<Skill> skillList = null;
		try {
			skillList = skillDAO.getAllskills();

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return skillList;
	}

	@Override
	@Transactional
	public Skill doGetAllSkillsById(Long id) throws BusinessServiceException {
		Skill skill =null;
		try{
			skill = skillDAO.getAllSkillsById(id);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
		return skill;
	}

	
}
