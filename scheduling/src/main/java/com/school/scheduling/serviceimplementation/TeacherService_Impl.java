package com.school.scheduling.serviceimplementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.scheduling.entity.Teacher;
import com.school.scheduling.repository.Teacher_Repository;
import com.school.scheduling.service.Services;

@Service
@Transactional
public class TeacherService_Impl implements Services<Teacher> {
	
	private Teacher_Repository repo;
	
	@Autowired
	public TeacherService_Impl(Teacher_Repository repo) {
		this.repo = repo;
	}
	
	@Override
	public List<Teacher> findAll() {
	
		return repo.findAll();
	}
	
	@Override
	public Teacher findbyId(int theId) {
		Optional<Teacher> result = repo.findById(theId);
		return result.isPresent()? result.get():null;
	}

	@Override
	public void save(Teacher t) {
		repo.save(t);
	}

	@Override
	public void deleteById(int theId) {
		repo.deleteById(theId);
	}

	@Override
	public void delete(Teacher t) {
		
		repo.delete(t);
		
	}
	
	
}
