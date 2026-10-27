package com.handson.backend.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.util.Date;


public class GradeIn {

    @NotEmpty
    @Length(max = 60)
    private String courseName;

    @Min(10)
    @Max(100)
    private Integer courseScore;

    public StudentGrade toGrade(Student student) {
        return StudentGrade.builder().createdAt(new Date()).student(student).courseName(courseName).courseScore(courseScore).build();
    }

    public void updateStudentGrade(StudentGrade studentGrade) {
        studentGrade.setCourseName(courseName);
        studentGrade.setCourseScore(courseScore);
    }

    public String getCourseName() {
        return courseName;
    }

    public Integer getCourseScore() {
        return courseScore;
    }
}
