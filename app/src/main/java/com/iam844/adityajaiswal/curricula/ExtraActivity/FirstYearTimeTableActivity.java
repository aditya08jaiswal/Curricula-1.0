package com.iam844.adityajaiswal.curricula.ExtraActivity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.iam844.adityajaiswal.curricula.Adapter.FirstYearDivisionTimeTableAdapter;
import com.iam844.adityajaiswal.curricula.R;

public class FirstYearTimeTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_year_time_table);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_firstyear_timetable);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("I Year Time Table");
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.firstyear_timetable_viewPager);

        // Create an adapter that knows which fragment should be shown on each page
        FirstYearDivisionTimeTableAdapter adapter = new FirstYearDivisionTimeTableAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        //Setup tabs
        TabLayout tabLayout = findViewById(R.id.firstyear_timetable_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
