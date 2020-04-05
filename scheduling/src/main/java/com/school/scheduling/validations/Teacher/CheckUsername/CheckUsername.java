package com.school.scheduling.validations.Teacher.CheckUsername;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = Username.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckUsername {
    public String message() default " (This username is already taken)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
