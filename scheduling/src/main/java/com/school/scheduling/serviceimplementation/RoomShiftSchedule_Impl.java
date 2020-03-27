package com.school.scheduling.serviceimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.school.scheduling.entity.Room_ShiftSchedule;
import com.school.scheduling.repository.RoomShiftSchedule_Repository;
import com.school.scheduling.service.Services;

public class RoomShiftSchedule_Impl implements Services<Room_ShiftSchedule> {
	
	private RoomShiftSchedule_Repository repo;
	
	@Autowired
	public RoomShiftSchedule_Impl(RoomShiftSchedule_Repository repo) {
		this.repo = repo;
	}

	@Override
	public List<Room_ShiftSchedule> findAll() {
		return repo.findAll();
	}

	@Override
	public Room_ShiftSchedule findbyId(int theId) {
		Optional<Room_ShiftSchedule> room = repo.findById(theId);
		
		return room.isPresent() ? room.get(): null;
	}

	@Override
	public void save(Room_ShiftSchedule t) {
		repo.save(t);
		
	}

	@Override
	public void deleteById(int theId) {
		repo.deleteById(theId);
		
	}

	@Override
	public void delete(Room_ShiftSchedule t) {
		repo.save(t);
		
	}
	
	
	
	
	
}
