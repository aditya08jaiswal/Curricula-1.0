package com.iam844.adityajaiswal.curricula.SemesterActivity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.iam844.adityajaiswal.curricula.R;
import com.iam844.adityajaiswal.curricula.Model.Subject;
import com.iam844.adityajaiswal.curricula.Adapter.SubjectAdapter;
import com.iam844.adityajaiswal.curricula.Sem2Activity.DSA2Activity;
import com.iam844.adityajaiswal.curricula.Sem2Activity.DM2Activity;
import com.iam844.adityajaiswal.curricula.Sem2Activity.DLD2Activity;
import com.iam844.adityajaiswal.curricula.Sem2Activity.SS2Activity;
import com.iam844.adityajaiswal.curricula.Sem2Activity.EN2Activity;
import com.iam844.adityajaiswal.curricula.Sem2Activity.EM2Activity;

import java.util.ArrayList;

public class SecondSemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_sem);

        //Add AdMOb
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adView_activity_second_sem);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_second_sem);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("2nd Semester");
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Create list of data
        final ArrayList<Subject> subjectList = new ArrayList<>();

        subjectList.add(new Subject("Data Structures and Algorithm", R.drawable.dsa2, DSA2Activity.class));
        subjectList.add(new Subject("Discrete Mathematics", R.drawable.dm2, DM2Activity.class));
        subjectList.add(new Subject("Digital Logic Design", R.drawable.dld2, DLD2Activity.class));
        subjectList.add(new Subject("Signal and Systems", R.drawable.ss2, SS2Activity.class));
        subjectList.add(new Subject("Electrical Networks", R.drawable.en2, EN2Activity.class));
        subjectList.add(new Subject("Engineering Mechanics", R.drawable.em2, EM2Activity.class));

        // Create an object of SubjectAdapter and ListView, then set Adapter to ListView
        ListView sem2listView = findViewById(R.id.sem2_listView);
        SubjectAdapter objSubAdapter = new SubjectAdapter(this, R.layout.subject_item, subjectList);
        sem2listView.setAdapter(objSubAdapter);

        //Click listeners
        sem2listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                startActivity(new Intent(SecondSemActivity.this, subjectList.get(position).getSubActivity()));

                Toast.makeText(SecondSemActivity.this, subjectList.get(position).getSubListName(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}