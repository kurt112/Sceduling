package com.school.scheduling.SchedulingAlgorithm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import com.school.scheduling.entity.BreakTime;
import com.school.scheduling.entity.Room_ShiftSchedule;
import com.school.scheduling.entity.Teacher_Lecture;
import com.school.scheduling.service.Services;

public class GenerateTeacher_Schedule {

	private List<Teacher_Lecture> lecture_day;
	private List<Room_ShiftSchedule> schedule_day;
	private Services<Teacher_Lecture> lectureServices;

	DateFormat dateFormat = new SimpleDateFormat("HH:mm");

	Calendar schedule_start = Calendar.getInstance();
	Calendar schedule_end = Calendar.getInstance();

	Calendar lecture_start = Calendar.getInstance();
	Calendar lecture_end = Calendar.getInstance();

	public GenerateTeacher_Schedule(List<Teacher_Lecture> lecture_day, List<Room_ShiftSchedule> schedule_day,
			Services<Teacher_Lecture> lectureServices) {
		this.lecture_day = lecture_day;
		this.schedule_day = schedule_day;
		this.lectureServices = lectureServices;
	}

	public void Schedule() {
		Collections.sort(schedule_day);
		Collections.sort(lecture_day);

		for (Room_ShiftSchedule schedule : schedule_day) {

			try {
				schedule_start.setTime(dateFormat.parse(schedule.getStart_time()));
				schedule_end.setTime(dateFormat.parse(schedule.getEnd_time()));
				for (Teacher_Lecture lecture_day : lecture_day) {

					// checking if the teacher has a available subject
					if (lecture_day.getTeacher().getSubjectList().contains(schedule.getSubject())) {
						if (lecture_day.getTeacher().getSubject_load() < 11) {
//							System.out.println("The teacher -> " + lecture_tth.getTeacher().getFirstName() + " , "
//									+ lecture_tth.getTeacher().getTeacher_schedule().size());
							// checking if the teacher has a schedule
							if (lecture_day.getTeacher().getTeacher_schedule().size() != 0) {

								if(lecture_day.getBreaktime_teacherList().size() !=0) {
									if(TeacherBreaktime(lecture_day) == false) {
										Save(lecture_day,schedule);
										break;
									}
								}else {
									if (TeacherTime(lecture_day) == false) {
										Save(lecture_day,schedule);
										break;
									}

								}
							} else if (lecture_day.getTeacher().getTeacher_schedule() == null
									|| lecture_day.getTeacher().getTeacher_schedule().size() == 0) {
								Save(lecture_day,schedule);
								break;
							}
						}

					}
				}
			} catch (ParseException ignored) {

			}
		}
	}

	private boolean TeacherBreaktime(Teacher_Lecture lecture_teacher) throws ParseException {
		
		System.out.println("I have BreakTime");
		
		Calendar breaktime_start = Calendar.getInstance();
		Calendar breaktime_end = Calendar.getInstance();

		for (BreakTime breaktime : lecture_teacher.getBreaktime_teacherList()) {
			
			breaktime_start.setTime(dateFormat.parse(breaktime.getStart_time()));
			breaktime_end.setTime(dateFormat.parse(breaktime.getEnd_time()));
			
			for(Room_ShiftSchedule teacher: lecture_teacher.getTeacher().getTeacher_schedule()) {

				
				lecture_start.setTime(dateFormat.parse(teacher.getStart_time()));
				lecture_end.setTime(dateFormat.parse(teacher.getEnd_time()));
				
				// if the new schedule is in the middle of the lectures
				if (breaktime_start.getTime().after(lecture_start.getTime())
						&& breaktime_end.getTime().before(lecture_end.getTime())) {
					System.out.println("im called in break 1");
					return true;
					// if the schedule is exact with the lecture time
				} else if (breaktime_start.getTime().equals(lecture_start.getTime())
						&& breaktime_end.getTime().equals(lecture_end.getTime())) {
//								System.out.println("im called in break 2");
					return true;
					// this else if, if the schedule start time is before the lecture start time but
					// the
					// schedule end time is after the lecture end time means it has a intercept
				} else if (breaktime_start.getTime().before(lecture_start.getTime())
						&& breaktime_end.getTime().after(lecture_end.getTime())) {
					System.out.println("im called in break 3");
					return true;
					// if the schedule start is equal to the lecture start but the
					// end of the schedule is after or before the lecture end meaning
					// it has a Interception;

				} else if (breaktime_start.getTime().equals(lecture_start.getTime())
						&& (breaktime_end.getTime().before(lecture_end.getTime())
								|| (breaktime_end.getTime().after(lecture_end.getTime()))))

				{
					return true;
				}
			}
		}
		
		
		return	TeacherTime(lecture_teacher);

	}

	private boolean TeacherTime(Teacher_Lecture lecture_teacher) throws ParseException {

		// looping all of the schedule
		for (Room_ShiftSchedule teacher : lecture_teacher.getTeacher().getTeacher_schedule()) {
//			System.out.println(teacher.getTeacher().getFirstName());
			lecture_start.setTime(dateFormat.parse(teacher.getStart_time()));
			lecture_end.setTime(dateFormat.parse(teacher.getEnd_time()));
			// if the new schedule is in the middle of the lectures
			if (schedule_start.getTime().after(lecture_start.getTime())
					&& schedule_end.getTime().before(lecture_end.getTime())) {
				System.out.println("im called in break 1");
				return true;
				// if the schedule is exact with the lecture time
			} else if (schedule_start.getTime().equals(lecture_start.getTime())
					&& schedule_end.getTime().equals(lecture_end.getTime())) {
				System.out.println("im called in break 2");
				return true;
				// this else if, if the schedule start time is before the lecture start time but
				// the
				// schedule end time is after the lecture end time means it has a intercept
			} else if (schedule_start.getTime().before(lecture_start.getTime())
					&& schedule_end.getTime().after(lecture_end.getTime())) {
				System.out.println("im called in break 3");
				return true;
				// if the schedule start is equal to the lecture start but the
				// end of the schedule is after or before the lecture end meaning
				// it has a Interception;

			} else if (schedule_start.getTime().equals(lecture_start.getTime())
					&& (schedule_end.getTime().before(lecture_end.getTime())
							|| (schedule_end.getTime().after(lecture_end.getTime()))))

			{
				
				System.out.println("im called in break 4");
				return true;
			}

		}
		return false;
	}
	
	
	// When saving the schedule
	private void Save(Teacher_Lecture lecture_day, Room_ShiftSchedule schedule) {
		lecture_day.getTeacher().add_Schedule(schedule);
		lectureServices.save(lecture_day);
		lecture_day.getTeacher().setSubject_load(lecture_day.getTeacher().getSubject_load() + 1);
	}

}
