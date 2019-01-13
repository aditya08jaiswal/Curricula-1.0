package com.iam844.adityajaiswal.curricula.SemesterActivity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.iam844.adityajaiswal.curricula.Sem1Activity.ECS1Activity;
import com.iam844.adityajaiswal.curricula.Sem1Activity.EDC1Activity;
import com.iam844.adityajaiswal.curricula.Sem1Activity.EM1Activity;
import com.iam844.adityajaiswal.curricula.Sem1Activity.EP1Activity;
import com.iam844.adityajaiswal.curricula.Sem1Activity.FCP1Activity;
import com.iam844.adityajaiswal.curricula.Sem1Activity.ICTOne1Activity;
import com.iam844.adityajaiswal.curricula.R;
import com.iam844.adityajaiswal.curricula.Model.Subject;
import com.iam844.adityajaiswal.curricula.Adapter.SubjectAdapter;

import java.util.ArrayList;

public class FirstSemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_sem);

        //Add AdMOb
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adView_activity_first_sem);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_first_sem);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("1st Semester");
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Create list of data
        final ArrayList<Subject> subjectList = new ArrayList<>();

        subjectList.add(new Subject("Fundamentals of Computers & Programming", R.drawable.fcp1, FCP1Activity.class));
        subjectList.add(new Subject("Electronic Devices and Circuits", R.drawable.edc1, EDC1Activity.class));
        subjectList.add(new Subject("Engineering Mathematics", R.drawable.em1, EM1Activity.class));
        subjectList.add(new Subject("Engineering Physics", R.drawable.ep1, EP1Activity.class));
        subjectList.add(new Subject("English and Communication Skills", R.drawable.ecs1, ECS1Activity.class));
        subjectList.add(new Subject("ICT Workshop - I", R.drawable.ictone1, ICTOne1Activity.class));

        // Create an object of SubjectAdapter and ListView, then set Adapter to ListView
        ListView sem1listView = findViewById(R.id.sem1_listView);
        final SubjectAdapter objSubAdapter = new SubjectAdapter(this, R.layout.subject_item, subjectList);
        sem1listView.setAdapter(objSubAdapter);

        //Click listeners
        sem1listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                startActivity(new Intent(FirstSemActivity.this, subjectList.get(position).getSubActivity()));

                Toast.makeText(FirstSemActivity.this, subjectList.get(position).getSubListName(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}
