package com.school.scheduling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.scheduling.entity.Room_ShiftSchedule;

public interface RoomShiftSchedule_Repository extends JpaRepository<Room_ShiftSchedule, Integer> {

}
