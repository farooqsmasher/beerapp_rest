package com.webteam_rest.dao;

import java.util.List;

import com.webteam_rest.dao.exception.DataServiceException;
import com.webteam_rest.model.Skill;

public interface SkillDAO {
	void saveSkill (Skill skill) throws DataServiceException;
	List<Skill> getAllskills() throws DataServiceException;
	Skill getAllSkillsById(Long id) throws DataServiceException;
	

}
