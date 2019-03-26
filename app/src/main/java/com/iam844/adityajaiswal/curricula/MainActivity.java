package com.iam844.adityajaiswal.curricula;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
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

import com.iam844.adityajaiswal.curricula.ExtraActivity.AcademicCalendarActivity;
import com.iam844.adityajaiswal.curricula.ExtraActivity.AboutActivity;
import com.iam844.adityajaiswal.curricula.ExtraActivity.FirstYearTimeTableActivity;
import com.iam844.adityajaiswal.curricula.Adapter.SemAdapter;
import com.iam844.adityajaiswal.curricula.Model.Semester;
import com.iam844.adityajaiswal.curricula.ExtraActivity.SecondYearTimeTableActivity;
import com.iam844.adityajaiswal.curricula.SemesterActivity.FirstSemActivity;
import com.iam844.adityajaiswal.curricula.SemesterActivity.FourthSemActivity;
import com.iam844.adityajaiswal.curricula.SemesterActivity.SecondSemActivity;
import com.iam844.adityajaiswal.curricula.SemesterActivity.ThirdSemActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        //Navigation Drawer
        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.NavigationDrawerOpen, R.string.NavigationDrawerClose);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //Navigation View for items when tapped
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                mDrawerLayout.closeDrawers();

                int id = menuItem.getItemId();

                switch (id) {

                    case R.id.nav_academic_calendar:

                        Intent academiccalendar = new Intent(MainActivity.this, AcademicCalendarActivity.class);
                        startActivity(academiccalendar);

                        Toast.makeText(getApplicationContext(),"Academic Calendar 18-19",Toast.LENGTH_LONG).show();
                        return true;

                    case R.id.nav_firstyear_timetable:

                        Intent firstyear = new Intent(MainActivity.this, FirstYearTimeTableActivity.class);
                        startActivity(firstyear);

                        Toast.makeText(getApplicationContext(),"I Year",Toast.LENGTH_LONG).show();
                        return true;

                    case R.id.nav_secondyear_timetable:

                        Intent secondyear = new Intent(MainActivity.this, SecondYearTimeTableActivity.class);
                        startActivity(secondyear);

                        Toast.makeText(getApplicationContext(),"II Year",Toast.LENGTH_LONG).show();
                        return true;

                    case R.id.nav_add_materials:

                        Toast.makeText(getApplicationContext(), "Add materials to Drive", Toast.LENGTH_SHORT).show();

                        Intent intentAddMaterial = new Intent(Intent.ACTION_VIEW);
                        intentAddMaterial.setData(Uri.parse("https://drive.google.com/drive/folders/1DzCTj34XOVlmk2pmAMtCr8GMtECjRBa4?usp=sharing"));
                        if (intentAddMaterial.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentAddMaterial);
                        }
                        return true;

                    case R.id.nav_feedback:

                        Toast.makeText(getApplicationContext(), "Your suggestions are valuable", Toast.LENGTH_SHORT).show();

                        Intent intentFeedback = new Intent(Intent.ACTION_SENDTO);
                        intentFeedback.setData(Uri.parse("mailto:deviam844@gmail.com")); // only email apps should handle this
                        if (intentFeedback.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentFeedback);
                        }
                        return true;

                    case R.id.nav_contribute:

                        Toast.makeText(getApplicationContext(), "Fork and contribute on GitHub", Toast.LENGTH_SHORT).show();

                        Intent intentContribute = new Intent(Intent.ACTION_VIEW);
                        intentContribute.setData(Uri.parse("https://github.com/iam844/Curricula"));
                        if (intentContribute.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentContribute);
                        }
                        return true;

                    default:
                        return true;
                }

            }
        });

        //Ad
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        mAdView = findViewById(R.id.adView_activity_main);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Content
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
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
