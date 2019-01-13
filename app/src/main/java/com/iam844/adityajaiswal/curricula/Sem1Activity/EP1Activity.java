package com.iam844.adityajaiswal.curricula.Sem1Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.iam844.adityajaiswal.curricula.Adapter.MaterialExpandableListAdapter;
import com.iam844.adityajaiswal.curricula.Model.DataURL;
import com.iam844.adityajaiswal.curricula.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EP1Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ep1);

        //Add AdMOb
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adView_activity_ep1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_ep1);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Engineering Physics");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.ep1_listView);
        initData();
        listAdapter = new MaterialExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(listHash.get(listDataHeader.get(i)).get(i1).getmURL()));
                startActivity(intent);

                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(i) + " : " + listHash.get(listDataHeader.get(i)).get(i1).getmName(),
                        Toast.LENGTH_SHORT).show();

                return false;
            }
        });

    }

    public void initData() {
        listDataHeader = new ArrayList<>();     //Group list
        listHash = new HashMap<>();             //Child List

        //Header
        listDataHeader.add("Class Materials");
        listDataHeader.add("Books");
        listDataHeader.add("Exam Papers");
        listDataHeader.add("Practicals");

        //List
        List<DataURL> classMaterials = new ArrayList<>();
        classMaterials.add(new DataURL("EP Notes", "https://drive.google.com/open?id=18Eyg7lySWzdw88Ul4RilRD-ouXixjN9g"));
        classMaterials.add(new DataURL("Laser Notes", "https://drive.google.com/open?id=1yjGW5jHwK4jvzEewPhKdmi64EXRInIbA"));
        classMaterials.add(new DataURL("Laser PPT", "https://drive.google.com/open?id=15JhHNGN2_N3OL3SmZXvwjtNXE3qz7g3z"));
        classMaterials.add(new DataURL("LASER", "https://drive.google.com/open?id=1ileG_tRQTphxxW_bKhlbYO4zTEEEE3Ce"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Introduction To Electrodynamics - Griffiths", "https://drive.google.com/open?id=1Gy5RdISHbCYV7jefVGTpLZAHPSYO0Suq"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 18", "https://drive.google.com/open?id=1yscLnE0Bovl90Yno2dSb4w2hWkQ9C7i-"));
        examPapers.add(new DataURL("EndSem 18", "https://drive.google.com/open?id=11ZQRuf4G5sjscuhGMDjAuu6Sw-kmL9LV"));
        examPapers.add(new DataURL("MidSem 17", "https://drive.google.com/open?id=1idLi6tiUMapnh55GhMMWCzW1Zhvv_gAp"));
        examPapers.add(new DataURL("EndSem 17", "https://drive.google.com/open?id=1HI2B8ZSEEkimCr2NDRYFGf_mWinZiO51"));

        List<DataURL> practicals = new ArrayList<>();
        practicals.add(new DataURL("Practical 1", "https://drive.google.com/open?id=1faHjCdeU8rrd5YreUB1qA0O-OSmbV5zw"));
        practicals.add(new DataURL("Practical 2", "https://drive.google.com/open?id=1-5RhCYF8HHzlVeco6vdNI9sH4s_-u4Eo"));
        practicals.add(new DataURL("Practical 3", "https://drive.google.com/open?id=1TXmbIQUFpJTplrRSNjqMlpfqxdkJf0KI"));
        practicals.add(new DataURL("Practical 4", "https://drive.google.com/open?id=1B4MSw6t1b1eacb19UA9hz7M0nZGpaME9"));
        practicals.add(new DataURL("Practical 5-6", "https://drive.google.com/open?id=196HCoaA-0eD9gJoQWU3TC5dF_uE_FO7W"));
        practicals.add(new DataURL("Practical 7", "https://drive.google.com/open?id=10MzDv-cIWMIhoM9iDCVW5eFCn9OlBHOZ"));
        practicals.add(new DataURL("Practical 8", "https://drive.google.com/open?id=1w4RtWqZmscf1Rg9b6hNo6B_sNdrF4IvY"));

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
        listHash.put(listDataHeader.get(3), practicals);
    }

}
