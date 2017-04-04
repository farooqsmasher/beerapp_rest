package com.webteam_rest.dao;

import java.util.List;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.WorkerSkill;

public interface WorkerSkillDAO {
	
	void saveWorkerSkill (WorkerSkill wokerSkill) throws DataServiceException;
	List<WorkerSkill> getAllWorkerSkills() throws DataServiceException;
	WorkerSkill getAllWorkerByID(Long id) throws DataServiceException;
	

}
