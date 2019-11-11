package com.cpsc411.homework_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cpsc411.homework_2.adapter.SummaryListAdapter;

public class SummaryLVActivity extends AppCompatActivity{

    ListView mSummaryView;
    protected Menu detailMenu;
    protected  SummaryListAdapter ad;
    protected  final String TAG = "Summary Screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"onCreate() called");
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.student_list_lv);
        //
        mSummaryView = findViewById(R.id.summary_list_id);
        ad = new SummaryListAdapter();//this is the adapter pattern
        mSummaryView.setAdapter(ad);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.summary_screen_menu, menu);
        menu.findItem(R.id.action_add).setVisible(true);
        detailMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            Intent intent = new Intent(this, BlankStudentDetailsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        Log.d(TAG,"onStart() called");
        ad.notifyDataSetChanged();
        super.onStart();
    }


    @Override
    protected void onResume() {
        Log.d(TAG,"onResume() called");
        ad.notifyDataSetChanged();
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
