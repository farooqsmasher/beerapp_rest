package com.webteam_rest.services;

import java.util.List;

import com.webteam_rest.model.Product;
import com.webteam_rest.services.exception.BusinessServiceException;

public interface ProductService {
	
	void doSaveProduct(Product product) throws BusinessServiceException;
	List<Product> doGetAllProducts() throws BusinessServiceException;
	Product doGetProductById(Long Id) throws BusinessServiceException;
	void doUpdate (Product product) throws BusinessServiceException;
	void doDelete (Product product) throws BusinessServiceException;
	
	

}
