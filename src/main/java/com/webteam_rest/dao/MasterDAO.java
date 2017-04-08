package com.webteam_rest.dao;

import java.util.List;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.Master;

public interface MasterDAO {
	
	public void saveMaster(Master master) throws DataServiceException;
	List<Master> getAllMasters() throws DataServiceException;
	Master getAllMastersById(Long id) throws DataServiceException;
	Master getAllMastersByUserId(Long userId) throws DataServiceException;
	void updateMaster (Master master) throws DataServiceException;
	void delete (Master master) throws DataServiceException;
	
	

}
