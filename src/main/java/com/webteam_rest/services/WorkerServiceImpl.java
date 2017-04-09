package com.webteam_rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webteam_rest.dao.UserCredDAO;
import com.webteam_rest.dao.WorkerDAO;
import com.webteam_rest.dao.WorkerSkillDAO;
import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.Skill;
import com.webteam_rest.model.Worker;
import com.webteam_rest.model.WorkerSkill;
import com.webteam_rest.services.exception.BusinessServiceException;
import com.webteam_rest.util.EmailUtil;

@Service

public class WorkerServiceImpl implements WorkerService {
	
	@Autowired
	WorkerDAO workerDAO;
	
	@Autowired
	WorkerSkillDAO workerSkillDAO;
	
	@Autowired
	UserCredDAO userCredDAO;
	
	@Value("${gmail_username}")
	private String gmailUsername;

	@Value("${gmail_password}")
	private String gmailPassword;


	@Override
	@Transactional
	public void doSaveWorker(Worker worker) throws BusinessServiceException {
		try{
			worker.getUser().setUserName(worker.getEmailId());
			worker.getUser().setEnable(0);
			worker.getUser().setRole("W");
			userCredDAO.saveUserCred(worker.getUser());
			workerDAO.saveWorker(worker);
			EmailUtil emailUtil = new EmailUtil();
			emailUtil.setCredentials(gmailUsername, gmailPassword);
			try {
				emailUtil.generateAndSendGmailEmail(worker.getEmailId(), "Get Your File",
						"file name : " );
			} catch (Exception e) {

			}
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
	}

	@Override
	@Transactional
	public List<Worker> doGetAllWorker() throws BusinessServiceException {
		List<Worker> workerList = null;
		try {
			workerList = workerDAO.getAllWorkers();

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return workerList;
	}

	@Override
	@Transactional
	public Worker dogetWorkerById(Long id) throws BusinessServiceException {
		Worker worker =null;
		try{
			worker = workerDAO.getAllworkerById(id);
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
		return worker;
	}

	@Override
	@Transactional
	public void doUpdate(Worker worker) throws BusinessServiceException {
		try{
			workerDAO.update(worker);
			for(Skill skill : worker.getSkills()){
				WorkerSkill workerSkill = new WorkerSkill();
				workerSkill.setWorker(worker);
				workerSkill.setSkill(skill);
				workerSkillDAO.saveWorkerSkill(workerSkill);
			}
			userCredDAO.saveUserCred(worker.getUser());
		}catch(DataServiceException dataServiceException){
			throw new BusinessServiceException(dataServiceException.getMessage(),dataServiceException);
		}
		
	}

	@Override
	public void doDelete(Worker worker) throws BusinessServiceException {
		// TODO Auto-generated method stub
		
	}

	
	
}
