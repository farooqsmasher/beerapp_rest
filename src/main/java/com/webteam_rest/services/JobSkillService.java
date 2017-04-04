package com.webteam_rest.services;

import java.util.List;

import com.webteam_rest.model.JobSkill;
import com.webteam_rest.services.exception.BusinessServiceException;

public interface JobSkillService {
	void doSaveJobSkill (JobSkill wokerSkill) throws BusinessServiceException;
	List<JobSkill> doGetAllJobSkills() throws BusinessServiceException;
	JobSkill doGetAllJobByID(Long id) throws BusinessServiceException;

}
