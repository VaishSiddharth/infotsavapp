package com.infotsav.test.Main_Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.infotsav.test.R;

import java.util.ArrayList;
import java.util.List;

public class SponsorsActivity extends AppCompatActivity {

    private ListView lvsponsors;
    private SponsorsAdapter adapter;
    private List<Sponsors_details> mSponsors_detailslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);

        lvsponsors=(ListView)findViewById(R.id.listview_sponsors);
        mSponsors_detailslist =new ArrayList<>();
        mSponsors_detailslist.add(new Sponsors_details("1","BANK OF INDIA","Co-Sponsor","EDM Night",R.drawable.boi));
        mSponsors_detailslist.add(new Sponsors_details("2","THE TIMES OF INDIA","Co-Sponsor","EDM Night",R.drawable.timeofindia));
        mSponsors_detailslist.add(new Sponsors_details("3","PUNJAB NATIONAL BANK","Co-Sponsor","EDM Night",R.drawable.punjab_national_banksvg));
        mSponsors_detailslist.add(new Sponsors_details("4","J K TYRES","Co-Sponsor","EDM Night",R.drawable.jk_tyre_logo));
        mSponsors_detailslist.add(new Sponsors_details("5","OYO","Co-Sponsor","EDM Night",R.drawable.oyo));

        mSponsors_detailslist.add(new Sponsors_details("6","HACKEREARTH","Co-Sponsor","EDM Night",R.drawable.hackerearthlogo));
        mSponsors_detailslist.add(new Sponsors_details("7","HACKSOCIETY","Co-Sponsor","EDM Night",R.drawable.haacksociety));
        mSponsors_detailslist.add(new Sponsors_details("8","HACKERRANK","Co-Sponsor","EDM Night",R.drawable.hackerrankmin));
        mSponsors_detailslist.add(new Sponsors_details("9","INTERNSHALA","Co-Sponsor","EDM Night",R.drawable.internshala_logo));
        mSponsors_detailslist.add(new Sponsors_details("10","ZEBRONICS","Co-Sponsor","EDM Night",R.drawable.zebronics));

        mSponsors_detailslist.add(new Sponsors_details("11","ASHOK RADIO PARTS","Co-Sponsor","EDM Night",R.drawable.arp));
        mSponsors_detailslist.add(new Sponsors_details("12","BRAIN BUXA","Co-Sponsor","EDM Night",R.drawable.brainbuxa));
        mSponsors_detailslist.add(new Sponsors_details("13","CAREER LAUNCHER","Co-Sponsor","EDM Night",R.drawable.career_launcher));
        mSponsors_detailslist.add(new Sponsors_details("14","CODE MONK","Co-Sponsor","EDM Night",R.drawable.codemonk));
        mSponsors_detailslist.add(new Sponsors_details("15","COLLEGE KHABAR","Co-Sponsor","EDM Night",R.drawable.collegekhabar));

        mSponsors_detailslist.add(new Sponsors_details("16","FAB HOTELS","Co-Sponsor","EDM Night",R.drawable.fabhotels));
        mSponsors_detailslist.add(new Sponsors_details("17","GEEKS SHASTRA","Co-Sponsor","EDM Night",R.drawable.geekshastra));
        mSponsors_detailslist.add(new Sponsors_details("18","HOOK TO EVENTS","Co-Sponsor","EDM Night",R.drawable.hook2event));
        mSponsors_detailslist.add(new Sponsors_details("19","INNOBUZZ","Co-Sponsor","EDM Night",R.drawable.innobuzz_logo));
        mSponsors_detailslist.add(new Sponsors_details("20","KNOW A FEST","Co-Sponsor","EDM Night",R.drawable.knowafest_logo));

        mSponsors_detailslist.add(new Sponsors_details("21","WILEY","Co-Sponsor","EDM Night",R.drawable.wiley_x_logo));

        adapter=new SponsorsAdapter(getApplicationContext(), mSponsors_detailslist);
        lvsponsors.setAdapter(adapter);

        lvsponsors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),"Item clicked",Toast.LENGTH_LONG).show();
            }
        });

    }
}
