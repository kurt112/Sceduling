package com.school.scheduling.validations.Teacher.CheckUsername;

import com.school.scheduling.entity.Teacher;
import com.school.scheduling.entity.Users;
import com.school.scheduling.service.Services;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Username implements ConstraintValidator <CheckUsername, Users> {

    private Services<Teacher> teacherServices;

    @Autowired
    public Username(Services<Teacher> teacherServices) {
        this.teacherServices = teacherServices;
    }

    public Username() {
    }

    @Override
    public void initialize(CheckUsername constraintAnnotation) {

    }

    @Override
    public boolean isValid(Users value, ConstraintValidatorContext context) {
        System.out.println("did i called");
//        for(Teacher teahcer: teacherServices.findAll()){
//            System.out.println(teahcer);
//            if(teahcer.getUsers().getUsername().equals(value)){
//                return false;
//            }
//        }
        return false;
    }

    }


