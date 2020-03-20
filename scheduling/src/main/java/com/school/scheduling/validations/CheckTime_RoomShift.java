package com.school.scheduling.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = TimeHindrance_RoomShift.class)
//ElementType.METHOD, ElementType.FIELD 
@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckTime_RoomShift{
	
	public String message() default "(Provide time)";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	
}
