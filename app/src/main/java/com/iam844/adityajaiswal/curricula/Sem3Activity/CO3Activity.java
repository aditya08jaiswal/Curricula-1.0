package com.iam844.adityajaiswal.curricula.Sem3Activity;

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

public class CO3Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co3);

        //Add AdMOb
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adView_activity_co3);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_co3);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Computer Organization");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.co3_listView);
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
        classMaterials.add(new DataURL("ASCI","https://drive.google.com/open?id=1tDSxZJ0tsFp7jEmn-J2ICvNm8UdlUfhA"));
        classMaterials.add(new DataURL("CO Intro","https://drive.google.com/open?id=1QSxqTu-LpA45dI_vjXfqiOJ78sLeJp4b"));
        classMaterials.add(new DataURL("ISA","https://drive.google.com/open?id=1QywszMBgBVu3Z5yrqJMw7YXjNoiCJWt1"));
        classMaterials.add(new DataURL("MicroArch","https://drive.google.com/open?id=1CXE-7xPoiGCpHCxvp6SIaWQbA2eaNvOC"));
        classMaterials.add(new DataURL("Computer Organization Basic","https://drive.google.com/open?id=1D2P4c0RToZ21jwoG79q8vxf6v2BRwO10"));
        classMaterials.add(new DataURL("Cache Memory","https://drive.google.com/open?id=1oVfdt8LJf4UxpkezImPioVUHwTeT0jD_"));
        classMaterials.add(new DataURL("Internal Memory","https://drive.google.com/open?id=1cU2f_UEaVczdOQcGW5qfbJ1VJnn1i6qH"));
        classMaterials.add(new DataURL("External Memory","https://drive.google.com/open?id=1y7byFBnrhCC-Y7onhpGOyUpbq4OFSboi"));
        classMaterials.add(new DataURL("Virtual Memory","https://drive.google.com/open?id=1ri0e6h0C_5WgSB04lGBD3hxcJ4NsgwQ_"));
        classMaterials.add(new DataURL("Input Output","https://drive.google.com/open?id=17MqElwZ3aArDo5D7HabYzokdq-wK6d79"));
        classMaterials.add(new DataURL("MicroArch SingleCycle Processor","https://drive.google.com/open?id=1dtWymgbvoBs7qWnS4pC9R1iS2BVkafEl"));
        classMaterials.add(new DataURL("MicroArch MultiCycle Processor","https://drive.google.com/open?id=1fYvNVUvEJFfbn-ITOwqjIBMrMBoJicZF"));
        classMaterials.add(new DataURL("Performance","https://drive.google.com/open?id=1DSxgoF-iFztIx8yhzF7yiXHrC5TMLY3M"));
        classMaterials.add(new DataURL("Pipelining, Control Unit And Hazards","https://drive.google.com/open?id=1KyXvAqcw1mss2RFtiHDlbgA5WBzmP6xo"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Morris Mano - Computer System Architecture","https://drive.google.com/open?id=1nC6RPZ-kNVWBBjTtYpXurPUwbQFp6gjv"));
        books.add(new DataURL("Patterson - Computer Organization and Design","https://drive.google.com/open?id=15s7rX64gXk8s91XoiVHxzZhocdGoozS7"));
        books.add(new DataURL("William Stallings - Computer Organization and Architecture Designing for Performance","https://drive.google.com/open?id=1KD0Fck3MMgdAdSYumaywFa4pwqY1DCS2"));
        books.add(new DataURL("William Stallings - Solutions","https://drive.google.com/open?id=1W6ws55-s380yUSsiN_5fUKuzYTCio97e"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 18", "https://drive.google.com/open?id=1vm-Wdna5JWWHlgQglWaUhTCisNvyx878"));
        examPapers.add(new DataURL("EndSem 18", "https://drive.google.com/open?id=1UR-C6L7yjbpIhp0OBPoeSJ4JBf2m4-g8"));
        examPapers.add(new DataURL("EndSem Supplementary 18", "https://drive.google.com/open?id=1MAc7Za4j58510PfbJWbrYs2ttAPf7_rI"));

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }

}
