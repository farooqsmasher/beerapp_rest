package com.webteam_rest.dao;

import java.util.List;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.JobSkill;

public interface JobSkillDAO {
	
	void saveJobSkill (JobSkill wokerSkill) throws DataServiceException;
	List<JobSkill> getAllJobSkills() throws DataServiceException;
	JobSkill getAllJobByID(Long id) throws DataServiceException;
	

}
