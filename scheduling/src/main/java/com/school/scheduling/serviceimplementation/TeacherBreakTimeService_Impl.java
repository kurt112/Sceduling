package com.school.scheduling.serviceimplementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.scheduling.entity.Teacher_BreakTime;
import com.school.scheduling.entity.Teacher_Schedule;
import com.school.scheduling.repository.TeacherBreakTime_Repository;
import com.school.scheduling.service.Services;

@Service
@Transactional
public class TeacherBreakTimeService_Impl implements Services<Teacher_BreakTime>{
	
	private TeacherBreakTime_Repository repo;

	@Autowired
	public TeacherBreakTimeService_Impl(TeacherBreakTime_Repository repo) {		
		this.repo = repo;
	}

	@Override
	public List<Teacher_BreakTime> findAll() {
		
		return repo.findAll();
	}

	@Override
	public Teacher_BreakTime findbyId(int theId) {
		Optional<Teacher_BreakTime> result = repo.findById(theId);
		return result.isPresent()? result.get(): null;
	}

	@Override
	public void save(Teacher_BreakTime t) {
		repo.save(t);
	}

	@Override
	public void deleteById(int theId) {
		repo.deleteById(theId);
		
	}
	
	
	
	

}
