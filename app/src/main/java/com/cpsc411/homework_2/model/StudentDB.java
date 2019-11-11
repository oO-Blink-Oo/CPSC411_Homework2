package com.cpsc411.homework_2.model;

import java.util.ArrayList;

public class StudentDB { //This is a singleton
    private static final StudentDB ourInstance = new StudentDB();
    public static StudentDB getInstance() {
        return ourInstance;
    }


    private ArrayList<Student> mStudentList; //this holds the list of students in our DB
    private int mAmountOfCourses;

    private Student tempStudent;

    private StudentDB() {
        createStudentObjects();
    }

    public ArrayList<Student> getStudentList() {return mStudentList; }

    public int getAmountOfCourses() { return mAmountOfCourses;}


    protected void createStudentObjects() {
        Student student = new Student("Ian", "Alvarez", "123456");
        ArrayList<CourseEnrollment> courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC 411","A+"));
        courses.add(new CourseEnrollment("CPSC 349", "A"));
        mAmountOfCourses = courses.size();
        student.setCourses(courses);
        mStudentList = new ArrayList<Student>();
        mStudentList.add(student);

        student = new Student("Joesh", "Bautista","654321");
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC 349", "A"));
        courses.add(new CourseEnrollment("CPSC 454", "C+"));
        courses.add(new CourseEnrollment("CPSC 411", "A"));
        mStudentList.add(student);

    }

    public void addStudentObject(Student student) { //setter
        tempStudent = student;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        mStudentList = studentList;
    }
}
