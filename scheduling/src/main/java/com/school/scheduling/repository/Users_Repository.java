package com.school.scheduling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.school.scheduling.entity.Users;

public interface Users_Repository extends JpaRepository<Users, String> {
	
	public List<Users> findAll();
}
