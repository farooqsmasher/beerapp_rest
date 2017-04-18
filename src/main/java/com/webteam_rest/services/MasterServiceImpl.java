package com.webteam_rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webteam_rest.dao.MasterDAO;
import com.webteam_rest.dao.UserCredDAO;
import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.Master;
import com.webteam_rest.services.exception.BusinessServiceException;
import com.webteam_rest.util.EmailUtil;
import com.webteam_rest.util.GAUtil;
import com.webteam_rest.util.GAUtil.GA_EventAction;

@Service
public class MasterServiceImpl implements MasterService {

	@Autowired
	MasterDAO masterDAO;

	@Autowired
	UserCredDAO userCredDAO;

	@Value("${gmail_username}")
	private String gmailUsername;

	@Value("${gmail_password}")
	private String gmailPassword;

	@Value("${google.analytics.url}")
	private String gaURL;

	@Value("${google.analytics.trackingId}")
	private String trackingId;

	@Override
	@Transactional
	public void doSaveMaster(Master master) throws BusinessServiceException {
		try {
			EmailUtil emailUtil = new EmailUtil();
			master.getUser().setUserName(master.getCompanyEmail());
			master.getUser().setEnable(0);
			master.getUser().setRole("M");
			userCredDAO.saveUserCred(master.getUser());
			masterDAO.saveMaster(master);
			emailUtil.setCredentials(gmailUsername, gmailPassword);
			try {
				String imgSrc = GAUtil.buildEventUrl(GA_EventAction.opened, master.getCompanyEmail(),"test", "test", "test", gaURL, trackingId);
				String img = "<img src=\""+imgSrc+"\"' width=1 height=1>";
				
				emailUtil.generateAndSendGmailEmail(master.getCompanyEmail(), "Welcome To Webteam", img);
				GAUtil.sendEvent(GA_EventAction.sent, master.getCompanyEmail(), "test", "test", "test", gaURL, trackingId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}

	}

	@Override
	@Transactional
	public List<Master> dogetAllMasters() throws BusinessServiceException {
		List<Master> masterList = null;
		try {
			masterList = masterDAO.getAllMasters();

		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}
		return masterList;
	}

	@Override
	@Transactional
	public Master dogetAllMasterById(Long id) throws BusinessServiceException {
		Master master = null;
		try {
			master = masterDAO.getAllMastersById(id);
		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}

		return master;
	}

	@Override
	@Transactional
	public void doDelete(Master master) throws BusinessServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void doUpdate(Master master) throws BusinessServiceException {
		try {
			userCredDAO.saveUserCred(master.getUser());
			masterDAO.updateMaster(master);
		} catch (DataServiceException dataServiceException) {
			throw new BusinessServiceException(dataServiceException.getMessage(), dataServiceException);
		}

	}

}
