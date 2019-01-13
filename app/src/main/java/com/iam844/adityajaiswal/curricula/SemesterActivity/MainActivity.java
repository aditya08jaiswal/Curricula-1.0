package com.iam844.adityajaiswal.curricula.SemesterActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import com.iam844.adityajaiswal.curricula.ExtraActivity.AboutActivity;
import com.iam844.adityajaiswal.curricula.R;
import com.iam844.adityajaiswal.curricula.Adapter.SemAdapter;
import com.iam844.adityajaiswal.curricula.Model.Semester;
import com.iam844.adityajaiswal.curricula.ExtraActivity.SuggestionsActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_main);
        setSupportActionBar(toolbar);

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        mAdView = findViewById(R.id.adView_activity_main);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        GridView semGridView = findViewById(R.id.semGridView);

        final ArrayList<Semester> semList = new ArrayList<>();

        semList.add(new Semester("Semester 1",R.drawable.sem1, FirstSemActivity.class));
        semList.add(new Semester("Semester 2",R.drawable.sem2, SecondSemActivity.class));
        semList.add(new Semester("Semester 3",R.drawable.sem3, ThirdSemActivity.class));
        semList.add(new Semester("Semester 4",R.drawable.sem4, FourthSemActivity.class));

        // Create an object of SemAdapter and set Adapter to GirdView
        SemAdapter objSemAdapter = new SemAdapter(this, R.layout.sem_item, semList);
        semGridView.setAdapter(objSemAdapter);

        // Implement setOnItemClickListener event on GridView
        semGridView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                startActivity(new Intent(MainActivity.this, semList.get(position).getSemActivity()));

                Toast.makeText(MainActivity.this, semList.get(position).getSemListName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case R.id.menu_suggestion:

                Intent suggestions = new Intent(this, SuggestionsActivity.class);
                startActivity(suggestions);

                Toast.makeText(getApplicationContext(),"Suggestions",Toast.LENGTH_LONG).show();
                return true;

            case R.id.menu_about:

                Intent about = new Intent(this, AboutActivity.class);
                startActivity(about);

                Toast.makeText(getApplicationContext(),"About Developer & Designer",Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
