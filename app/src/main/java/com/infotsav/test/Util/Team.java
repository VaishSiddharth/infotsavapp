package com.infotsav.test.Util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.infotsav.test.Main_Activities.ContactusAdapter;
import com.infotsav.test.Main_Activities.Contactus_details;
import com.infotsav.test.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Team extends Fragment {
    
    public Team() {
        // Required empty public constructor
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    
        ArrayList<Contactus_details> mContactus_detailslist;
        // DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("contactus");
        View rootView = inflater.inflate(R.layout.fragment_tab_contact_us, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
       ListView lvcontactus=(ListView)rootView.findViewById(R.id.listview_contactus);
        mContactus_detailslist =new ArrayList<>();
       
            mContactus_detailslist.add(new Contactus_details("1","JUHI TIWARI","juhi@infotsav.in","Coordinator","9461155105",R.drawable.jjuhi));
            mContactus_detailslist.add(new Contactus_details("2","MUKUL SIKKA","mukul@infotsav.in","Coordinator","7470485414",R.drawable.sikka));
            mContactus_detailslist.add(new Contactus_details("3","PRATYUSH RANJAN","pratyush@infotsav.in","Coordinator","9598319698",R.drawable.pratyush));
            mContactus_detailslist.add(new Contactus_details("4","SHUBHANKER SRIVASTAVA","shubhanker@infotsav.in","Coordinator","9454932137",R.drawable.shubhanker));
            mContactus_detailslist.add(new Contactus_details("5","ANKIT BANSAL","ankit@infotsav.in","EMT","9810705130",R.drawable.ankit));
            mContactus_detailslist.add(new Contactus_details("6","AYUSHI RASTOGI","ayushi@infotsav.in","EMT","755519490",R.drawable.aayushi));
            mContactus_detailslist.add(new Contactus_details("7","DEEPANKAR SINGH","deepankar@infotsav.in","EMT","744053579",R.drawable.deep));
            mContactus_detailslist.add(new Contactus_details("8","JUHI PURSWANI","juhi@infotsav.in","EMT","7823666989",R.drawable.purush));
            mContactus_detailslist.add(new Contactus_details("9","PRAKHAR BANSAL","prakhar@infotsav.in","EMT","7351480777",R.drawable.prakhar));
            mContactus_detailslist.add(new Contactus_details("10","SHUBHAM BHATTACHARYYA","shubham@infotsav.in","EMT","7507008911",R.drawable.tutu));
            mContactus_detailslist.add(new Contactus_details("11","SWARUP PADHY","swarup@infotsav.in","EMT","9873626099",R.drawable.swaroop));
            mContactus_detailslist.add(new Contactus_details("12","VIVEK ALLADI","vivek@infotsav.in","EMT","8885260958",R.drawable.vivek));
            mContactus_detailslist.add(new Contactus_details("13","DINESH VERRA","dinesh@infotsav.in","EMT","8179515709",R.drawable.verra));
            mContactus_detailslist.add(new Contactus_details("14","NILAY GUPTA","nilay@infotsav.in","EMT","9044712480",R.drawable.nilay));
            mContactus_detailslist.add(new Contactus_details("15","PALAK JAIN","palak@infotsav.in","EMT","7943486494",R.drawable.palak));
            mContactus_detailslist.add(new Contactus_details("16","POORVA KHANDARE","poorva@infotsav.in","EMT","7859535921",R.drawable.poorva));
            mContactus_detailslist.add(new Contactus_details("17","PRIYANSH GAHARANA","priyansh@infotsav.in","EMT","9452685369",R.drawable.alpha));
            mContactus_detailslist.add(new Contactus_details("18","TANMAY SHARMA","tanmay@infotsav.in","EMT","9549052975",R.drawable.tanmay));
            mContactus_detailslist.add(new Contactus_details("19","VISHESH KHANDELWAL","vishesh@infotsav.in","EMT","7678122119",R.drawable.vishesh));
            mContactus_detailslist.add(new Contactus_details("20","ASIF MOHAMMED","asif@infotsav.in","Technical Head","9848994293",R.drawable.asif));
            mContactus_detailslist.add(new Contactus_details("21","NEHA SHARMA","neha@infotsav.in","Managerial Head","7722647747",R.drawable.neha));
            
       
        ContactusAdapter adapter= new ContactusAdapter( getActivity(), mContactus_detailslist);
        lvcontactus.setAdapter(adapter);
       
        return rootView;
    }
    
}
