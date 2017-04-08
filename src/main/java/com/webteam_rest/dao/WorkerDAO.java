package com.webteam_rest.dao;

import java.util.List;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.Worker;

public interface WorkerDAO {
	
	void saveWorker(Worker worker) throws DataServiceException;
	List<Worker> getAllWorkers() throws DataServiceException;
	Worker getAllworkerById(Long id) throws DataServiceException;
	Worker getAllworkerByUserId(Long userId) throws DataServiceException;
	void update (Worker worker) throws DataServiceException;
	void delete (Worker worker) throws DataServiceException;
	

}
