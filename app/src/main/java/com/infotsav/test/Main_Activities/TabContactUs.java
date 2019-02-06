package com.infotsav.test.Main_Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;

import com.infotsav.test.R;

import java.util.ArrayList;

public class TabContactUs extends AppCompatActivity {



    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_contact_us);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));





    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_tab_contact_us, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        ListView lvcontactus;
        ContactusAdapter adapter;
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            ArrayList<Contactus_details> mContactus_detailslist;
           // DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("contactus");
            View rootView = inflater.inflate(R.layout.fragment_tab_contact_us, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            lvcontactus=(ListView)rootView.findViewById(R.id.listview_contactus);
            mContactus_detailslist =new ArrayList<>();
            if( getArguments().getInt(ARG_SECTION_NUMBER)==1)
            {
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

            }
            if( getArguments().getInt(ARG_SECTION_NUMBER)==2) {
                mContactus_detailslist.add(new Contactus_details("5", "AVIHARSH SHUKLA", "aviharsh.186@gmail.com", "Head App Developer", "8765114937", R.drawable.aviharsh));
                mContactus_detailslist.add(new Contactus_details("6", "SIDDHARTH VAISH", "sidvaish97@gmail.com", "Head App Developer", "9149386335", R.drawable.sid));
                mContactus_detailslist.add(new Contactus_details("7", "HIMADRI SINGH", "himsingh1612@gmail.com", "App Developer", "8449569368", R.drawable.himadri));
                mContactus_detailslist.add(new Contactus_details("10", "ADITYA SHANKAR MISHRA", "adityashankarmishra3@gmail.com", "App Developer", "9260970643", R.drawable.adi));
                mContactus_detailslist.add(new Contactus_details("9", "ABHISHEK CHAURASIA", "abhi.chaurasia14@gmail.com", "App Developer", "9919098817", R.drawable.abhishek));
                mContactus_detailslist.add(new Contactus_details("8", "DEEPAK PALIWAL", "deepakkpaliwal@gmail.com", "App Developer", "8769449558", R.drawable.deepak));
                mContactus_detailslist.add(new Contactus_details("11", "SHUBHAM BHAWSAR", "bhawsarshubham741@gmail.com", "App Developer", "8878674076", R.drawable.shubh));

            }
            adapter= new ContactusAdapter( getActivity().getApplicationContext(), mContactus_detailslist);
            lvcontactus.setAdapter(adapter);
        /*lvcontactus.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Item clicked",Toast.LENGTH_LONG).show();
            }
        });*/

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }
    }
}
