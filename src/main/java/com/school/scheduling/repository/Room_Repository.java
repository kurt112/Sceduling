package com.school.scheduling.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.scheduling.entity.Room;
public interface Room_Repository extends JpaRepository<Room, Integer> {
	
	
	public List<Room> findAll();
	
	
}
