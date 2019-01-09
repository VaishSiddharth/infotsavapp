package com.infotsav.test.Main_Activities;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.infotsav.test.MainMenuUtils.MainActivity;
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
                mContactus_detailslist.add(new Contactus_details("1","JUHI TIWARI","juhi@infotsav.in","Coordinator","9461155105","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_28_5023319710.gif?alt=media&token=dc7cf248-b04a-46fb-a59c-908347126cf8"));
                mContactus_detailslist.add(new Contactus_details("2","MUKUL SIKKA","mukul@infotsav.in","Coordinator","7470485414","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_26_7675552517.gif?alt=media&token=d12244bc-dce6-41dd-ab0f-990d4a513752"));
                mContactus_detailslist.add(new Contactus_details("3","PRATYUSH RANJAN","pratyush@infotsav.in","Coordinator","9598319698","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_18_7239106357.gif?alt=media&token=93e95a6e-1f92-47d1-a245-5c54c9a7b5f7"));
                mContactus_detailslist.add(new Contactus_details("4","SHUBHANKER SRIVASTAVA","shubhanker@infotsav.in","Coordinator","9454932137","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_55_9286984931.gif?alt=media&token=51dbaae1-e966-465e-bd81-1801380200ed"));
                mContactus_detailslist.add(new Contactus_details("20","ASIF MOHAMMED","asif@infotsav.in","Technical Head","9848994293","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_52_2855844639.gif?alt=media&token=5e12264a-f8ac-46a1-b2a0-1a89840af154"));
                mContactus_detailslist.add(new Contactus_details("21","NEHA SHARMA","neha@infotsav.in","Managerial Head","7722647747","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_59_3303772453.gif?alt=media&token=7be4f31e-929b-4627-beb3-cacec9dcf704"));
                mContactus_detailslist.add(new Contactus_details("5","ANKIT BANSAL","ankit@infotsav.in","EMT","9810705130","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_43_8535333223.gif?alt=media&token=6729262f-90ca-4f02-be52-81bbf12b920b"));
                mContactus_detailslist.add(new Contactus_details("6","AYUSHI RASTOGI","ayushi@infotsav.in","EMT","755519490","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_41_2055629182.gif?alt=media&token=e6a158d6-067f-4a84-b143-5e65a20ad4a8"));
                mContactus_detailslist.add(new Contactus_details("7","DEEPANKAR SINGH","deepankar@infotsav.in","EMT","744053579","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_32_7604271821.gif?alt=media&token=fc4dab04-eb88-40af-8274-b4368270c220"));
                mContactus_detailslist.add(new Contactus_details("8","JUHI PURSWANI","juhi@infotsav.in","EMT","7823666989","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_16_6628213714.gif?alt=media&token=6bee03a6-ff29-4727-a721-e95aa3f1973d"));
                mContactus_detailslist.add(new Contactus_details("9","PRAKHAR BANSAL","prakhar@infotsav.in","EMT","7351480777","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_39_3114977136.gif?alt=media&token=9febd456-517e-4fa7-bcbf-3ff3aecbf2fe"));
                mContactus_detailslist.add(new Contactus_details("10","SHUBHAM BHATTACHARYYA","shubham@infotsav.in","EMT","7507008911","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_50_6400638181.gif?alt=media&token=da59f3c8-a8ef-4d19-9d3d-796e10439bd2"));
                mContactus_detailslist.add(new Contactus_details("11","SWARUP PADHY","swarup@infotsav.in","EMT","9873626099","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_12_2909797217.gif?alt=media&token=8f363d64-deb8-401f-acbf-1fff0e0bb5f4"));
                mContactus_detailslist.add(new Contactus_details("12","VIVEK ALLADI","vivek@infotsav.in","EMT","8885260958","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_1_9496876329.gif?alt=media&token=8187804c-aec3-4a86-97de-fbd869026142"));
                mContactus_detailslist.add(new Contactus_details("13","DINESH VERRA","dinesh@infotsav.in","EMT","8179515709","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_30_2090489510.gif?alt=media&token=fa7a9951-6957-4b06-96ec-eee5cdab8a34"));
                mContactus_detailslist.add(new Contactus_details("14","NILAY GUPTA","nilay@infotsav.in","EMT","9044712480","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_24_3460571397.gif?alt=media&token=db384c6a-6283-4766-a806-0580a0d13b2d"));
                mContactus_detailslist.add(new Contactus_details("15","PALAK JAIN","palak@infotsav.in","EMT","7943486494","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_22_6417364399.gif?alt=media&token=bbcb1541-fe69-4c11-97f4-0be281d199a8"));
                mContactus_detailslist.add(new Contactus_details("16","POORVA KHANDARE","poorva@infotsav.in","EMT","7859535921","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_20_7603991370.gif?alt=media&token=49d21dcd-9db1-4198-85f8-c97aa617e3a0"));
                mContactus_detailslist.add(new Contactus_details("17","PRIYANSH GAHARANA","priyansh@infotsav.in","EMT","9452685369","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_45_4131785817.gif?alt=media&token=d34e6555-ac3d-49f8-95aa-685bea3d06a4"));
                mContactus_detailslist.add(new Contactus_details("18","TANMAY SHARMA","tanmay@infotsav.in","EMT","9549052975","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/vmal.jpg?alt=media&token=34eb3c9c-dc3c-441d-b524-15cf657635c8"));
                mContactus_detailslist.add(new Contactus_details("19","VISHESH KHANDELWAL","vishesh@infotsav.in","EMT","7678122119","https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_3_9372509889.gif?alt=media&token=488e50ef-7b66-44fe-8e6a-9c8b43e89404"));
            }
            if( getArguments().getInt(ARG_SECTION_NUMBER)==2) {
                mContactus_detailslist.add(new Contactus_details("5", "AVIHARSH SHUKLA", "sidvaish4@gmail.com", "Head App Developer", "8765114937", "https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_57_5881310723.gif?alt=media&token=e679bb0b-08aa-4a7f-8da7-9ee8eba7cbf3"));
                mContactus_detailslist.add(new Contactus_details("6", "SIDDHARTH VAISH", "sidvaish97@gmail.com", "Head App Developer", "9149386335", "https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_7_7898158568.gif?alt=media&token=da5bb680-411e-43ed-8627-104cdf9991c3"));
                mContactus_detailslist.add(new Contactus_details("7", "HIMADRI SINGH", "himsingh1612@gmail.com", "App Developer", "8449569368", "https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_61_9407681319.gif?alt=media&token=b6d18d34-3ec1-41e0-9481-b6321bc64279"));
                mContactus_detailslist.add(new Contactus_details("11", "SHUBHAM BHAWSAR", "bhawsarshubham741@gmail.com", "App Developer", "8878674076", "https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_14_2843577101.gif?alt=media&token=759c335a-3752-4c5e-8900-d705ad77b0a4"));
                mContactus_detailslist.add(new Contactus_details("8", "DEEPAK PALIWAL", "deepakkpaliwal@gmail.com", "App Developer", "8769449558", "https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_34_2360165048.gif?alt=media&token=ddd55b78-c500-4908-81d9-161cbbf5baeb"));
                mContactus_detailslist.add(new Contactus_details("9", "ABHISHEK CHAURASIA", "abhi.chaurasia14@gmail.com", "App Developer", "9919098817", "https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_37_7841767981.gif?alt=media&token=0fc84c06-f584-475a-81b7-2484398d3ddb"));
                mContactus_detailslist.add(new Contactus_details("10", "ADITYA SHANKAR MISHRA", "adityashankarmishra3@gmail.com", "App Developer", "9260970643", "https://firebasestorage.googleapis.com/v0/b/infotsavapp19.appspot.com/o/imageedit_47_6166486762.gif?alt=media&token=6b520c9d-6dbd-4ec5-a3fd-7d6d8cde9e80"));

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
