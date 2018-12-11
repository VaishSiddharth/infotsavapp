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
        mSponsors_detailslist.add(new Sponsors_details(1,"THE MAANSINGH","Co-Sponsor","EDM Night",R.drawable.restaurant));
        mSponsors_detailslist.add(new Sponsors_details(1,"Bellevue","Co-Sponsor","RoboFiesta",R.drawable.restaurant));
        mSponsors_detailslist.add(new Sponsors_details(1,"Cafe Wrappico","Co-Sponsor","EDM Night",R.drawable.restaurant));
        mSponsors_detailslist.add(new Sponsors_details(1,"THE MAANSINGH","Co-Sponsor","EDM Night",R.drawable.restaurant));
        mSponsors_detailslist.add(new Sponsors_details(1,"THE MAANSINGH","Co-Sponsor","EDM Night",R.drawable.restaurant));

        adapter=new SponsorsAdapter(getApplicationContext(), mSponsors_detailslist);
        lvsponsors.setAdapter(adapter);

        lvsponsors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Item clicked",Toast.LENGTH_LONG).show();
            }
        });

    }
}
