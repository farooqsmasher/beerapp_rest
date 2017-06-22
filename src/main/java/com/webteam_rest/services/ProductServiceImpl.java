package com.webteam_rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webteam_rest.dao.ProductDAO;
import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.Product;
import com.webteam_rest.services.exception.BusinessServiceException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDAO;
	
	
	@Override
	@Transactional
	public void doSaveProduct(Product product) throws BusinessServiceException {
		try{
			productDAO.saveProduct(product);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
	}

	
	@Override
	@Transactional
	public Product doGetProductById(Long id) throws BusinessServiceException {
		Product product =null;
		try{
			product = productDAO.getProductById(id);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
		return product;
	}

	@Override
	@Transactional
	public void doUpdate(Product product) throws BusinessServiceException {
		try{
			productDAO.update(product);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
	
	}

	@Override
	@Transactional
	public void doDelete(Product product) throws BusinessServiceException {
		// TODO Auto-generated method stub
		
	}


	@Override
	@Transactional
	public List<Product> doGetAllProducts() throws BusinessServiceException {
		List<Product> products =null;
		try{
			products = productDAO.getAllProducts();
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
		return products;
	}

	
	
	
}
