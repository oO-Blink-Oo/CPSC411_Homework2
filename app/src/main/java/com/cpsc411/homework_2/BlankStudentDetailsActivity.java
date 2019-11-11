package com.cpsc411.homework_2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//import com.cpsc411.homework_2.adapter.CourseListAdapter;
//import com.cpsc411.homework_2.adapter.CourseListAdapter;
import com.cpsc411.homework_2.adapter.CourseListAdapter;
import com.cpsc411.homework_2.adapter.SummaryListAdapter;
import com.cpsc411.homework_2.model.CourseEnrollment;
import com.cpsc411.homework_2.model.Student;
import com.cpsc411.homework_2.model.StudentDB;

import java.util.ArrayList;

public class BlankStudentDetailsActivity extends AppCompatActivity {

    protected Menu detailMenu;
    protected String mFirstName;
    protected String mLastName;
    protected String mCWID;
    protected Student studentObj;
    protected CourseEnrollment courseObj;

    protected final String TAG = "Detail Screen";

    Button addBtn;

    ListView lv;
    protected CourseListAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        studentObj = new Student(" "," ", " ");
        ArrayList<CourseEnrollment> courses = new ArrayList<>();
        studentObj.setCourses(courses);


        addBtn = findViewById(R.id.add_course_button);
        lv = findViewById(R.id.courseListView);
        ad = new CourseListAdapter(studentObj);//this is the adapter pattern
        lv.setAdapter(ad);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText idText = (EditText) findViewById(R.id.edit_course_id);
                EditText gradeText = (EditText) findViewById(R.id.edit_grade_id);

                courseObj = new CourseEnrollment(idText.getText().toString(), gradeText.getText().toString());
                studentObj.addCourse(courseObj);

                idText.setText(" ");
                gradeText.setText(" ");
                ad.notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Custom Menu inflation
        getMenuInflater().inflate(R.menu.blank_screen_menu, menu);
        menu.findItem(R.id.blank_action_edit).setVisible(false);
        menu.findItem(R.id.blank_action_add).setVisible(false);
        menu.findItem(R.id.blank_action_done).setVisible(true);
        detailMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.blank_action_add) {

            EditText fName = (EditText)findViewById(R.id.s_first_name_id);
            EditText lName = (EditText)findViewById(R.id.s_last_name_id);
            EditText cwid = (EditText)findViewById(R.id.s_cwid_id);
            //get values inside editView
            mFirstName = fName.getText().toString();
            mLastName = lName.getText().toString();
            mCWID = cwid.getText().toString();
            Log.d("Text",mFirstName + " " + mLastName + " " + mCWID);
            // Create student
            studentObj = new Student(mFirstName,mLastName,mCWID);
            //add this student to the db
            StudentDB.getInstance().getStudentList().add(studentObj);


            detailMenu.findItem(R.id.blank_action_edit).setVisible(false);
            detailMenu.findItem(R.id.blank_action_add).setVisible(false);
            detailMenu.findItem(R.id.blank_action_done).setVisible(true);

            Intent intent = new Intent(this, SummaryLVActivity.class);
            startActivity(intent);

        } else if (item.getItemId() == R.id.blank_action_done) {
            EditText editView = findViewById(R.id.s_first_name_id);
            editView.setEnabled(false);
            editView = findViewById(R.id.s_last_name_id);
            editView.setEnabled(false);
            editView = findViewById(R.id.s_cwid_id);
            editView.setEnabled(false);
            detailMenu.findItem(R.id.blank_action_edit).setVisible(true);
            detailMenu.findItem(R.id.blank_action_add).setVisible(true);
            detailMenu.findItem(R.id.blank_action_done).setVisible(false);

        } else if (item.getItemId() == R.id.blank_action_edit) {
            EditText editView = findViewById(R.id.s_first_name_id);
            editView.setEnabled(true);
            editView = findViewById(R.id.s_last_name_id);
            editView.setEnabled(true);
            editView = findViewById(R.id.s_cwid_id);
            editView.setEnabled(true);
            detailMenu.findItem(R.id.blank_action_edit).setVisible(false);
            detailMenu.findItem(R.id.blank_action_add).setVisible(false);
            detailMenu.findItem(R.id.blank_action_done).setVisible(true);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        Log.d(TAG,"onStart() called");
        //ad.notifyDataSetChanged();
        super.onStart();
    }


    @Override
    protected void onResume() {
        Log.d(TAG,"onResume() called");
//        ad.notifyDataSetChanged();
        super.onResume();
    }


    @Override
    protected void onPause() {
        Log.d(TAG,"onPause() called");
        super.onPause();
    }


    @Override
    protected void onStop() {
        Log.d(TAG,"onStop() called");
        super.onStop();
    }


    @Override
    protected void onDestroy() {
        Log.d(TAG,"onDestroy() called");
        super.onDestroy();
    }
}
