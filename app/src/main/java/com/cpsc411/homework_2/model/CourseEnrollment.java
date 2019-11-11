package com.cpsc411.homework_2.model;

public class CourseEnrollment {
    protected String mCourseID;
    protected String mGrade;

    //Constructor
    public CourseEnrollment(String courseID, String grade) {
        mCourseID = courseID;
        mGrade = grade;
    }

    public String getCourseID() {
        return mCourseID;
    }

    public void setCourseID(String courseID) {
        mCourseID = courseID;
    }

    public String getGrade() {
        return mGrade;
    }

    public void setGrade(String grade) {
        mGrade = grade;
    }
}
