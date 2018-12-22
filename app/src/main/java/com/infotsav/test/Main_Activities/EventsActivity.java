package com.infotsav.test.Main_Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.infotsav.test.R;
import com.infotsav.test.foldingView.FoldingActivity;

public class EventsActivity extends AppCompatActivity {
    String str;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        //TODO: Read the firebase docs for realtime database or firestore (which ever you prefer)
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    public void launchFoldingActivityAll(View view) {
        str = "all";
        Intent intent = new Intent(this, FoldingActivity.class);
        intent.putExtra("message",str);
        startActivity(intent);
    }
    public void launchFoldingActivityGamiacs(View view) {
        str = "gamiacs";
        Intent intent = new Intent(this, FoldingActivity.class);
        intent.putExtra("message",str);
        startActivity(intent);
    }
    public void launchFoldingActivityManagerial(View view) {
        str = "managerial";
        Intent intent = new Intent(this, FoldingActivity.class);
        intent.putExtra("message",str);
        startActivity(intent);
    }
    public void launchFoldingActivityOnline(View view) {
        str = "online";
        Intent intent = new Intent(this, FoldingActivity.class);
        intent.putExtra("message",str);
        startActivity(intent);
    }
    public void launchFoldingActivityOnsite(View view) {
        str = "onsite";
        Intent intent = new Intent(this, FoldingActivity.class);
        intent.putExtra("message",str);
        startActivity(intent);
    }
    public void launchFoldingActivityRobotics(View view) {
        str = "robotics";
        Intent intent = new Intent(this, FoldingActivity.class);
        intent.putExtra("message",str);
        startActivity(intent);
    }
    public void launchFoldingActivityTechnical(View view) {
        str = "technical";
        Intent intent = new Intent(this, FoldingActivity.class);
        intent.putExtra("message",str);
        startActivity(intent);
    }
    public void launchFoldingActivitySchool(View view) {
        str = "school";
        Intent intent = new Intent(this, FoldingActivity.class);
        intent.putExtra("message",str);
        startActivity(intent);
    }
}
