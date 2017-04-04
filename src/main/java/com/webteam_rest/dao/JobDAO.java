package com.webteam_rest.dao;

import java.util.List;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.Job;

public interface JobDAO {
	
	void saveJob(Job job) throws DataServiceException;
	List<Job> getAllJobs() throws DataServiceException;
	Job getAllJobsById(Long Id) throws DataServiceException;
	void update (Job job) throws DataServiceException;
	void delete (Job job) throws DataServiceException;
	List<Job> getAllJobsByMaster(Long id) throws DataServiceException;
	

}
