package com.webteam_rest.services;

import java.util.List;


import com.webteam_rest.model.Bidding;
import com.webteam_rest.services.exception.BusinessServiceException;

public interface BiddingService {
	
	void doSaveBidding(Bidding bidding) throws BusinessServiceException;
	List<Bidding> doGetAllBiddings() throws BusinessServiceException;
	Bidding dogetAllBiddingsById(Long Id) throws BusinessServiceException;
	void doUpdate (Bidding bidding) throws BusinessServiceException;
	void doDelete (Bidding bidding) throws BusinessServiceException;
	

}
