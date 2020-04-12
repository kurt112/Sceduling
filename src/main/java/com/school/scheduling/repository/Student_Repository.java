package com.school.scheduling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.school.scheduling.entity.Student;

public interface Student_Repository extends JpaRepository<Student, Integer>{
	
	public List<Student > findAll();
}
