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
public class Developers extends Fragment {
    
    public Developers() {
        // Required empty public constructor
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayList<Contactus_details> mContactus_detailslist;
        View rootView = inflater.inflate(R.layout.fragment_tab_contact_us, container, false);
        ListView lvcontactus = (ListView) rootView.findViewById(R.id.listview_contactus);
        mContactus_detailslist = new ArrayList<>();
    
        mContactus_detailslist.add(new Contactus_details("5", "AVIHARSH SHUKLA", "aviharsh.186@gmail.com", "Head App Developer", "8765114937", R.drawable.aviharsh));
        mContactus_detailslist.add(new Contactus_details("6", "SIDDHARTH VAISH", "sidvaish97@gmail.com", "Head App Developer", "9149386335", R.drawable.sid));
        mContactus_detailslist.add(new Contactus_details("7", "HIMADRI SINGH", "himsingh1612@gmail.com", "App Developer", "8449569368", R.drawable.himadri));
        mContactus_detailslist.add(new Contactus_details("10", "ADITYA SHANKAR MISHRA", "adityashankarmishra3@gmail.com", "App Developer", "9260970643", R.drawable.adi));
        mContactus_detailslist.add(new Contactus_details("9", "ABHISHEK CHAURASIA", "abhi.chaurasia14@gmail.com", "App Developer", "9919098817", R.drawable.abhishek));
        mContactus_detailslist.add(new Contactus_details("8", "DEEPAK PALIWAL", "deepakkpaliwal@gmail.com", "App Developer", "8769449558", R.drawable.deepak));
        mContactus_detailslist.add(new Contactus_details("11", "SHUBHAM BHAWSAR", "bhawsarshubham741@gmail.com", "App Developer", "8878674076", R.drawable.shubh));
    
        ContactusAdapter adapter = new ContactusAdapter(getActivity(), mContactus_detailslist);
        lvcontactus.setAdapter(adapter);
        
        return rootView;
    }
    
}
