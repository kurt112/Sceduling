package com.school.scheduling.serviceimplementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.scheduling.entity.BreakTime;
import com.school.scheduling.repository.BreakTime_Repository;
import com.school.scheduling.service.Services;

@Transactional
@Service
public class BreakTimeService_Impl implements Services<BreakTime> {

	private BreakTime_Repository repository;

	@Autowired
	public BreakTimeService_Impl(BreakTime_Repository repository) {

		this.repository = repository;
	}

	@Override
	public List<BreakTime> findAll() {
		return repository.findAll();
	}

	@Override
	public BreakTime findbyId(int theId) {
		Optional<BreakTime> result = repository.findById(theId);

		return result.isPresent() ? result.get() : null;
	}

	@Override
	public void save(BreakTime t) {
		repository.save(t);

	}

	@Override
	public void deleteById(int theId) {
		repository.deleteById(theId);
	}

	@Override
	public void delete(BreakTime t) {
		repository.delete(t);

	}

}
