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

public class EM2Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_em2);

        //Add AdMOb
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adView_activity_em2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_em2);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Engineering Mechanics");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.em2_listView);
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
        classMaterials.add(new DataURL("ME101-Lecture12-KD","https://drive.google.com/open?id=1ABf0VY3XxITt3sv1bXpduY74HrIBRltT"));
        classMaterials.add(new DataURL("Mechanical Vibrations Book","https://drive.google.com/open?id=1XZ0HnyUkiA3WJOVFXOP8t7sz8J45Ve0k"));
        classMaterials.add(new DataURL("Mechanical Vibrations","https://drive.google.com/open?id=1sJbeLyVoewmcsf95O3dKmHKEOksYoczp"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Dynamic by HC HIBBELER","https://drive.google.com/open?id=1XfUUbDG6WtG5DffrL5BdYqZOHSdbujBH"));
        books.add(new DataURL("Statics by HC HIBBLER","https://drive.google.com/open?id=1dPxxZ8G98nsUxeS7HEsTM1dFJD74-RJg"));
        books.add(new DataURL("Engineering Mechanics - RS Khurmi","https://drive.google.com/open?id=17mDR3Ad3uqBckAYl9wIIY66x2LyHJawR"));
        books.add(new DataURL("Vector Mechanics for Engineers Statics and Dynamics - Beer","https://drive.google.com/open?id=1HxZLRp2jceEOr0lBFxdfGy46VsgyT8R0"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("Class Test 18", "https://drive.google.com/open?id=1r6LXhiwdV2zzNXaQEJ-hhJf71sSNGALS"));
        examPapers.add(new DataURL("MidSem 18", "https://drive.google.com/open?id=1Oc4ZsfP65FCO9__vI1Jw-6NDMWRaQJXD"));
        examPapers.add(new DataURL("EndSem 18", "https://drive.google.com/open?id=1RGwZP3I9cI2hWJhtxt6bYCXm9GjLdhYh"));

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }

}
