package com.webteam_rest.vo;

import java.util.List;

import com.webteam_rest.model.Job;
import com.webteam_rest.model.Skill;

public class JobSkillsVO {
	
	private Job job;
	private List<Skill> skills;

	public JobSkillsVO(){
		
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	
}
