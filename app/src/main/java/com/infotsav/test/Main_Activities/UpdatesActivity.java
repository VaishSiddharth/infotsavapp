package com.infotsav.test.Main_Activities;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.infotsav.test.R;

import java.util.ArrayList;
import java.util.List;

public class UpdatesActivity extends AppCompatActivity {

    private ListView lvupdates;
    private UpdatesAdapter adapter;
    private ArrayList<Updates_details> mUpdates_detailslist;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("updates");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updates);
        mUpdates_detailslist=new ArrayList<>();
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Updates_details updates_details=(Updates_details)dataSnapshot.getValue(Updates_details.class);
                mUpdates_detailslist.add(0,updates_details);
                if(adapter!=null)
                    adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                lvupdates=(ListView)findViewById(R.id.listview_updates);
                adapter=new UpdatesAdapter(getApplicationContext(), mUpdates_detailslist);
                lvupdates.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        /*mUpdates_detailslist.add(new Updates_details("1","ANNOUNCEMENT","13/12 7:00PM","The opening ceremony has begun.Reach Main Audi asap","R.drawable.restaurant"));
        mUpdates_detailslist.add(new Updates_details("2","ANNOUNCEMENT","13/12 7:00PM","The opening ceremony has begun.Reach Main Audi asap","R.drawable.restaurant"));
        mUpdates_detailslist.add(new Updates_details("3","ANNOUNCEMENT","13/12 7:00PM","The opening ceremony has begun.Reach Main Audi asap","R.drawable.restaurant"));
        mUpdates_detailslist.add(new Updates_details("4","ANNOUNCEMENT","13/12 7:00PM","The opening ceremony has begun.Reach Main Audi asap","R.drawable.restaurant"));

        adapter=new UpdatesAdapter(getApplicationContext(), mUpdates_detailslist);
        lvupdates.setAdapter(adapter);

        lvupdates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Item clicked",Toast.LENGTH_LONG).show();
            }
        });*/

    }
}
