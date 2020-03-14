package com.school.scheduling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.school.scheduling.entity.Teacher_Schedule;

public interface TeacherSchedule_Repository extends JpaRepository<Teacher_Schedule, Integer> {
	
	public List<Teacher_Schedule> findAll();
}
