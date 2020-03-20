package com.school.scheduling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.scheduling.entity.BreakTime;

public interface BreakTime_Repository extends JpaRepository<BreakTime, Integer>{
	public List<BreakTime> findAll();
}
