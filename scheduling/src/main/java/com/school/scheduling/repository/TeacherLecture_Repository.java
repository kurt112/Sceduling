package com.school.scheduling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.scheduling.entity.Teacher_Lecture;

public interface TeacherLecture_Repository  extends JpaRepository<Teacher_Lecture, Integer> {

}
