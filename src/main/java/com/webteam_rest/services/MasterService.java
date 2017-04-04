package com.webteam_rest.services;

import java.util.List;

import com.webteam_rest.model.Master;
import com.webteam_rest.services.exception.BusinessServiceException;

public interface MasterService {
	
	void doSaveMaster (Master master) throws BusinessServiceException;
	
	List<Master> dogetAllMasters() throws BusinessServiceException;
	
	Master dogetAllMasterById(Long id) throws BusinessServiceException;
	
	void doDelete (Master master) throws BusinessServiceException;
	
	void doUpdate (Master master) throws BusinessServiceException;
	

}
