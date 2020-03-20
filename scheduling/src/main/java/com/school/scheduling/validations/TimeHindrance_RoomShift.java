package com.school.scheduling.validations;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import com.school.scheduling.entity.Room;
import com.school.scheduling.entity.Room_Shift;
import com.school.scheduling.service.Services;

public class TimeHindrance_RoomShift implements ConstraintValidator<CheckTime_RoomShift, Room_Shift> {

	private String message;

	public TimeHindrance_RoomShift() {

	}

	@Override
	public void initialize(CheckTime_RoomShift time) {
		message = time.message();
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
			new_start_time.setTime(dateFormat.parse(value.getStartTime()));
			new_end_time.setTime(dateFormat.parse(value.getEndTime()));

			if (new_start_time.getTime().after(new_end_time.getTime())) {

				message = "Time Should should not exceed to end time" + new_end_time.getTime();
				context.disableDefaultConstraintViolation();

				// build new violation message and add it
				context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
				return false;
			} else {
				try {
					if (value.getRoom().getRoom_shiftList().size() != 0) {
						boolean between = true;

						for (Room_Shift roomshift : value.getRoom().getRoom_shiftList()) {

							old_start_time.setTime(dateFormat.parse(roomshift.getStartTime()));
							old_end_time.setTime(dateFormat.parse(roomshift.getEndTime()));

							if(roomshift.getId() == value.getId()) {
								
							}else {
								if (new_start_time.getTime().after(old_start_time.getTime()) &&
										new_start_time.getTime().before(old_end_time.getTime() )) {
										
										message = "Time Should start or higher than "
												+ dateFormat.format(old_end_time.getTime());
										context.disableDefaultConstraintViolation();

										context.buildConstraintViolationWithTemplate(message).addConstraintViolation();

										between = false;
										System.out.println("Something in the middle");
										break;
									}
							}
						} // a for loop
						System.out.println("The Break " + between);
						return between;

					} // end in size 0
				} catch (NullPointerException e) {

				}
			} // end else


			return true;
		} catch (ParseException e1) {
			message = "Invalid Time Format"
					+ dateFormat.format(old_end_time.getTime());
			context.disableDefaultConstraintViolation();

			context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
		}
		return false;
		// th:if="${#fields.hasErrors('${subject.*}')}" th:errors="${subject.*}"

	}

}
