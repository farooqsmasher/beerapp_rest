package com.webteam_rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webteam_rest.dao.JobDAO;
import com.webteam_rest.dao.JobSkillDAO;
import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.Job;
import com.webteam_rest.model.JobSkill;
import com.webteam_rest.model.Skill;
import com.webteam_rest.services.exception.BusinessServiceException;
import com.webteam_rest.vo.JobSkillsVO;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	JobDAO jobDAO;
	
	@Autowired
	JobSkillDAO jobSkillDAO;
	
	@Override
	@Transactional
	public void doSaveJob(Job job) throws BusinessServiceException {
		try{
			jobDAO.saveJob(job);
			for(JobSkill jobSkillIte:job.getJobSkills()){
				JobSkill jobSkill =new JobSkill();
				jobSkill.setJob(job);
				jobSkill.setSkill(jobSkillIte.getSkill());
				jobSkillDAO.saveJobSkill(jobSkill);
			}
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
	}

	@Override
	@Transactional
	public List<JobSkillsVO> doGetAllJobs() throws BusinessServiceException {
		List<Job> jobList = null;
		List<JobSkill> jobSkillList = null;
		List<JobSkillsVO> JobSkillsVOs = new ArrayList<JobSkillsVO>();
		try {
			jobList = jobDAO.getAllJobs();
			jobSkillList = jobSkillDAO.getAllJobSkills();
			for(Job job : jobList){
				JobSkillsVO jobSkillsVO = new JobSkillsVO();
				jobSkillsVO.setJob(job);
				List<Skill> skills = new ArrayList<Skill>();
				for(JobSkill jobSkill : jobSkillList){
					if(job.getId().equals(jobSkill.getJob().getId())){
						skills.add(jobSkill.getSkill());
					}
				}
				jobSkillsVO.setSkills(skills);
				JobSkillsVOs.add(jobSkillsVO);
			}
		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return JobSkillsVOs;
	}
	
	@Override
	@Transactional
	public List<JobSkillsVO> doGetAllJobsByMaster(Long id) throws BusinessServiceException {
		List<Job> jobList = null;
		List<JobSkill> jobSkillList = null;
		List<JobSkillsVO> JobSkillsVOs = new ArrayList<JobSkillsVO>();
		try {
			jobList = jobDAO.getAllJobsByMaster(id);
			jobSkillList = jobSkillDAO.getAllJobSkills();
			for(Job job : jobList){
				JobSkillsVO jobSkillsVO = new JobSkillsVO();
				jobSkillsVO.setJob(job);
				List<Skill> skills = new ArrayList<Skill>();
				for(JobSkill jobSkill : jobSkillList){
					if(job.getId().equals(jobSkill.getJob().getId())){
						skills.add(jobSkill.getSkill());
					}
				}
				jobSkillsVO.setSkills(skills);
				JobSkillsVOs.add(jobSkillsVO);
			}
		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return JobSkillsVOs;
	}

	@Override
	@Transactional
	public Job dogetAllJobsById(Long Id) throws BusinessServiceException {
		Job job =null;
		try{
			job = jobDAO.getAllJobsById(Id);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
		return job;
	}

	@Override
	@Transactional
	public void doUpdate(Job job) throws BusinessServiceException {
		try{
			jobDAO.update(job);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
	
	}

	@Override
	@Transactional
	public void doDelete(Job job) throws BusinessServiceException {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
