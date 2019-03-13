package com.iam844.adityajaiswal.curricula.Sem4Activity;

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

public class DBMS4Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbms4);

        //Add AdMOb
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adView_activity_dbms4);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_dbms4);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Data Base Management System");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.dbms4_listView);
        initData();
        listAdapter = new MaterialExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                if(listHash.get(listDataHeader.get(i)).get(i1).getmURL() == null ){
                    Toast.makeText(getApplicationContext(), "Will be updated soon!", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(listHash.get(listDataHeader.get(i)).get(i1).getmURL()));
                    startActivity(intent);

                    Toast.makeText(getApplicationContext(),
                            listDataHeader.get(i) + " : " + listHash.get(listDataHeader.get(i)).get(i1).getmName(),
                            Toast.LENGTH_SHORT).show();
                }

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
        classMaterials.add(new DataURL("Introduction","https://drive.google.com/open?id=1JumikR1eG4myvLG8Cpm_OpEkSK5VGaTe"));
        classMaterials.add(new DataURL("Concurrency Control","https://drive.google.com/open?id=1_Ub_qMem6ttmSvdAOqdYQDVay9lx5FGx"));
        classMaterials.add(new DataURL("Constraints","https://drive.google.com/open?id=18yLiFk9IpwA0e1OUT8m0bmA6sQvnvBTq"));
        classMaterials.add(new DataURL("Enhanced ER Model","https://drive.google.com/open?id=1mS2zOkenooOsFPv1H-JNqoAuhNatiUGx"));
        classMaterials.add(new DataURL("Entity Relationship Model","https://drive.google.com/open?id=1nHDW2jRcZHBjC3li9iqQX0xxD4LaKM91"));
        classMaterials.add(new DataURL("Functional Dependency Basics","https://drive.google.com/open?id=1L3cZO_mnkg9ph7CzAVzlJV3vG37wpqSz"));
        classMaterials.add(new DataURL("Reduction of schema","https://drive.google.com/open?id=1AjruQmt7h_vcOLfn7ut3Ef6fAhiFJtBg"));
        classMaterials.add(new DataURL("Relational Algebra","https://drive.google.com/open?id=1y5l8lknGjn5BR1sOd0ZdkjA2V088UU7k"));
        classMaterials.add(new DataURL("SQL","https://drive.google.com/open?id=1EtoyOqSGhJNlcJFBSI4yom8Leyizko5h"));
        classMaterials.add(new DataURL("Transaction Control","https://drive.google.com/open?id=18VUjRpBWEbzVAznlrNlKXf7wb4l1hit2"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Database System Concepts 6th edition","https://drive.google.com/open?id=15SiK9iiVPG-qSso97gTumff1AXQVTPkr"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 19","https://drive.google.com/open?id=1BV6F8jTwgxN0tPJ9VO9esPN6lDYTQNNP"));
//        examPapers.add(new DataURL("EndSem 19"));


        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }

}
