package com.webteam_rest.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.Bidding;

@Repository
public class BiddingDAOImpl implements BiddingDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveBidding(Bidding bidding) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(bidding);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}

	}

	@Override
	public List<Bidding> getAllBiddings() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From Bidding").getResultList();
	}

	@Override
	public Bidding getAllBiddingsById(Long id) throws DataServiceException {
		try {

			List<Bidding> list = this.sessionFactory.getCurrentSession().createQuery(" From Bidding j  where j.id=" + id)
					.getResultList();

			for (Bidding bidding : list) {
				return bidding;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}

	@Override
	public void update(Bidding bidding) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().merge(bidding);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}

	}

	@Override
	public void delete(Bidding bidding) throws DataServiceException {
		// TODO Auto-generated method stub

	}

}
