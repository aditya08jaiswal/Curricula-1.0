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
import com.iam844.adityajaiswal.curricula.Sem3Activity.AFL3Activity;
import com.iam844.adityajaiswal.curricula.Sem3Activity.CE3Activity;
import com.iam844.adityajaiswal.curricula.Sem3Activity.CO3Activity;
import com.iam844.adityajaiswal.curricula.Sem3Activity.EC3Activity;
import com.iam844.adityajaiswal.curricula.Sem3Activity.MPI3Activity;
import com.iam844.adityajaiswal.curricula.Sem3Activity.PSA3Activity;
import com.iam844.adityajaiswal.curricula.R;
import com.iam844.adityajaiswal.curricula.Model.Subject;
import com.iam844.adityajaiswal.curricula.Adapter.SubjectAdapter;

import java.util.ArrayList;

public class ThirdSemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_sem);

        //Add AdMOb
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adView_activity_third_sem);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_third_sem);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("3rd Semester");
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Create list of data
        final ArrayList<Subject> subjectList = new ArrayList<>();

        subjectList.add(new Subject("Computer Organization", R.drawable.co3, CO3Activity.class));
        subjectList.add(new Subject("Microprocessor and Interfacing", R.drawable.mpi3, MPI3Activity.class));
        subjectList.add(new Subject("Communication Engineering", R.drawable.ce3, CE3Activity.class));
        subjectList.add(new Subject("Probability and Statistical Analysis", R.drawable.psa3, PSA3Activity.class));
        subjectList.add(new Subject("Automata Formal Languages", R.drawable.afl3, AFL3Activity.class));
        subjectList.add(new Subject("Electronic Circuits", R.drawable.ec3, EC3Activity.class));

        // Create an object of SubjectAdapter and ListView, then set Adapter to ListView
        ListView sem3listView = findViewById(R.id.sem3_listView);
        SubjectAdapter objSubAdapter = new SubjectAdapter(this, R.layout.subject_item, subjectList);
        sem3listView.setAdapter(objSubAdapter);

        //Click listeners
        sem3listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                startActivity(new Intent(ThirdSemActivity.this, subjectList.get(position).getSubActivity()));

                Toast.makeText(ThirdSemActivity.this, subjectList.get(position).getSubListName(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}