package com.leverx.task.service.Impl;

import com.leverx.task.entity.Student;
import com.leverx.task.service.StudentService;

import static java.util.Arrays.asList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    public List<Student> createStudents() {
        Student st1 = new Student("Mary")
                .rate("Math", 5)
                .rate("History", 3)
                .rate("English", 4)
                .rate("Physics", 4);

        Student st2 = new Student("Anna")
                .rate("Math", 4)
                .rate("History", 5)
                .rate("English", 5)
                .rate("Physics", 5)
                .rate("Literature", 5);

        Student st3 = new Student("Polina")
                .rate("Math", 5)
                .rate("History", 3)
                .rate("English", 3);

        return asList(st1, st2, st3);
    }

    public double getAverageRate(List<Student> students, String subject) {
        return students.stream()
                .filter(student -> student.getRating().containsKey(subject))
                .mapToInt(student -> student.getRating().get(subject))
                .average()
                .orElse(0);
    }

    public String getNameWithRatingMark(Student student, String subject) {
        return student.getName() + ": " + student.getRating().get(subject);
    }

    public void showSubjectStatistics(List<Student> students) {
        Set<String> subjects = new HashSet<>();
        students.forEach(student -> subjects.addAll(student.getRating().keySet()));

        subjects.forEach(subject -> {
            String subjectsStatistics = students.stream()
                    .filter(student -> student.getRating().containsKey(subject))
                    .map(student -> getNameWithRatingMark(student, subject))
                    .collect(Collectors.joining(", ", "(", ")"));
            System.out.println(subject + ": " + subjectsStatistics);
        });
    }
}
