package com.webteam_rest.services;

import java.util.List;


import com.webteam_rest.model.Skill;
import com.webteam_rest.services.exception.BusinessServiceException;

public interface SkillService {
	
	void doSaveSkill (Skill skill) throws BusinessServiceException;
	List<Skill> doGetAllskills() throws BusinessServiceException;
	Skill doGetAllSkillsById(Long id) throws BusinessServiceException;
	

}
