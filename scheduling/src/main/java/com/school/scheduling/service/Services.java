package com.school.scheduling.service;

import java.util.List;

public interface Services<T> {
	
	public List<T> findAll();
	
	public T findbyId(int theId);
	
	public void save(T t);
	
	public void deleteById(int theId);

	public void delete(T t);
	
}
