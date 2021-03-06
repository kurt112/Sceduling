package com.school.scheduling.serviceimplementation;

import java.util.List;

import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.scheduling.entity.Subject;
import com.school.scheduling.repository.Subject_Repository;
import com.school.scheduling.service.Services;


@Service
@Transactional
public class SubjectService_Impl implements Services<Subject> {
	
	private Subject_Repository subject_repo ;
	
	@Autowired
	public SubjectService_Impl(Subject_Repository subject_repo) {
		this.subject_repo = subject_repo;
	}

	@Override
	public List<Subject> findAll() {
	
		return subject_repo.findAll();
	}
	
	@Override
	public Subject findbyId(int theId) {
		Optional<Subject> result = subject_repo.findById(theId);
		return result.isPresent()? result.get():null;
	}

	@Override
	public void save(Subject t) {
		subject_repo.save(t);
	}

	@Override
	public void deleteById(int theId) {
		subject_repo.deleteById(theId);
	}

	@Override
	public void delete(Subject t) {
		subject_repo.delete(t);
	}
	



	
	
	
	
}
