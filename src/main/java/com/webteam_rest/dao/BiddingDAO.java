package com.webteam_rest.dao;

import java.util.List;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.Bidding;

public interface BiddingDAO {
	
	void saveBidding(Bidding bidding) throws DataServiceException;
	List<Bidding> getAllBiddings() throws DataServiceException;
	Bidding getAllBiddingsById(Long Id) throws DataServiceException;
	void update (Bidding bidding) throws DataServiceException;
	void delete (Bidding bidding) throws DataServiceException;
	

}
