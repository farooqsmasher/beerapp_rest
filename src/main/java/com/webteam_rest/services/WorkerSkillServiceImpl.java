package com.webteam_rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webteam_rest.dao.WorkerSkillDAO;
import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.WorkerSkill;
import com.webteam_rest.model.WorkerSkill;
import com.webteam_rest.services.exception.BusinessServiceException;

@Service
public class WorkerSkillServiceImpl implements WorkerSkillService {
	@Autowired
	WorkerSkillDAO workerSkillDAO;
	

	@Override
	@Transactional
	public void doSaveWorkerSkill(WorkerSkill wokerSkill) throws BusinessServiceException {
		try{
			workerSkillDAO.saveWorkerSkill(wokerSkill);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
	}

	@Override
	@Transactional
	public List<WorkerSkill> doGetAllWorkerSkills() throws BusinessServiceException {
		List<WorkerSkill> workerSkillList = null;
		try {
			workerSkillList = workerSkillDAO.getAllWorkerSkills();

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return workerSkillList;
	}

	@Override
	@Transactional
	public WorkerSkill doGetAllWorkerByID(Long id) throws BusinessServiceException {
		WorkerSkill workerSkill =null;
		try{
			workerSkill = workerSkillDAO.getAllWorkerByID(id);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
		return workerSkill;
	}

}
