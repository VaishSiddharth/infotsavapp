package com.infotsav.test.Main_Activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.infotsav.test.R;

import java.util.List;

public class ContactusAdapter extends BaseAdapter {

    private Context mContext;
    private List<Contactus_details> mContactus_detailslist;


    public ContactusAdapter(Context mContext, List<Contactus_details> mContactus_detailslist) {
        this.mContext = mContext;
        this.mContactus_detailslist = mContactus_detailslist;
    }

    @Override
    public int getCount() {
        return mContactus_detailslist.size();
    }

    @Override
    public Object getItem(int position) {
        return mContactus_detailslist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(mContext,R.layout.contactus_list,null);
        TextView person_name=(TextView)view.findViewById(R.id.person_name);

        TextView person_email=(TextView)view.findViewById(R.id.person_email);


        TextView person_department=(TextView)view.findViewById(R.id.person_department);

        ImageView person_call=(ImageView) view.findViewById(R.id.call_person_button);
        ImageView person_image=(ImageView)view.findViewById(R.id.person_image);

        String url = mContactus_detailslist.get(position).getImage();
        if(url!=null) {
            Glide.with(mContext).load(url).into(person_image);

        }
        person_name.setText(mContactus_detailslist.get(position).getName());
        person_email.setText(mContactus_detailslist.get(position).getEmail());
        person_department.setText(mContactus_detailslist.get(position).getDept());
        final String number =mContactus_detailslist.get(position).getCall();

        person_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });

        person_call.setImageResource(R.drawable.callbutton);
        //person_image.setImageResource(mContactus_detailslist.get(position).getImage());
        view.setTag(mContactus_detailslist.get(position).getId());
        return view;
    }
}
