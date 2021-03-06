package com.school.scheduling.serviceimplementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.scheduling.entity.Room_Shift;
import com.school.scheduling.repository.RoomShift_Repository;
import com.school.scheduling.service.Services;

@Service
@Transactional
public class RoomShiftService_Impl implements Services<Room_Shift>{
	
	private RoomShift_Repository repo;
	

	@Autowired
	public RoomShiftService_Impl(RoomShift_Repository repo) {
		this.repo = repo;
	}

	@Override
	public List<Room_Shift> findAll() {
		return repo.findAll();
	}

	@Override
	public Room_Shift findbyId(int theId) {
		Optional<Room_Shift> result = repo.findById(theId);

		System.out.println("Finding by Id");
		return result.isPresent()? result.get(): null;
	}

	@Override
	public void save(Room_Shift t) {
		repo.save(t);
	}


	@Override
	public void deleteById( int theId) {
		repo.deleteById(theId);
		
	}

	@Override
	public void delete(Room_Shift t) {
			repo.delete(t);
		
		
	}
	


	
	
}
