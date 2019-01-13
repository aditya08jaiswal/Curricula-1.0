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

public class DLD2Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dld2);

        //Add AdMOb
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adView_activity_dld2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_dld2);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Digital Logic Design");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.dld2_listView);
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
        classMaterials.add(new DataURL("Lecture ZMP","https://drive.google.com/open?id=1OulX2EhIBkTLkGLrpoLQbFVod43ssP2u"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Digital Circuit - Anand Kumar", "https://drive.google.com/open?id=1tyaFFHvm0tZD87IffR_9IOwErNMSENqI"));
        books.add(new DataURL("Morris Mano", "https://drive.google.com/open?id=1tyaFFHvm0tZD87IffR_9IOwErNMSENqI"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 18","https://drive.google.com/open?id=1NVdKKQdZvZ5U_oRhNzNeAcoc-n8pmnZr"));
        examPapers.add(new DataURL("EndSem 18","https://drive.google.com/open?id=1Iv0uSpXmrP6SvekWZKVLGC6-_UPMJnQF"));

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }

}
