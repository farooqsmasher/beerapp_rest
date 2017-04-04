package com.webteam_rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webteam_rest.dao.JobSkillDAO;
import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.JobSkill;
import com.webteam_rest.model.JobSkill;
import com.webteam_rest.services.exception.BusinessServiceException;

@Service
public class JobSkillServiceImpl implements JobSkillService {
	@Autowired
	JobSkillDAO jobSkillDAO;
	

	@Override
	@Transactional
	public void doSaveJobSkill(JobSkill wokerSkill) throws BusinessServiceException {
		try{
			jobSkillDAO.saveJobSkill(wokerSkill);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
	}

	@Override
	@Transactional
	public List<JobSkill> doGetAllJobSkills() throws BusinessServiceException {
		List<JobSkill> jobSkillList = null;
		try {
			jobSkillList = jobSkillDAO.getAllJobSkills();

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return jobSkillList;
	}

	@Override
	@Transactional
	public JobSkill doGetAllJobByID(Long id) throws BusinessServiceException {
		JobSkill jobSkill =null;
		try{
			jobSkill = jobSkillDAO.getAllJobByID(id);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
		return jobSkill;
	}

}
