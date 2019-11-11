package com.cpsc411.homework_2.model;

import java.util.ArrayList;

public class StudentDB { //This is a singleton
    private static final StudentDB ourInstance = new StudentDB();
    public static StudentDB getInstance() {
        return ourInstance;
    }


    private ArrayList<Student> mStudentList; //this holds the list of students in our DB
    private ArrayList<CourseEnrollment> mCourses;
    private int mAmountOfCourses;

    private Student tempStudent;

    private StudentDB() {
        createStudentObjects();
    }

    public ArrayList<Student> getStudentList() {return mStudentList; }

    public int getAmountOfCourses() { return mAmountOfCourses;}

    public void setCourses(ArrayList<CourseEnrollment> c) { mCourses = c; }


    protected void createStudentObjects() {
        Student student = new Student("Ian", "Alvarez", "123456");
        mCourses = new ArrayList<CourseEnrollment>();
        mCourses.add(new CourseEnrollment("CPSC 411","A+"));
        mCourses.add(new CourseEnrollment("CPSC 349", "A"));
        mAmountOfCourses = mCourses.size();
        student.setCourses(mCourses);
        mStudentList = new ArrayList<Student>();
        mStudentList.add(student);

        student = new Student("Joesh", "Bautista","654321");
        mCourses = new ArrayList<CourseEnrollment>();
        mCourses.add(new CourseEnrollment("CPSC 349", "A"));
        mCourses.add(new CourseEnrollment("CPSC 454", "C+"));
        mCourses.add(new CourseEnrollment("CPSC 411", "A"));
        mStudentList.add(student);

    }

    public void addStudentObject(Student student) { //setter
        tempStudent = student;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        mStudentList = studentList;
    }
}
