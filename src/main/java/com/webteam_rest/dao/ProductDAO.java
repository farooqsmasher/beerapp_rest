package com.webteam_rest.dao;

import java.util.List;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.Product;

public interface ProductDAO {
	
	void saveProduct(Product product) throws DataServiceException;
	List<Product> getAllProducts() throws DataServiceException;
	Product getProductById(Long Id) throws DataServiceException;
	void update (Product product) throws DataServiceException;
	void delete (Product product) throws DataServiceException;
	

}
