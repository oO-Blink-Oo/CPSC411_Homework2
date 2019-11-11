package com.cpsc411.homework_2;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//import com.cpsc411.homework_2.adapter.CourseListAdapter;
import com.cpsc411.homework_2.adapter.CourseListAdapter;
import com.cpsc411.homework_2.model.CourseEnrollment;
import com.cpsc411.homework_2.model.Student;
import com.cpsc411.homework_2.model.StudentDB;

import java.util.ArrayList;

public class StudentDetailsActivity extends AppCompatActivity {

    protected Menu detailMenu;
    protected int studentIndex;
    protected Student studentObj;
    protected final String TAG = "Detail Screen";

    ListView lv;
    protected CourseListAdapter ad;
    protected CourseEnrollment courseObj;

    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);


        studentIndex = getIntent().getIntExtra("StudentIndex", 0);
        TextView tv = findViewById(R.id.display_string_id);
        //Display the Person Index
        String origStr = (String)tv.getText();
        tv.setText(origStr + studentIndex);
        tv.setTextSize(24);
        //
        studentObj = StudentDB.getInstance().getStudentList().get(studentIndex);
        //
        EditText editView = findViewById(R.id.s_first_name_id);
        editView.setText(studentObj.getFirstName());
        editView.setEnabled(false);
        editView = findViewById(R.id.s_last_name_id);
        editView.setText(studentObj.getLastName());
        editView.setEnabled(false);
        editView = findViewById(R.id.s_cwid_id);
        editView.setText(studentObj.getCWID());
        editView.setEnabled(false);


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
                studentObj.setCourses(studentObj.getCourses());

                idText.setText(" ");
                gradeText.setText(" ");
                ad.notifyDataSetChanged();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Custom Menu inflation
        getMenuInflater().inflate(R.menu.detail_screen_menu, menu);
        menu.findItem(R.id.action_edit).setVisible(true);
        menu.findItem(R.id.action_done).setVisible(false);
        detailMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_edit) {
            EditText editView = findViewById(R.id.s_first_name_id);
            editView.setEnabled(true);
            editView = findViewById(R.id.s_last_name_id);
            editView.setEnabled(true);
            editView = findViewById(R.id.s_cwid_id);
            editView.setEnabled(true);
            //
            item.setVisible(false);
            detailMenu.findItem(R.id.action_done).setVisible(true);
        } else if (item.getItemId() == R.id.action_done) {
            EditText editView = findViewById(R.id.s_first_name_id);
            StudentDB.getInstance().getStudentList().get(studentIndex).setFirstName(editView.getText().toString());
            editView.setEnabled(false);
            editView = findViewById(R.id.s_last_name_id);
            StudentDB.getInstance().getStudentList().get(studentIndex).setLastName(editView.getText().toString());
            editView.setEnabled(false);
            editView = findViewById(R.id.s_cwid_id);
            StudentDB.getInstance().getStudentList().get(studentIndex).setCWID(editView.getText().toString());
            editView.setEnabled(false);
            item.setVisible(false);
            detailMenu.findItem(R.id.action_edit).setVisible(true);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        Log.d(TAG,"onStart() called");
        super.onStart();
    }

    @Override
        protected void onResume() {
        Log.d(TAG,"onResume() called");
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
