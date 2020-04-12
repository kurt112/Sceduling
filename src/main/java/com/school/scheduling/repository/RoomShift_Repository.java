package com.school.scheduling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.scheduling.entity.Room_Shift;

public interface RoomShift_Repository extends JpaRepository<Room_Shift, Integer> {

	
	public List<Room_Shift> findAll();
	
	
	
	

}
