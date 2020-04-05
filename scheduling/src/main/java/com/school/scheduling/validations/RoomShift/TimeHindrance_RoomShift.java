package com.school.scheduling.validations.RoomShift;

import com.school.scheduling.entity.Room_Shift;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeHindrance_RoomShift implements ConstraintValidator<CheckTime_RoomShift, Room_Shift> {

	public TimeHindrance_RoomShift() {

	}

	@Override
	public void initialize(CheckTime_RoomShift time) {

	}

	@Override
	public boolean isValid(Room_Shift value, ConstraintValidatorContext context) {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");

		Calendar new_start_time = Calendar.getInstance();
		Calendar new_end_time = Calendar.getInstance();

		Calendar old_start_time = Calendar.getInstance();
		Calendar old_end_time = Calendar.getInstance();

		try {
			if (value.getStartTime() == null || value.getEndTime() == null) {
				return false;
			}

			if (value.getStartTime().equals(value.getEndTime())) {

				Message("Can't sched the same time", context);
				return false;
			}

			new_start_time.setTime(dateFormat.parse(value.getStartTime()));
			new_end_time.setTime(dateFormat.parse(value.getEndTime()));

			if (new_start_time.getTime().after(new_end_time.getTime())) {
				Message("Time Should should not exceed to " + dateFormat.format(new_end_time.getTime()), context);
				return false;
			} else {
				try {
					if (value.getRoom().getRoom_shiftList().size() != 0) {
						for (Room_Shift roomshift : value.getRoom().getRoom_shiftList()) {

							old_start_time.setTime(dateFormat.parse(roomshift.getStartTime()));
							old_end_time.setTime(dateFormat.parse(roomshift.getEndTime()));
							if (roomshift.getId() != value.getId()) {
								// if the time is in the middle
								if (new_start_time.getTime().after(old_start_time.getTime())
										&& new_start_time.getTime().before(old_end_time.getTime())) {
									Message("Time Should start or higher than "
											+ dateFormat.format(old_end_time.getTime()), context);
										return false;
									// this else if the time is uqual to old and new time
								} else if (new_start_time.getTime().equals(old_start_time.getTime())
										&& new_end_time.getTime().equals(old_end_time.getTime())) {
									Message("Occupied Time", context);
									return false;
									// this else if, if the new start time is before the old start time but the 
									// end time is after the old start time means it has a intercept
								} else if (new_start_time.getTime().before(old_start_time.getTime())
										&& new_end_time.getTime().after(old_start_time.getTime())) {

									Message("Time Start suggestion " + dateFormat.format(old_end_time.getTime()),context);
									return false;
									// if the schedule start is equal to the lecture start but the  
									// end of the schedule is after or before the lecture end meaning 
									// it has a Interception;
								} else if (new_start_time.getTime().equals(old_start_time.getTime())
										&& (new_end_time.getTime().before(old_end_time.getTime())
												|| (new_end_time.getTime().after(old_end_time.getTime()))))

								{
									Message("Time Start suggestion " + dateFormat.format(old_end_time.getTime()), context);
									return false;
								}

							}
						} // a for loop
						return true;

					} // end in size 0
				} catch (NullPointerException ignored) {

				}
			} // end else

			return true;
		} catch (ParseException e1) {
			Message("Invalid Time Format" + dateFormat.format(old_end_time.getTime()), context);
		}
		return false;
		// th:if="${#fields.hasErrors('${subject.*}')}" th:errors="${subject.*}"

	}

	public void Message(String message, ConstraintValidatorContext context){
		context.disableDefaultConstraintViolation();

		context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
	}

}
