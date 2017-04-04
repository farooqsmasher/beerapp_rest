package com.webteam_rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webteam_rest.dao.BiddingDAO;
import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.Bidding;
import com.webteam_rest.services.exception.BusinessServiceException;

@Service
public class BiddingServiceImpl implements BiddingService {

	@Autowired
	BiddingDAO biddingDAO;
	
	@Override
	@Transactional
	public void doSaveBidding(Bidding bidding) throws BusinessServiceException {
		try{
			biddingDAO.saveBidding(bidding);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
	}

	@Override
	@Transactional
	public List<Bidding> doGetAllBiddings() throws BusinessServiceException {
		List<Bidding> biddingList = null;
		try {
			biddingList = biddingDAO.getAllBiddings();

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return biddingList;
	}

	@Override
	@Transactional
	public Bidding dogetAllBiddingsById(Long Id) throws BusinessServiceException {
		Bidding bidding =null;
		try{
			bidding = biddingDAO.getAllBiddingsById(Id);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
		return bidding;
	}

	@Override
	@Transactional
	public void doUpdate(Bidding bidding) throws BusinessServiceException {
		try{
			biddingDAO.update(bidding);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
	
	}

	@Override
	@Transactional
	public void doDelete(Bidding bidding) throws BusinessServiceException {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
