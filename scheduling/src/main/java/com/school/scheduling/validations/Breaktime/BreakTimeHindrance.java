package com.school.scheduling.validations.Breaktime;

import com.school.scheduling.entity.BreakTime;
import com.school.scheduling.service.Services;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BreakTimeHindrance implements ConstraintValidator<Check_BreakTime, BreakTime> {
    private Services<BreakTime> breakTimeServices;
    @Autowired
    public BreakTimeHindrance(Services<BreakTime> breakTimeServices) {
        this.breakTimeServices = breakTimeServices;
    }

    @Override
    public void initialize(Check_BreakTime constraintAnnotation) {

    }

    @Override
    public boolean isValid(BreakTime value, ConstraintValidatorContext context){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");

        Calendar new_start_time = Calendar.getInstance();
        Calendar new_end_time = Calendar.getInstance();

        Calendar old_start_time = Calendar.getInstance();
        Calendar old_end_time = Calendar.getInstance();

        if(value.getStart_time().equals(value.getEnd_time())){
            Message(" (Can't have a same time) ",context);
            return false;
        }

        try {
            new_start_time.setTime(dateFormat.parse(value.getStart_time()));
            new_end_time.setTime(dateFormat.parse(value.getEnd_time()));

            if(new_start_time.getTime().after(new_end_time.getTime())){
                Message(" (End time must be higher) " , context);
                return false;
            }



        } catch (ParseException e) {
            e.printStackTrace();
        }

        return true;
    }

    public void Message(String message, ConstraintValidatorContext context){
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }
}
