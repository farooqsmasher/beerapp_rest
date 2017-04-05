package com.webteam_rest.services;

import java.util.List;

import com.webteam_rest.model.Job;
import com.webteam_rest.services.exception.BusinessServiceException;
import com.webteam_rest.vo.JobSkillsVO;

public interface JobService {
	
	void doSaveJob(Job job) throws BusinessServiceException;
	List<JobSkillsVO> doGetAllJobs() throws BusinessServiceException;
	Job dogetAllJobsById(Long Id) throws BusinessServiceException;
	void doUpdate (Job job) throws BusinessServiceException;
	void doDelete (Job job) throws BusinessServiceException;
	List<JobSkillsVO> doGetAllJobsByMaster(Long id) throws BusinessServiceException;
	

}
