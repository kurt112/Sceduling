package com.school.scheduling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.school.scheduling.entity.StrandAndCourse;

public interface StrandAndCourse_Repository extends JpaRepository<StrandAndCourse, Integer> {
	
	public List<StrandAndCourse> findAll();
}
