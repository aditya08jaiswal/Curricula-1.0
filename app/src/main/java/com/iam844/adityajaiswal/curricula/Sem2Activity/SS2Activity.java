package com.iam844.adityajaiswal.curricula.Sem2Activity;

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

public class SS2Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ss2);

        //Add AdMOb
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adView_activity_ss2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_ss2);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Signal and Systems");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.ss2_listView);
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

        //List
        List<DataURL> classMaterials = new ArrayList<>();
        classMaterials.add(new DataURL("Lecture 2","https://drive.google.com/open?id=1rC0AIW1aHsdgZ_Wk4Oz9heZTWCULW16M"));
        classMaterials.add(new DataURL("Lecture 3","https://drive.google.com/open?id=107WXYyy2HHfd_2__PvWIPHbRUznZ8yMl"));
        classMaterials.add(new DataURL("Lecture 4","https://drive.google.com/open?id=11U03JWi-qXF_p17L-gtiCBKys-tZb-43"));
        classMaterials.add(new DataURL("Lecture 5","https://drive.google.com/open?id=1Cm9t4NjFxDRKQes3gpx-u-GuA1rwxeHI"));
        classMaterials.add(new DataURL("Lecture 6","https://drive.google.com/open?id=1e-HUyRPlUcnNc_NCj5GUGyJcwGsNjbZb"));
        classMaterials.add(new DataURL("Lecture 7 - Systems Basic 1","https://drive.google.com/open?id=18y9wTOyKrqXgtjS2iKTY9EW3AYbPjPm3"));
        classMaterials.add(new DataURL("Lecture 7 - Systems Basic 2","https://drive.google.com/open?id=1n8tgLwu7ALEbqwQbIeESmOGetYx5Lfpw"));
        classMaterials.add(new DataURL("Lecture 8 - Property Conv 1","https://drive.google.com/open?id=1clyIsjmfjH5_h77ZBsWcvgeNT4gbDv2e"));
        classMaterials.add(new DataURL("Lecture 8 - Property Conv 2","https://drive.google.com/open?id=1q3A6ejoV9SJgMbfpiO25rf7WeQli9muG"));
        classMaterials.add(new DataURL("Lecture 9 - Convo Corr","https://drive.google.com/open?id=1i1FHdoUThnVkRQL2clZwHcJKCYnYbDr8"));
        classMaterials.add(new DataURL("Lecture 11 - Freq Dom Fourier Series","https://drive.google.com/open?id=1RBMz3T1jx6ZGtlAwgP2FjOkgrJH9IG3w"));
        classMaterials.add(new DataURL("Lecture 12 - Freq Dom Fourier Trans","https://drive.google.com/open?id=19UsNf0I047Nm1WJVj4ytRaWtEVvcclFm"));
        classMaterials.add(new DataURL("Lecture 13 - Freq Dom Dis fs","https://drive.google.com/open?id=1U7ykZG2OjxqLNYK0Va1yY3Xw0yRssYio"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("BP Lathi - Linear Systems and Signals","https://drive.google.com/open?id=1Tdsu1bR5Kjm7qOHvtE4c-TaC4GSQ5Kti"));
        books.add(new DataURL("Proakis - DSP Principles Algorithms Applications ","https://drive.google.com/open?id=1rbNUlFdYncc1FZZRoL9KOFZ3Rs0S1eYe"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("Tutorial Exam - 1 18", "https://drive.google.com/open?id=1i7qdlklpikFxq69zEFPIYd-zNKMAGcSD"));
        examPapers.add(new DataURL("Tutorial Exam - 2 18", "https://drive.google.com/open?id=1v-nXNAnOsTwp319ReGSu1jMxQzrCtLzy"));
        examPapers.add(new DataURL("MidSem 18", "https://drive.google.com/open?id=1UyZ5X4mshKtKiyK3a-AlX34rZnBbz1pR"));
        examPapers.add(new DataURL("EndSem 18", "https://drive.google.com/open?id=1TfZW-YmWytTC9Ai0ZIQRQpMpS96XlDj4"));

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }
}
