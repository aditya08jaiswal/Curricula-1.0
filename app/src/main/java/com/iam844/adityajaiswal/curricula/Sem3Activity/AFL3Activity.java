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

public class AFL3Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afl3);

        //Add AdMOb
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adView_activity_afl3);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_afl3);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Automata Formal Languages");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.afl3_listView);
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
        listDataHeader.add("Tutorials");

        //List
        List<DataURL> classMaterials = new ArrayList<>();
        classMaterials.add(new DataURL("Basic","https://drive.google.com/open?id=1LK0FeXTj0hZBwuU_GRudmJOqvRJJdbsz"));
        classMaterials.add(new DataURL("CFG Simplification","https://drive.google.com/open?id=1IgxFHEENY0AXQ82r16_ev2TgpJJjOgPj"));
        classMaterials.add(new DataURL("Introduction DFA NFA","https://drive.google.com/open?id=1tuoul00YSKtPCjrdD5AvHFKsTUsT9we_"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Automata Theory - Tutorials Point","https://drive.google.com/open?id=136-JSF-zayj7bR6xaIbed5F549Txmtvv"));
        books.add(new DataURL("Automata Theory, Languages and Computation","https://drive.google.com/open?id=1Poruin_0jA_axTqx8zjY6V5hnOzJCCVi"));
        books.add(new DataURL("Formal Languages and Automata Theory","https://drive.google.com/open?id=1rHvbFhwdX7HC0fAIAeNtyb4E-EzgkauM"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 18", "https://drive.google.com/open?id=14fCK2MQWNgf3AHERICnOLDHgmHGNgtBc"));
        examPapers.add(new DataURL("EndSem 18", "https://drive.google.com/open?id=1XMxUWSelYm1LPZWnYTuCj-D4Yh9sOZF7"));

        List<DataURL> tutorials = new ArrayList<>();
        tutorials.add(new DataURL("Mathematical Induction 18","https://drive.google.com/open?id=1c7QxwVoPdVb9xdTw1BsVV2FF4G48MYAE"));
        tutorials.add(new DataURL("Mathematical Induction and Method of Contradiction 18","https://drive.google.com/open?id=1Zvqysy2wFjEyJDOLZbe9YUOEfd8f1mt_"));
        tutorials.add(new DataURL("DFA 18","https://drive.google.com/open?id=1RgfoucU7d2MzmJ5vfcrH98jZAmmmkN2p"));
        tutorials.add(new DataURL("CFG 18","https://drive.google.com/open?id=1nk6OUWcLpmTBjZOPFqejwzJBMgK6o7nM"));
        tutorials.add(new DataURL("CFG Simplification 18","https://drive.google.com/open?id=1SOGDPyr3XYQKeP3j1Kumv6XKZohLyWDP"));
        tutorials.add(new DataURL("Regular Expression 18","https://drive.google.com/open?id=16v2vIvkL_4kyI7NXc3SWYt_B-NA3SU9o"));
        tutorials.add(new DataURL("Turing Machine 18","https://drive.google.com/open?id=1lNEBPAgWne5zJ5MQTzJuy5CUrTWftTyY"));
        tutorials.add(new DataURL("CNF and GNF 18","https://drive.google.com/open?id=1Thxz3JCMxh0OiWrcYUpMIePPyJUYfmIx"));
        tutorials.add(new DataURL("PDA 18","https://drive.google.com/open?id=15NYxVBjqLXoLukF0WqfKMFLI1Fq0QPyS"));


        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
        listHash.put(listDataHeader.get(3), tutorials);
    }
}
