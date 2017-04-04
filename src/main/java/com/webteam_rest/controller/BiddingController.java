package com.webteam_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webteam_rest.services.BiddingService;
import com.webteam_rest.util.FileUtil;
import com.webteam_rest.util.StringUtil;

@Controller

@RequestMapping("/bidding")

public class BiddingController {
	@Autowired
	BiddingService jobService;
	
	FileUtil fileUtil = new FileUtil();
	StringUtil stringUtil = new StringUtil();
	
	@Value("${files_location}")
	private String rootDirectory;
	
	



	}
	

