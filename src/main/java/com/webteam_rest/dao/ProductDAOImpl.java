package com.webteam_rest.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveProduct(Product product) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().saveOrUpdate(product);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}

	}

	@Override
	public List<Product> getAllProducts() throws DataServiceException {
		return this.sessionFactory.getCurrentSession().createQuery(" From Product").getResultList();
	}
	
	
	

	@Override
	public Product getProductById(Long id) throws DataServiceException {
		try {

			List<Product> list = this.sessionFactory.getCurrentSession().createQuery(" From Product j  where j.id=" + id)
					.getResultList();

			for (Product product : list) {
				return product;
			}
		} catch (DataAccessException e) {
			throw new DataServiceException("data retrieval fail", e);
		}
		return null;
	}

	@Override
	public void update(Product product) throws DataServiceException {
		try {
			this.sessionFactory.getCurrentSession().merge(product);
		} catch (DataAccessException dataAccessException) {
			throw new DataServiceException("data insert fail", dataAccessException);
		}

	}

	@Override
	public void delete(Product product) throws DataServiceException {
		// TODO Auto-generated method stub

	}

}
