package com.webteam_rest.controller;

import java.util.List;

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
import com.webteam_rest.model.Job;
import com.webteam_rest.services.JobService;
import com.webteam_rest.services.exception.BusinessServiceException;
import com.webteam_rest.util.FileUtil;
import com.webteam_rest.util.StringUtil;
import com.webteam_rest.vo.JobSkillsVO;
import com.webteam_rest.vo.ServiceResponse;

@Controller

@RequestMapping("/secure/job")

public class JobController {
	@Autowired
	JobService jobService;
	
	FileUtil fileUtil = new FileUtil();
	StringUtil stringUtil = new StringUtil();
	
	@Value("${files_location}")
	private String rootDirectory;
	
	@RequestMapping(value = "/post", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ServiceResponse saveCC(@RequestBody Job job) {
		ServiceResponse serviceResponse = null;
		try {
			jobService.doSaveJob(job);

			serviceResponse = ServiceResponseUtils.dataResponse("1", "data saved successfully", job);

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
			List<JobSkillsVO> jobList = jobService.doGetAllJobs();
			serviceResponse = ServiceResponseUtils.dataResponse("1", "data retrived successfully", jobList);

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
	public @ResponseBody ServiceResponse getJobListByMaster(@PathVariable(value = "id") Long id) {
		ServiceResponse serviceResponse = null;
		try {
			List<JobSkillsVO> JobSkillsVOList = jobService.doGetAllJobsByMaster(id);
			serviceResponse = ServiceResponseUtils.dataResponse("1", "data retrived successfully", JobSkillsVOList);

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
	

