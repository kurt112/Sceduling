package com.school.scheduling.EntityCombine;

import com.school.scheduling.entity.Subject;

public class StrandSubject {
	private int id;
	private Subject subject;
	private String strandName;
	
	
	public StrandSubject(int id, String strandName ,Subject subject) {
		this.id = id;
		this.subject = subject;
		this.strandName = strandName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public String getStrandName() {
		return strandName;
	}
	public void setStrandName(String strandName) {
		this.strandName = strandName;
	}
	
	
}