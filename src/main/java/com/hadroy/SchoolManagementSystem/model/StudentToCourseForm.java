package com.hadroy.SchoolManagementSystem.model;

public class StudentToCourseForm {

    private String studentName;
    private String courseTitle;

    public StudentToCourseForm() {
    }

    public StudentToCourseForm(String studentName, String courseTitle) {
        this.studentName = studentName;
        this.courseTitle = courseTitle;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
}
