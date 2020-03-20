package com.school.scheduling.EntityCombine;

import com.school.scheduling.entity.BreakTime;

public class RoomBreak {
	private int id;
	private String roomName;
	private String shiftName;
	private BreakTime breaktime;
	
	
	
	public RoomBreak(int id, String roomName, String shiftName, BreakTime breaktime) {
		this.id = id;
		this.roomName = roomName;
		this.shiftName = shiftName;
		this.breaktime = breaktime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getShiftName() {
		return shiftName;
	}
	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}
	public BreakTime getBreaktime() {
		return breaktime;
	}
	public void setBreaktime(BreakTime breaktime) {
		this.breaktime = breaktime;
	}
	
	
	
}
