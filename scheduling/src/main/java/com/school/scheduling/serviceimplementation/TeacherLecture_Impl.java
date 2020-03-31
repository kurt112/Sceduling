package com.school.scheduling.serviceimplementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.scheduling.entity.Teacher_Lecture;
import com.school.scheduling.repository.TeacherLecture_Repository;
import com.school.scheduling.service.Services;

@Transactional
@Service
public class TeacherLecture_Impl implements Services<Teacher_Lecture>{
	
	private TeacherLecture_Repository repo;

	@Autowired
	public TeacherLecture_Impl(TeacherLecture_Repository repo) {
		this.repo = repo;
	}

	@Override
	public List<Teacher_Lecture> findAll() {
		return repo.findAll();
	}

	@Override
	public Teacher_Lecture findbyId(int theId) {
		Optional<Teacher_Lecture> lecture = repo.findById(theId);
		return lecture.isPresent()? lecture.get(): null;
	}

	@Override
	public void save(Teacher_Lecture t) {
		repo.save(t);
	}

	@Override
	public void deleteById(int theId) {
		repo.deleteById(theId);
	}

	@Override
	public void delete(Teacher_Lecture t) {
		repo.delete(t);
	}
	
	
	
	

}
