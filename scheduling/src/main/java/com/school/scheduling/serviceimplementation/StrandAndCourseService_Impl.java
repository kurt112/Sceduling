package com.school.scheduling.serviceimplementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.school.scheduling.entity.StrandAndCourse;
import com.school.scheduling.repository.StrandAndCourse_Repository;
import com.school.scheduling.service.Services;

@Transactional
@Service
public class StrandAndCourseService_Impl implements Services<StrandAndCourse>{
	
	private StrandAndCourse_Repository repo;

	public StrandAndCourseService_Impl(StrandAndCourse_Repository repo) {
		this.repo = repo;
	}

	@Override
	public List<StrandAndCourse> findAll() {
		return repo.findAll();
	}

	@Override
	public StrandAndCourse findbyId(int theId) {
		Optional<StrandAndCourse> result = repo.findById(theId);
		
		return result.isPresent()? result.get(): null;
	}

	@Override
	public void save(StrandAndCourse t) {
		repo.save(t);
	}

	@Override
	public void deleteById(int theId) {
		repo.deleteById(theId);
	}

	@Override
	public void delete(StrandAndCourse t) {
		repo.delete(t);
		
	}
	
	
	
	
	
	
}
