package com.school.scheduling.serviceimplementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.scheduling.entity.Teacher;
import com.school.scheduling.entity.Teacher_Schedule;
import com.school.scheduling.repository.TeacherSchedule_Repository;
import com.school.scheduling.service.Services;

@Service
@Transactional
public class TeacherScheduleService_Impl implements Services<Teacher_Schedule> {
	
	private TeacherSchedule_Repository repo;
	
	@Autowired
	public TeacherScheduleService_Impl(TeacherSchedule_Repository repo) {
		
		this.repo = repo;
	}

	
	
	@Override
	public List<Teacher_Schedule> findAll() {
		
		return repo.findAll();
	}

	@Override
	public Teacher_Schedule findbyId(int theId) {
		Optional<Teacher_Schedule> result = repo.findById(theId);
		return result.isPresent()? result.get():null;
	}

	@Override
	public void save(Teacher_Schedule t) {
		
		repo.save(t);
		
	}

	@Override
	public void deleteById(int theId) {
		repo.deleteById(theId);
		
	}



	@Override
	public void delete(Teacher_Schedule t) {
		repo.delete(t);
		
	}
	
	
}