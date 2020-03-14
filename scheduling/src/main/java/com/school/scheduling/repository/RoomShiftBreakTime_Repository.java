package com.school.scheduling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.school.scheduling.entity.Room_Shift_BreakTime;

public interface RoomShiftBreakTime_Repository extends JpaRepository<Room_Shift_BreakTime, Integer> {
	
	public List<Room_Shift_BreakTime> findAll();
}
