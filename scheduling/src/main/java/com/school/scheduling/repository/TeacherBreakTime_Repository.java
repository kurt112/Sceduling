package com.school.scheduling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.school.scheduling.entity.Teacher_BreakTime;

public interface TeacherBreakTime_Repository extends JpaRepository<Teacher_BreakTime, Integer> {
	
	public List<Teacher_BreakTime> findAll();
}
