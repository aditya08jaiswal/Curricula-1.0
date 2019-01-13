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

public class ECS1Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecs1);

        //Add AdMOb
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adView_activity_ecs1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_ecs1);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("English and Communication Skills");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.ecs1_listView);
        initData();
        listAdapter = new MaterialExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                if(listHash.get(listDataHeader.get(i)).get(i1).getmURL() == null ){
                    Toast.makeText(getApplicationContext(), "Kindly contact developer!", Toast.LENGTH_SHORT).show();
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
        listDataHeader.add("Exam Papers");

        //List
        List<DataURL> classMaterials = new ArrayList<>();
        classMaterials.add(new DataURL("Body Language - Handout", "https://drive.google.com/open?id=1WA4Ns_BSly4MGU_7ExLDCuKIXYZvLt5a"));
        classMaterials.add(new DataURL("Body Language", "https://drive.google.com/open?id=14aB1GCglIlOeWnjUW2IahSHCNQhhprRT"));
        classMaterials.add(new DataURL("Complaint Letter", "https://drive.google.com/open?id=1n6rZaEJsgxfgB-boOW91OC7q512jjZzX"));
        classMaterials.add(new DataURL("Cover Letter", "https://drive.google.com/open?id=12bZJQJUNGaLM4NIwRK3lgiEmJ_rJYrzm"));
        classMaterials.add(new DataURL("English Job Interview", "https://drive.google.com/open?id=1VWf2WMG7iJ6zj5HIZkLhwky7xl3YX2Lh"));
        classMaterials.add(new DataURL("Group Discussion Notes", "https://drive.google.com/open?id=12CVzhXmjJ9peou3uILDjeHwAKye0iZle"));
        classMaterials.add(new DataURL("Inquiry Letter", "https://drive.google.com/open?id=1LfNVMW2sJXMwehf2qKLWHOGAjEJLRDhq"));
        classMaterials.add(new DataURL("Interviews", "https://drive.google.com/open?id=1MYb4qhqKlxyU5XQsoreXVsTQB-Ptmrsv"));
        classMaterials.add(new DataURL("Job Inteview FAQs", "https://drive.google.com/open?id=12vsCM7v3fTyYHMGRZGFvWV-rA2GGrz1z"));
        classMaterials.add(new DataURL("Leave Application Letter", "https://drive.google.com/open?id=18-HWzytozS7QswJhq7Y0F3AHUd1LU237"));
        classMaterials.add(new DataURL("Letter Writing & Sample Questions", "https://drive.google.com/open?id=14z8vUhsd7H-Fj9DHeMCuHm6TziGLZPre"));
        classMaterials.add(new DataURL("Non Verbal Communiacation", "https://drive.google.com/open?id=1Dk1HmtR2SOilUzD6IkGyUheOp2B0ziiv"));
        classMaterials.add(new DataURL("Order Letter", "https://drive.google.com/open?id=1t4OleOIB7fpqPd6HMxFSCnc1avWqR8vA"));
        classMaterials.add(new DataURL("Presentation Skills Notes", "https://drive.google.com/open?id=1RptHVBQgkFKvZJTRGkqQ4gcjDCdXGbcv"));
        classMaterials.add(new DataURL("Report Writing", "https://drive.google.com/open?id=1cU0SMPxZLRPVlT3m9ORF_EYHbPR_eHw2"));
        classMaterials.add(new DataURL("Resume", "https://drive.google.com/open?id=1kmY0TeG_1OCSdBP8o2Ub3v5MNAciLb6K"));
        classMaterials.add(new DataURL("Sample CV", "https://drive.google.com/open?id=1Pid96teGzUOF1VT7FLl5T17utsndHj4Z"));
        classMaterials.add(new DataURL("Sample Report", "https://drive.google.com/open?id=1Afm9dXkz-16uXoMdarGRG_LdMM7gkZIr"));
        classMaterials.add(new DataURL("Seven C's of Communication", "https://drive.google.com/open?id=1_f-c9QSRu4zygI43pu3uZpYmf1dpfCGw"));
        classMaterials.add(new DataURL("SpeechWriting Notes", "https://drive.google.com/open?id=11MhZNQnRE39DZYhV6qBnZnRtwCThdSnJ"));
        classMaterials.add(new DataURL("Understanding NVC", "https://drive.google.com/open?id=17GCtV6z-d2TyM6ulrpSAAHyoyAkBnGOL"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 18", "https://drive.google.com/open?id=19Pnawe6J9sq7vxcXhHeN8n0XcA-9L6Sp"));
        examPapers.add(new DataURL("EndSem 18", "https://drive.google.com/open?id=1GDGczqSgJM8WIsqn8ZCLuE7Z80ACCPiL"));
        examPapers.add(new DataURL("MidSem 17", "https://drive.google.com/open?id=1oPJGzPD3yCTmqYe5l3vxGkA0UtF-Ok-6"));
        examPapers.add(new DataURL("EndSem 17", "https://drive.google.com/open?id=1ntlZZV75twL3EbG_cSp6gfw3qTlx-wMm"));

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), examPapers);
    }

}
