package com.webteam_rest.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.webteam_rest.controller.util.ServiceResponseUtils;
import com.webteam_rest.model.Product;
import com.webteam_rest.services.ProductService;
import com.webteam_rest.services.exception.BusinessServiceException;
import com.webteam_rest.util.FileUtil;
import com.webteam_rest.util.StringUtil;
import com.webteam_rest.vo.ServiceResponse;

@Controller

@RequestMapping("/product")

public class ProductController {
	static final Logger logger = Logger.getLogger(ProductController.class);
	@Autowired
	ProductService productService;
	
	FileUtil fileUtil = new FileUtil();
	StringUtil stringUtil = new StringUtil();
	
	@Value("${files_location}")
	private String rootDirectory;
	
	@RequestMapping(value = "/post", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ServiceResponse saveCC(@RequestBody Product product) {
		ServiceResponse serviceResponse = null;
		try {
			
			logger.info("Enter the information------!");
			productService.doSaveProduct(product);

			serviceResponse = ServiceResponseUtils.dataResponse("202 ok", "data saved successfully", product);
			logger.info("information Saved sucessfully!");
		} catch (BusinessServiceException e) {
			// e.printStackTrace();
			serviceResponse = ServiceResponseUtils.dataResponse("0", e.toString(), null);

		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return serviceResponse;

	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getCourierBoys() {
		ServiceResponse serviceResponse = null;
		try {
			logger.info("listing the product----!");
			
			List<Product> productList = productService.doGetAllProducts();
			serviceResponse = ServiceResponseUtils.dataResponse("202ok", "data retrived successfully", productList);
			logger.info("listed sucessfully");
		} catch (BusinessServiceException e) {
			// e.printStackTrace();
			serviceResponse = ServiceResponseUtils.dataResponse("0", e.toString(), null);

		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return serviceResponse;

	}

	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getProductListByMaster(@PathVariable(value = "id") Long id) {
		ServiceResponse serviceResponse = null;
		try {
			Product product = productService.doGetProductById(id);
			serviceResponse = ServiceResponseUtils.dataResponse("1", "data retrived successfully", product);

		} catch (BusinessServiceException e) {
			// e.printStackTrace();
			serviceResponse = ServiceResponseUtils.dataResponse("0", e.toString(), null);

		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return serviceResponse;

	}



	}
	

