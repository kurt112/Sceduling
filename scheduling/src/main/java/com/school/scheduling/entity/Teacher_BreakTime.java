package com.school.scheduling.entity;
import javax.persistence.*;

/*
 * This code is created By Kurt Lupin C. Orioque
 * You can Contact me
 * Email: kurtorioque112@gmail.com
 * Contact: 09276913995
 * February , 13 2020
 * 12:38 AM
 */

@Table
@Entity(name = "teacher_breaktime")
public class Teacher_BreakTime {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "start_time")
        private String StartTime;

        @Column(name = "time_end")
        private String EndTime;

        @ManyToOne(cascade = {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST,
                CascadeType.REFRESH
        })
        @JoinColumn(name = "teacher_id")
        private Teacher teacher;

        public Teacher_BreakTime() {
        }

        public Teacher_BreakTime(String startTime, String endTime) {
            StartTime = startTime;
            EndTime = endTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(String startTime) {
            StartTime = startTime;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String endTime) {
            EndTime = endTime;
        }

        public Teacher getTeacher() {
            return teacher;
        }

        public void setTeacher(Teacher teacher) {
            this.teacher = teacher;
        }

        @Override
        public String toString() {
            return "Breaktime_teacher{" +
                    "id=" + id +
                    ", StartTime='" + StartTime + '\'' +
                    ", EndTime='" + EndTime + '\'' +
                    ", teacher=" + teacher +
                    '}';
        }
    }
