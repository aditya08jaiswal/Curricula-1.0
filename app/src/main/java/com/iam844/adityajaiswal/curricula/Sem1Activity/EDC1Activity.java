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

public class EDC1Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edc1);

        //Add AdMOb
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adView_activity_edc1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_edc1);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Electronic Devices and Circuits");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.edc1_listView);
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
        classMaterials.add(new DataURL("BJT Notes", "https://drive.google.com/open?id=13oN1PnrLvJj8yeyLfu-CpBBW2CIfn31w"));
        classMaterials.add(new DataURL("Clipper and Clamper", "https://drive.google.com/open?id=1dGxe_Oz-FFKI-Tpo8k519UVrVW-m3HIA"));
        classMaterials.add(new DataURL("Diodes", "https://drive.google.com/open?id=1Ycc8angcj8pk0g5BKxd79jd5IIIOXqeW"));
        classMaterials.add(new DataURL("Field Effect Transistors", "https://drive.google.com/open?id=1J9tOa4QYU1YS1Lc1Ys9zicwZMEtOrszy"));
        classMaterials.add(new DataURL("LCD Varactor", "https://drive.google.com/open?id=1FwZFLFa0XW01fG1gt_qH4yvGntX0jxW7"));
        classMaterials.add(new DataURL("LED and Photo Diode", "https://drive.google.com/open?id=1ZnvNZIXHrVHmjrzYasIRCt94FBWHKZr7"));
        classMaterials.add(new DataURL("LED, 7 Segment LED, Multicolour LED and LCD", "https://drive.google.com/open?id=179_yQjbaBtoHZ2XVaJ3ArolfF1zaP4q_"));
        classMaterials.add(new DataURL("Measuring Instruments - PNP", "https://drive.google.com/open?id=1UUizv8mXqEGpLRnz2it16DoBsBwvzEQ2"));
        classMaterials.add(new DataURL("Measuring Instruments", "https://drive.google.com/open?id=1mO02-cdskeOmiBWN3TqfDWCava8C-gE-"));
        classMaterials.add(new DataURL("OpAmp", "https://drive.google.com/open?id=1p20nA_AfShK_NxX9yQDLnvJAnY_T6kNA"));
        classMaterials.add(new DataURL("Photodiode", "https://drive.google.com/open?id=1AJ5-sl9T5P0I4NWocKohNh11PEGd_XMm"));
        classMaterials.add(new DataURL("Schottky and Shockley Diode", "https://drive.google.com/open?id=1iZLRovmsh5XnUJZo1RVFdn54jdWIeAMb"));
        classMaterials.add(new DataURL("Shockley Pin Diode", "https://drive.google.com/open?id=1Cegf13DR-ZKPWPaVQ63RKbec_OWsf4_2"));
        classMaterials.add(new DataURL("Special Purpose Diodes Notes", "https://drive.google.com/open?id=1G3nobEyalk55Yd5mD24Q0DitAzKjU07H"));
        classMaterials.add(new DataURL("Varactor Diode", "https://drive.google.com/open?id=16DWOwyj9nZc8F2D44Puw2xDLMpnxfB3-"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Anand Kumar - Clippers", "https://drive.google.com/open?id=1UewjUDn8kUBE_wwTOZPc12r2HCMh1T94"));
        books.add(new DataURL("Electronic Devices and Circuit Theory - Boylestad", "https://drive.google.com/open?id=1b0MeLhDHV0zC5SC4fap_8QT8ZabRrOzc"));
        books.add(new DataURL("Fundamentals of Electric Circuits", "https://drive.google.com/open?id=19KHw7ju2FkAlxRolaus5dgRLBnwld71C"));
        books.add(new DataURL("Measuring Instruments", "https://drive.google.com/open?id=1yLMBbRszowI0_a2VNlFGDjiw5AOi1vLI"));
        books.add(new DataURL("V.K. Mehta", "https://drive.google.com/open?id=1kFs-2eKTIJjK4lGfuRmQzYjE32cCMKdS"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 18", "https://drive.google.com/open?id=1qOjxfuSKmM2OPa1Xcpnpftq5uURvz3iQ"));
        examPapers.add(new DataURL("EndSem 18", "https://drive.google.com/open?id=1fSjofiOjnW-E2hM1s68LLgKHalF2UtvI"));
        examPapers.add(new DataURL("MidSem 17", "https://drive.google.com/open?id=1GmEulq5KkJsB9zvrXzjSMf84NCHHqCFB"));
        examPapers.add(new DataURL("EndSem 17", "https://drive.google.com/open?id=1qIzZjhOOcis2KtttGyzT6VawkkECS2f9"));

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }

}
