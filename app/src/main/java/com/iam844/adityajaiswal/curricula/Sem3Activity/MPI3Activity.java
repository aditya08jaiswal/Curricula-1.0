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

public class MPI3Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpi3);

        //Add AdMOb
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adView_activity_mpi3);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_mpi3);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Microprocessor and Interfacing");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.mpi3_listView);
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
        classMaterials.add(new DataURL("8086 Microprocessor","https://drive.google.com/open?id=17YfWbvyZXXvkRjMAVxSVNqWWSxmblHhS"));
        classMaterials.add(new DataURL("8086 and Chips","https://drive.google.com/open?id=134J7cpEQ7CmCW3Rdi3-ovNdZUdfRd9FX"));
        classMaterials.add(new DataURL("8086 Programs","https://drive.google.com/open?id=1sex3F7TVGP-4rCceSXu2HuRmBMwsnszt"));
        classMaterials.add(new DataURL("DOS Interrupts i8086","https://drive.google.com/open?id=1i9D5i1Q9bh0xaKXjwURU6jETRArKVVWZ"));
        classMaterials.add(new DataURL("TASM tuto1","https://drive.google.com/open?id=1XJqa-JvkFtclcW_x58sDljlwhTT1sTKH"));
        classMaterials.add(new DataURL("TASM tuto2","https://drive.google.com/open?id=1j_7fP04wEW5eqYdeIP4GoOGBs0enYy6w"));
        classMaterials.add(new DataURL("TASM tuto3","https://drive.google.com/open?id=1DvnuHDMqkOSaipshrL0wV20YOX8m63dH"));
        classMaterials.add(new DataURL("8085 Microprocessor by Gaonkar","https://drive.google.com/open?id=1xLG8lsSAcoYDqEWH20-GedUyDlXHXQR3"));
        classMaterials.add(new DataURL("Microprocessor and Interfacing","https://drive.google.com/open?id=1DlLQSs4egmh-ZJjn0ATAxnAnuq49UJuA"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("8086 Instruction Set","https://drive.google.com/open?id=1kCDH2TdfMnRNpubL_n8oCwjH1EYMVZUL"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 18", "https://drive.google.com/open?id=1ErlRRAO3XN72dVg4aYBQqaHU8xWCFgAZ"));
        examPapers.add(new DataURL("EndSem 18", "https://drive.google.com/open?id=1fQZ7UQAP7aJ5bQcU5yWxBCXkmDgMYoqC"));

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }
}
