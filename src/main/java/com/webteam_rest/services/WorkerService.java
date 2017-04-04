package com.webteam_rest.services;

import java.util.List;

import com.webteam_rest.model.Worker;
import com.webteam_rest.services.exception.BusinessServiceException;

public interface WorkerService {

	void doSaveWorker(Worker worker) throws BusinessServiceException;
	List<Worker> doGetAllWorker() throws BusinessServiceException;
	Worker dogetWorkerById(Long id)throws BusinessServiceException;
	void doUpdate(Worker worker)throws BusinessServiceException;
	void doDelete(Worker worker)throws BusinessServiceException;
	
}
