package com.school.scheduling.SchedulingAlgorithm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import com.school.scheduling.entity.Room_Shift;
import com.school.scheduling.entity.Room_ShiftSchedule;
import com.school.scheduling.entity.StrandAndCourse;
import com.school.scheduling.entity.Subject;
import com.school.scheduling.service.Services;

public class GenerateRoomShift_Schedule {
	
	private List<StrandAndCourse> strands;
	private List<Room_Shift> room_shift; 
	private Services<Room_Shift> shift_service; 
	private Services<Room_ShiftSchedule> schedule_service;

	
	
	
	public GenerateRoomShift_Schedule(List<StrandAndCourse> strands, List<Room_Shift> room_shift,
			Services<Room_Shift> shift_service, Services<Room_ShiftSchedule> schedule_service) {
		this.strands = strands;
		this.room_shift = room_shift;
		this.shift_service = shift_service;
		this.schedule_service = schedule_service;
	}


	
	
	public void schedule() {
		room_shift.forEach(e ->{
			e.setInitial_time(e.getStartTime());
			shift_service.save(e);
		});
		Collections.shuffle(strands);
		Collections.shuffle(room_shift);
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");

		Calendar shift_startTime = Calendar.getInstance();
		Calendar shift_endTime = Calendar.getInstance();
		
		// iterating all the shift in the room
		for(Room_Shift shift: room_shift) {
			System.out.println("The room " + shift.getRoom().getRoomName() + " The Shift -> " + shift.getShiftName());
			String day = "MWF";
			try {
				shift_startTime.setTime(dateFormat.parse(shift.getInitial_time()));
				shift_endTime.setTime(dateFormat.parse(shift.getEndTime()));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			StrandAndCourse strand_new = null;
			// iterating all the strand in the school	
			for(StrandAndCourse strand: strands) {
			
				strand_new = strand;
				// getting the same strand in the room
				if(shift.getStrandAndCourse() == strand) {
					System.out.println("The Strand -> " + strand.getStrandName() );
					
					// iterating all the subjects
					for(Subject sbj: strand.getSubjectList()) {
						
						if(!sbj.getSubjectName().contains("Physical Education and Health")) {
							System.out.println(" The subject -> " + shift.getStrandAndCourse().getStrandName()+ " -> " + sbj.getSubjectName() + " the time -> " + dateFormat.format(shift_startTime.getTime()));
							try {
								boolean exist =false;
								shift_startTime.add(Calendar.HOUR, sbj.getHourCost());
								shift_startTime.add(Calendar.MINUTE, sbj.getMinuteCost());
								
								// checking if the room schedule has a already subject in that schedule
								for(Room_ShiftSchedule schedule: shift.getRoom_ShiftSchedules()) {
									if(schedule.getSubject() == sbj) exist =true;
								}
								
								if(exist == false) {
									if(shift_startTime.getTime().equals(shift_endTime.getTime())) {
									} 
									
									if((shift_startTime.getTime().before(shift_endTime.getTime())) 
											|| 
											shift_startTime.getTime().equals(shift_endTime.getTime())) {
										
										
										schedule_service.save(new Room_ShiftSchedule(shift, sbj, 
												shift.getInitial_time() , dateFormat.format(shift_startTime.getTime()), day));
										
								
										shift.setInitial_time(dateFormat.format(shift_startTime.getTime()));
										
									}else {
										day = "TTH";
										shift.setInitial_time(shift.getStartTime());
										
										shift_startTime.setTime(dateFormat.parse(shift.getInitial_time()));
										
										shift_startTime.add(Calendar.HOUR, sbj.getHourCost());
										shift_startTime.add(Calendar.MINUTE, sbj.getMinuteCost());
										
										
										schedule_service.save(new Room_ShiftSchedule(shift, sbj, 
												shift.getInitial_time() , dateFormat.format(shift_startTime.getTime()), day));
										
										shift.setInitial_time(dateFormat.format(shift_startTime.getTime()));
									
									}	
									
								}
								
								
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}else {
							schedule_service.save(new Room_ShiftSchedule(shift, sbj, 
									"0:00", "0:00", day));
						}
					}
					
					System.out.println("-------------------------------------------------------------------------------");
					
					break;
				}
				
			}
			
			Subject temp_subject = strand_new.getSubjectList().get(0);

			strands.remove(strand_new);
			
			strand_new.getSubjectList().remove(temp_subject);
			strand_new.getSubjectList().add(temp_subject);
			
			strands.add(strand_new);
			
		}
	}
	

}
