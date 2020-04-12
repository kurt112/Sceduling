package com.school.scheduling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.scheduling.entity.Subject;


public interface Subject_Repository extends JpaRepository<Subject, Integer> {
	public List<Subject> findAll();
}
