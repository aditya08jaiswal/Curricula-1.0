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

public class FCP1Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fcp1);

        //Add AdMOb
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adView_activity_fcp1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_fcp1);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("FCP");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.fcp1_listView);
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
        classMaterials.add(new DataURL("Introduction to Programming", "https://drive.google.com/open?id=1O8YuGIATCA8Ytv5BrUCmyJ7nmubJgdh0"));
        classMaterials.add(new DataURL("Operators and Expressions", "https://drive.google.com/open?id=1XG3sT6tJcNy6Cn1SQgX0NzfSG0qJMUbs"));
        classMaterials.add(new DataURL("Decision Making and Branching", "https://drive.google.com/open?id=1dyl3T9MqiCCpR1HwC6s7BqaTf4E7GBKb"));
        classMaterials.add(new DataURL("Decision Making and Looping", "https://drive.google.com/open?id=1ec5SVO-OiRSOI10sVO3MYMw3ezmC1CXi"));
        classMaterials.add(new DataURL("Arrays", "https://drive.google.com/open?id=1X8OIABMlcmLAycfQ169mS9UWI8h2vMXS"));
        classMaterials.add(new DataURL("Strings", "https://drive.google.com/open?id=1_V9Iw7D7plAML-k5i4gV2qYp9uwUPUi9"));
        classMaterials.add(new DataURL("Functions", "https://drive.google.com/open?id=1jm8ocCLhU4-tt95Gn5Y9LEJj0Y_PuTXQ"));
        classMaterials.add(new DataURL("Structures and Unions", "https://drive.google.com/open?id=1UghL5-rpZYvs1SLHeVZvyCAOA8u_4LUM"));
        classMaterials.add(new DataURL("Pointers", "https://drive.google.com/open?id=1a_SNoFw-BEfT7e5ssNZgvHr3ucBWslmz"));
        classMaterials.add(new DataURL("Intro to Computer and It's Architecture", "https://drive.google.com/open?id=1_38-QdNl6byeRXguJvYGQQc5ztFGru6p"));
        classMaterials.add(new DataURL("Number System", "https://drive.google.com/open?id=1kVmxSpaPrhg00I_SkQuiCmHuUTz9zZvE"));
        classMaterials.add(new DataURL("Computer Architecture", "https://drive.google.com/open?id=10rm8c_2Hd2larr6mz3Ipe422yl00bVTH"));
        classMaterials.add(new DataURL("Memory", "https://drive.google.com/open?id=1IkpbOZ2nNW--Zz4MnGxJNQ_yIfVRm0nk"));
        classMaterials.add(new DataURL("Computer Languages", "https://drive.google.com/open?id=1EVj3MqkRmKsWqXgCApIXDYIoODlDmNyE"));
        classMaterials.add(new DataURL("Computer Program", "https://drive.google.com/open?id=1OB8yjORAuo5gWAgH17taE3f7MoAAcFc1"));
        classMaterials.add(new DataURL("Computer Networks", "https://drive.google.com/open?id=1LVdV9JhgvVxtVcU2yEXW4K630t7CeciS"));
        classMaterials.add(new DataURL("Operating System", "https://drive.google.com/open?id=1x2DlYpM9qHlpb1wSSy7SE_Cq4ZMOHalJ"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("ANSI C", "https://drive.google.com/open?id=1PkqKfiePvcw24dzlVHc4C5KK2NzSO4t4"));
        books.add(new DataURL("Balaguru - Solutions", "https://drive.google.com/open?id=14fnzILEM71nzefv09EaGXrlev3BdN1x2"));
        books.add(new DataURL("Programming in C", "https://drive.google.com/open?id=1Ic27Thon8ExiQd8M_MBxYbin4cACzceu"));
        books.add(new DataURL("Programming with C - Byron Gottfried", "https://drive.google.com/open?id=1pdwRGz84dbaaoXukM2V3gps1aoe9dEUk"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 18", "https://drive.google.com/open?id=1His7PTaSuBt_LQi3w833XqD3Qy-gM2pF"));
        examPapers.add(new DataURL("EndSem 18", "https://drive.google.com/open?id=1DsW8JCfxWwdmOyN6BM4U5FUZf5YNE-Cn"));
        examPapers.add(new DataURL("MidSem 17", "https://drive.google.com/open?id=1QVH3L0tuWwy7o76Jmp7nJdJdTQLhCll5"));
        examPapers.add(new DataURL("EndSem 17", "https://drive.google.com/open?id=1Vmsj0rQcT7_y3IhxG5FVxJA2b_DNJTRV"));

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }

}
