package com.school.scheduling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.school.scheduling.entity.Teacher;

public interface Teacher_Repository extends JpaRepository<Teacher, Integer> {
	
	public List<Teacher> findAll();
}
