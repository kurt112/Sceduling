package com.school.scheduling.serviceimplementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.school.scheduling.entity.Student;
import com.school.scheduling.repository.Student_Repository;
import com.school.scheduling.service.Services;

@Transactional
@Service
public class StudentService_Impl implements Services<Student> {
	private Student_Repository repo;

	
	
	public StudentService_Impl(Student_Repository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Student> findAll() {
		return repo.findAll();
	}

	@Override
	public Student findbyId(int theId) {
		Optional<Student> result = repo.findById(theId);
		
		return result.isPresent()? result.get(): null;
	}

	@Override
	public void save(Student t) {
		repo.save(t);
		
	}

	@Override
	public void deleteById(int theId) {
		repo.deleteById(theId);
	}
	
	
	
}
