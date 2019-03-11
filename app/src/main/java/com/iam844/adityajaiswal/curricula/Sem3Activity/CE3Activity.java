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

public class CE3Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ce3);

        //Add AdMOb
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adView_activity_ce3);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_ce3);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Communication Engineering");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.ce3_listView);
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
//        listDataHeader.add("Class Materials");
        listDataHeader.add("Books");
        listDataHeader.add("Exam Papers");

        //List
//        List<DataURL> classMaterials = new ArrayList<>();
//        classMaterials.add(new DataURL("",""));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("BP Lathi","https://drive.google.com/open?id=1RaKFHkeNauks_eIyqrY1HP3BIvmwQm3o"));
        books.add(new DataURL("BP Lathi Solutions","https://drive.google.com/open?id=16riCMkmwOYcvE4PY8DN07ZdPTgjVxLSL"));
        books.add(new DataURL("Dennis Roddy - Electronic Communications","https://drive.google.com/open?id=1j7A_4gbprcQqP39NZYtpNnj1nX99T_f1"));
        books.add(new DataURL("Proakis","https://drive.google.com/open?id=1GpDzIl3yoDkkxkcz2ZWzYqsGjM5V-T7U"));
        books.add(new DataURL("Sanjay Sharma - AM","https://drive.google.com/open?id=1o-VQMfVP5fHqXtlPYQ8Yv7YqV0PS61fV"));
        books.add(new DataURL("Sanjay Sharma - Noise","https://drive.google.com/open?id=15BZ-2aNkG_vvl2gEfcn5nxfd9q0cRyTj"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 18", "https://drive.google.com/open?id=1SgsP8plCgUTp3oQxmegzd54imEEX_gOY"));
        examPapers.add(new DataURL("EndSem 18", "https://drive.google.com/open?id=1-iEUFja-e4Ht-rV1cOqjOGp10LqryRfw"));
        examPapers.add(new DataURL("EndSem Supplementary 18", "https://drive.google.com/open?id=1EDzctYuppqqs2cqTrUtMvPAbmPviNLis"));

//        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(0), books);
        listHash.put(listDataHeader.get(1), examPapers);
    }

}
