package com.infotsav.test.Main_Activities;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class ContactusActivity extends AppCompatActivity {

    private ListView lvcontactus;
    private ContactusAdapter adapter;
    private ArrayList<Contactus_details> mContactus_detailslist;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("contactus");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_contact_us);

        lvcontactus=(ListView)findViewById(R.id.listview_contactus);
        mContactus_detailslist =new ArrayList<>();
        mContactus_detailslist.add(new Contactus_details("1","JUHI TIWARI","juhi@infotsav.in","Coordinator","9461155105","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/aaron_bradley.png?alt=media&token=b3ecaad8-fda1-45d2-9d42-059eecad3834"));
        mContactus_detailslist.add(new Contactus_details("2","MUKUL SIKKA","mukul@infotsav.in","Coordinator","7470485414","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/aaron_bradley.png?alt=media&token=b3ecaad8-fda1-45d2-9d42-059eecad3834"));
        mContactus_detailslist.add(new Contactus_details("3","PRATYUSH RANJAN","pratyush@infotsav.in","Coordinator","9598319698","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/aaron_bradley.png?alt=media&token=b3ecaad8-fda1-45d2-9d42-059eecad3834"));
        mContactus_detailslist.add(new Contactus_details("4","SHUBHANKER SRIVASTAVA","shubhanker@infotsav.in","Coordinator","9454932137","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/aaron_bradley.png?alt=media&token=b3ecaad8-fda1-45d2-9d42-059eecad3834"));
        mContactus_detailslist.add(new Contactus_details("5","AVIHARSH SHUKLA","sidvaish4@gmail.com","Head App Developer","8765114937","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/aaron_bradley.png?alt=media&token=b3ecaad8-fda1-45d2-9d42-059eecad3834"));
        mContactus_detailslist.add(new Contactus_details("6","SIDDHARTH VAISH","sidvaish97@gmail.com","Head App Developer","9149386335","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/aaron_bradley.png?alt=media&token=b3ecaad8-fda1-45d2-9d42-059eecad3834"));
        mContactus_detailslist.add(new Contactus_details("7","HIMADRI SINGH","himsingh1612@gmail.com","App Developer","8449569368","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/aaron_bradley.png?alt=media&token=b3ecaad8-fda1-45d2-9d42-059eecad3834"));
        mContactus_detailslist.add(new Contactus_details("8","DEEPAK PALIWAL","deepakkpaliwal@gmail.com","App Developer","8769449558","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/aaron_bradley.png?alt=media&token=b3ecaad8-fda1-45d2-9d42-059eecad3834"));
        mContactus_detailslist.add(new Contactus_details("9","ABHISHEK CHAURASIA","abhi.chaurasia14@gmail.com","App Developer","9919098817","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/aaron_bradley.png?alt=media&token=b3ecaad8-fda1-45d2-9d42-059eecad3834"));
        mContactus_detailslist.add(new Contactus_details("10","ADITYA SHANKAR MISHRA","adityashankarmishra3@gmail.com","App Developer","9260970643","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/aaron_bradley.png?alt=media&token=b3ecaad8-fda1-45d2-9d42-059eecad3834"));
        mContactus_detailslist.add(new Contactus_details("11","SHUBHAM BHAWSAR","bhawsarshubham741@gmail.com","App Developer","8878674076","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/aaron_bradley.png?alt=media&token=b3ecaad8-fda1-45d2-9d42-059eecad3834"));
        adapter=new ContactusAdapter(getApplicationContext(), mContactus_detailslist);
        lvcontactus.setAdapter(adapter);
        /*lvcontactus.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Item clicked",Toast.LENGTH_LONG).show();
            }
        });*/

    }
}