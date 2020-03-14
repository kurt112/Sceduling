package com.school.scheduling.serviceimplementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.school.scheduling.entity.Room_Shift_BreakTime;
import com.school.scheduling.repository.RoomShiftBreakTime_Repository;
import com.school.scheduling.service.Services;

@Service
@Transactional
public class RoomShiftBreakTimeService_Impl implements Services<Room_Shift_BreakTime> {
	
	private RoomShiftBreakTime_Repository repo;

	public RoomShiftBreakTimeService_Impl(RoomShiftBreakTime_Repository repo) {
		this.repo = repo;
	}

	@Override
	public List<Room_Shift_BreakTime> findAll() {
	
		return repo.findAll();
	}

	@Override
	public Room_Shift_BreakTime findbyId(int theId) {
		Optional<Room_Shift_BreakTime> result = repo.findById(theId);
		
		return result.isPresent()? result.get(): null;
	}

	@Override
	public void save(Room_Shift_BreakTime t) {
		repo.save(t);
	}

	@Override
	public void deleteById(int theId) {
		repo.findById(theId);
	}
	
	
	
	
	
	
	
}
