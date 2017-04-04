package com.webteam_rest.services;

import java.util.List;


import com.webteam_rest.model.Job;
import com.webteam_rest.services.exception.BusinessServiceException;

public interface JobService {
	
	void doSaveJob(Job job) throws BusinessServiceException;
	List<Job> doGetAllJobs() throws BusinessServiceException;
	Job dogetAllJobsById(Long Id) throws BusinessServiceException;
	void doUpdate (Job job) throws BusinessServiceException;
	void doDelete (Job job) throws BusinessServiceException;
	List<Job> doGetAllJobsByMaster(Long id) throws BusinessServiceException;
	

}
