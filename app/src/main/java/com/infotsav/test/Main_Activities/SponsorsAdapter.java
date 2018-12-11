package com.infotsav.test.Main_Activities;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.infotsav.test.R;

import java.util.List;

public class SponsorsAdapter extends BaseAdapter {

    private Context mContext;
    private List<Sponsors_details> mSponsors_detailslist;


    public SponsorsAdapter(Context mContext, List<Sponsors_details> mContactus_detailslist) {
        this.mContext = mContext;
        this.mSponsors_detailslist = mContactus_detailslist;
    }

    @Override
    public int getCount() {
        return mSponsors_detailslist.size();
    }

    @Override
    public Object getItem(int position) {
        return mSponsors_detailslist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(mContext,R.layout.sponsors_list,null);
        TextView person_name=(TextView)view.findViewById(R.id.person_name);
        TextView person_email=(TextView)view.findViewById(R.id.person_email);
        TextView person_department=(TextView)view.findViewById(R.id.person_department);

        AssetManager assetManager = mContext.getAssets();

        final Typeface tvFont = Typeface.createFromAsset(assetManager,  "fonts/Delius-Regular.ttf");
        person_name.setTypeface(tvFont);
        person_email.setTypeface(tvFont);
        person_department.setTypeface(tvFont);

        person_name.setTextColor(Color.BLACK);

        ImageView person_image=(ImageView)view.findViewById(R.id.person_photo);



        person_name.setText(mSponsors_detailslist.get(position).getName());
        person_email.setText(mSponsors_detailslist.get(position).getSponsorship1());
        person_department.setText(mSponsors_detailslist.get(position).getSponsorship2());
        person_image.setImageResource(mSponsors_detailslist.get(position).getImage());
        view.setTag(mSponsors_detailslist.get(position).getId());
        return view;
    }
}