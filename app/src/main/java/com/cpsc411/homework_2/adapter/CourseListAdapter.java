package com.cpsc411.homework_2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cpsc411.homework_2.R;
import com.cpsc411.homework_2.model.CourseEnrollment;
import com.cpsc411.homework_2.model.Student;
import com.cpsc411.homework_2.model.StudentDB;

import java.util.ArrayList;

public class CourseListAdapter extends BaseAdapter {
//    private Context mContext;
    private ArrayList<CourseEnrollment> mCourseEnrollments;

    public CourseListAdapter(Student student) {
        mCourseEnrollments = student.getCourses();
        //        this.mContext= context;
//        this.mCourseEnrollments = courses;
    }

    @Override
    public int getCount() {
        return mCourseEnrollments.size();
    }

    @Override
    public Object getItem(int i) {
       return StudentDB.getInstance().getStudentList().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row_view;
        // inflate the layout for each list row
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.course_row, viewGroup, false);
        } else {row_view =view;}


        ((TextView) row_view.findViewById(R.id.course_id_row)).setText(mCourseEnrollments.get(i).getCourseID());
        ((TextView) row_view.findViewById(R.id.grade_id_row)).setText(mCourseEnrollments.get(i).getGrade());


        // returns the view for the current row
        return row_view;
    }
}
