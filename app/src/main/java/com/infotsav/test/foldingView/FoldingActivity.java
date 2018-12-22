package com.infotsav.test.foldingView;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
import com.infotsav.test.Main_Activities.Register_Activity;
import com.infotsav.test.R;
import com.ramotion.foldingcell.FoldingCell;


import java.util.ArrayList;

import static com.infotsav.test.Util.Constants.all;
import static com.infotsav.test.Util.Constants.gamiacs;
import static com.infotsav.test.Util.Constants.managerial;
import static com.infotsav.test.Util.Constants.online;
import static com.infotsav.test.Util.Constants.onsite;
import static com.infotsav.test.Util.Constants.robotics;
import static com.infotsav.test.Util.Constants.school;
import static com.infotsav.test.Util.Constants.technical;

/**
 * Example of using Folding Cell with ListView and ListAdapter
 */
public class FoldingActivity extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("event_details");
    private FoldingCellListAdapter adapter;
    ListView theListView;

    private ArrayList<Item> mItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folding);
        Bundle bundle = getIntent().getExtras();
        String child = bundle.getString("message");

        // get our list view
        theListView = findViewById(R.id.mainListView);

        // prepare elements to display
        final ArrayList<Item> items = Item.getTestingList();

        // add custom btn handler to first list item
        items.get(0).setRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "CUSTOM HANDLER FOR FIRST BUTTON", Toast.LENGTH_SHORT).show();
            }
        });

        // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)


        // add default btn handler for each request btn on each item if custom handler not found


        // set elements to adapter


        // set on click event listener to list view

        mItem=new ArrayList<>();
        if(child.equalsIgnoreCase(all))
            databaseReference=databaseReference.child(child);
        else if(child.equalsIgnoreCase(online))
            databaseReference=databaseReference.child(child);
        else if (child.equalsIgnoreCase(onsite))
            databaseReference=databaseReference.child(child);
        else if (child.equalsIgnoreCase(managerial))
            databaseReference=databaseReference.child(child);
        else if (child.equalsIgnoreCase(technical))
            databaseReference=databaseReference.child(child);
        else if (child.equalsIgnoreCase(school))
            databaseReference=databaseReference.child(child);
        else if (child.equalsIgnoreCase(gamiacs))
            databaseReference=databaseReference.child(child);
        else if (child.equalsIgnoreCase(robotics))
            databaseReference=databaseReference.child(child);
        else {}
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Item item=(Item) dataSnapshot.getValue(Item.class);
                mItem.add(item);

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
                adapter = new FoldingCellListAdapter(FoldingActivity.this, mItem);
                adapter.setDefaultRequestBtnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getApplicationContext(),Register_Activity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Please enter your details", Toast.LENGTH_LONG).show();
                    }
                });
                theListView.setAdapter(adapter);
                theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                        // toggle clicked cell state
                        ((FoldingCell) view).toggle(false);
                        // register in adapter that state for selected cell is toggled
                        adapter.registerToggle(pos);
                    }
                });


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
