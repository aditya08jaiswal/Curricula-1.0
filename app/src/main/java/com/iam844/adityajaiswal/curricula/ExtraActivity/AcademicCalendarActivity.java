package com.iam844.adityajaiswal.curricula.ExtraActivity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.iam844.adityajaiswal.curricula.R;

public class AcademicCalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_calendar);

        Toolbar toolbar = findViewById(R.id.toolbar_academic_calendar);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Academic Calendar 18-19");
        actionBar.setDisplayHomeAsUpEnabled(true);

        ImageView image = findViewById(R.id.academic_calendar_image);
        image.setImageResource(R.drawable.academic_calendar);

    }

}
