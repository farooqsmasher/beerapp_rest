package com.webteam_rest.services;

import java.util.List;


import com.webteam_rest.model.WorkerSkill;
import com.webteam_rest.services.exception.BusinessServiceException;

public interface WorkerSkillService {
	void doSaveWorkerSkill (WorkerSkill wokerSkill) throws BusinessServiceException;
	List<WorkerSkill> doGetAllWorkerSkills() throws BusinessServiceException;
	WorkerSkill doGetAllWorkerByID(Long id) throws BusinessServiceException;

}
