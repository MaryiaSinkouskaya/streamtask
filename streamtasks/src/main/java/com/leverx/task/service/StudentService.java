package com.leverx.task.service;

import com.leverx.task.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> createStudents();

    double getAverageRate(List<Student> students, String subject);
    void showSubjectStatistics(List<Student> students);
    String getNameWithRatingMark(Student student, String subject);


    }
