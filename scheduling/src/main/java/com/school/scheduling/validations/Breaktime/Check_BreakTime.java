package com.school.scheduling.validations.Breaktime;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = BreakTimeHindrance.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Check_BreakTime {

    public String message()  default " (BreakTime Currently Exist) ";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default {};


}
