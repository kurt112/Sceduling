package com.school.scheduling.SchedulingAlgorithm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.school.scheduling.entity.Room_ShiftSchedule;
import com.school.scheduling.entity.Teacher_Lecture;
import com.school.scheduling.service.Services;

public class ScheduleAlgho {

	public static void CreateSchedule(List<Teacher_Lecture> lecture_day, List<Room_ShiftSchedule> schedule_day,  Services<Teacher_Lecture> lectureServices) {
		 
			DateFormat dateFormat = new SimpleDateFormat("HH:mm");

			Calendar schedule_start = Calendar.getInstance();
			Calendar schedule_end = Calendar.getInstance();

			Calendar lecture_start = Calendar.getInstance();
			Calendar lecture_end = Calendar.getInstance();
		 
		 for (Room_ShiftSchedule schedule : schedule_day) {

				try {

					schedule_start.setTime(dateFormat.parse(schedule.getStart_time()));
					schedule_end.setTime(dateFormat.parse(schedule.getEnd_time()));

					for (Teacher_Lecture lecture_tth : lecture_day) {

						// checking if the teacher has a available subject
						if (lecture_tth.getTeacher().getSubjectList().contains(schedule.getSubject())) {
							if(lecture_tth.getTeacher().getSubject_load() < 11) {

//								System.out.println("The teacher -> " + lecture_tth.getTeacher().getFirstName() + " , "
//										+ lecture_tth.getTeacher().getTeacher_schedule().size());
								boolean intercept = false;
								// checking if the teacher has a schedule
								if (lecture_tth.getTeacher().getTeacher_schedule().size() != 0) {
									
								
									// looping all of the schedule
									for(Room_ShiftSchedule teacher: lecture_tth.getTeacher().getTeacher_schedule()) {
//										System.out.println(teacher.getTeacher().getFirstName());
										lecture_start.setTime(dateFormat.parse(teacher.getStart_time()));
										lecture_end.setTime(dateFormat.parse(teacher.getEnd_time()));
									
										// if the new schedule is in the middle of the lectures	
										if (schedule_start.getTime().after(lecture_start.getTime())
												&& schedule_end.getTime().before(lecture_end.getTime())) {
											System.out.println("im called in break 1");
											intercept = true;
											break;
											// if the schedule is exact with the lecture time
										} else if (schedule_start.getTime().equals(lecture_start.getTime())
												&& schedule_end.getTime().equals(lecture_end.getTime())) {
//											System.out.println("im called in break 2");
											intercept = true;
											break;
											// this else if, if the schedule start time is before the lecture start time but the 
											// schedule end time is after the lecture end time means it has a intercept
										} else if (schedule_start.getTime().before(lecture_start.getTime())
												&& schedule_end.getTime().after(lecture_end.getTime())) {
											System.out.println("im called in break 3");				
											intercept = true;
											break;
											// if the schedule start is equal to the lecture start but the  
											// end of the schedule is after or before the lecture end meaning 
											// it has a Interception;
											
										} else if (schedule_start.getTime().equals(lecture_start.getTime())
												&& (schedule_end.getTime().before(lecture_end.getTime())
														|| (schedule_end.getTime().after(lecture_end.getTime()))))

										{
											intercept = true;
											System.out.println("im called in break 4");
											
											break;
										}
							
									}
									
									if(intercept == false) {
										lecture_tth.getTeacher().add_Schedule(schedule);
										lectureServices.save(lecture_tth);
										lecture_tth.getTeacher().setSubject_load(lecture_tth.getTeacher().getSubject_load()+1);
										break;
									}
					
								} else if(lecture_tth.getTeacher().getTeacher_schedule() == null ||lecture_tth.getTeacher().getTeacher_schedule().size() == 0) {
									lecture_tth.getTeacher().add_Schedule(schedule);
									lectureServices.save(lecture_tth);
									lecture_tth.getTeacher().setSubject_load(lecture_tth.getTeacher().getSubject_load()+1);
									
									break;
								}
		
							}
						}
					}
				} catch (ParseException ignored) {

				}
			}
	}
}
