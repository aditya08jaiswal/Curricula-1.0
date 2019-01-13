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

public class EM1Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_em1);

        //Add AdMOb
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adView_activity_em1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_em1);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Engineering Mathematics");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.em1_listView);
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
        classMaterials.add(new DataURL("Decomposition of Matrix", "https://drive.google.com/open?id=1jmQ_Z5o-vxVhPIvdnKc07MwwmaNe6ePB"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("B.S. Grewal", "https://drive.google.com/open?id=1oEq3_9QCnkD3mLKPdrz2UmyphxkSDMGe"));
        books.add(new DataURL("S.S.Patil Curve Tracing", "https://drive.google.com/open?id=1PMhnZabKnlO0isd90r7py2tiKRaAfyZ-"));
        books.add(new DataURL("Thomas Calculus", "https://drive.google.com/open?id=1an0Q0Fi1kEEOUzziOqu_7iiQGmePN4gw"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 18", "https://drive.google.com/open?id=1fOUrdGUF69hmyLTVU7Ad9TksUapCMeKn"));
        examPapers.add(new DataURL("EndSem 18", "https://drive.google.com/open?id=1eQ1CiMxcufEQ2bxHeFRygckNRYS-ts2Z"));
        examPapers.add(new DataURL("MidSem 17", "https://drive.google.com/open?id=19yk1AqiHiSf9cCVHCI_Y6tyH2ZZtc30R"));
        examPapers.add(new DataURL("EndSem 17", "https://drive.google.com/open?id=1978kbWYHndtTI89z-CCjrkXL8un2EIqg"));
        examPapers.add(new DataURL("Class Test 17", "https://drive.google.com/open?id=1sS5svCO4xQsu1-iO6QKfFLo98WLzHBM0"));

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }

}
