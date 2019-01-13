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

public class DSA2Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsa2);

        //Add AdMOb
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adView_activity_dsa2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_dsa2);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Data Structures and Algorithm");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.dsa2_listView);
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
//        listDataHeader.add("Books");
        listDataHeader.add("Exam Papers");

        //List
        List<DataURL> classMaterials = new ArrayList<>();
        classMaterials.add(new DataURL("Queue and its Applications","https://drive.google.com/open?id=1mkNUODE3qlQlocyvrWm-Z41dQzu3FcOE"));
        classMaterials.add(new DataURL("Sorting and Searching","https://drive.google.com/open?id=1QRTwpOXTq7AEu_ntmJXAAAn1E8FuUaKB"));
        classMaterials.add(new DataURL("Algorithm Analysis","https://drive.google.com/open?id=1v0V77G6_wdXdJnc3O9dX5OM3Yy8mTyYn"));
        classMaterials.add(new DataURL("Graph","https://drive.google.com/open?id=1x1l9JyHjGuIM3OBbyMQJmOBfFCxEANsZ"));
        classMaterials.add(new DataURL("Graph [BFS]","https://drive.google.com/open?id=1cfDcWBZXNXOHe5DFWAo7bvR7QhT-CA2P"));
        classMaterials.add(new DataURL("Graph [DFS]","https://drive.google.com/open?id=1jvxktlKM1dvKsfHiBxVmTzQcNzRHB12m"));
        classMaterials.add(new DataURL("Hashing","https://drive.google.com/open?id=12MqiqYEkRADS645h7wdAMPpamuJCp85j"));
        classMaterials.add(new DataURL("Intro to DS for MidSem","https://drive.google.com/open?id=11eW9H-ZKPvNHakBa2OHklikj9NlH8WjR"));
        classMaterials.add(new DataURL("Intro Data Structure","https://drive.google.com/open?id=1IW9WF7weVBo-jP_VaH9HRsQw_vsrs42J"));
        classMaterials.add(new DataURL("Stack","https://drive.google.com/open?id=1_RSiWHyC7hFZwzvxdSzyJRRpN_ryCu44"));
        classMaterials.add(new DataURL("Stack Application - Recursion","https://drive.google.com/open?id=1n9X2kWqkn5gxAEPPNoe3heTzxq1s5XMq"));
        classMaterials.add(new DataURL("Stack-Applications-Arithmetic Expressions","https://drive.google.com/open?id=191xyY4FMBXuHHUVpBkE6RvpEG_P4U8Ys"));
        classMaterials.add(new DataURL("Link List","https://drive.google.com/open?id=1LASO_xJPelGO1f8Up2qs3pOy6RVSSYnm"));
        classMaterials.add(new DataURL("Trees new","https://drive.google.com/open?id=1l_k0pRV6hxKkqPJbGqqkOynJabnN61Yk"));
        classMaterials.add(new DataURL("AVL Trees","https://drive.google.com/open?id=1i5C3wrCGdwG_DjGrjwwQYQs4iGHFw4Ll"));
        classMaterials.add(new DataURL("B Trees","https://drive.google.com/open?id=1MFvpAEk2lbvp0-KAu7HXxJRtL8J3WMU5"));

//        List<DataURL> books = new ArrayList<>();
//        books.add(new DataURL("",""));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 18", "https://drive.google.com/open?id=1IWO4YSRnfKmF3v3XjXG_ivnvYF7Fkt-3"));
        examPapers.add(new DataURL("EndSem 18", "https://drive.google.com/open?id=17zNe7vyIwZE1zQPAagrTYErtehpt0w6c"));

        listHash.put(listDataHeader.get(0), classMaterials);
//        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(1), examPapers);
    }

}
