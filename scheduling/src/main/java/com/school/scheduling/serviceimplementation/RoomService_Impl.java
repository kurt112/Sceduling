package com.school.scheduling.serviceimplementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.scheduling.entity.Room;
import com.school.scheduling.repository.Room_Repository;
import com.school.scheduling.service.Services;

@Transactional
@Service
public class RoomService_Impl implements Services<Room> {
	
	private Room_Repository repo;

	@Autowired
	public RoomService_Impl(Room_Repository repo) {
		this.repo = repo;
	}

	@Override
	public List<Room> findAll() {
		return repo.findAll();
	}

	@Override
	public Room findbyId(int theId) {
		Optional<Room> result = repo.findById(theId);
		
		return result.orElse(null);
	}
	
	
	
	@Override
	public void delete(Room t) {
		repo.delete(t);
		
	}

	@Override
	public void save(Room t) {
		repo.save(t);
	}

	@Override
	public void deleteById(int theId) {
		repo.deleteById(theId);
		
	}
	
	
	
	
	
	
}
