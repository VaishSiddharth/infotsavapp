package com.infotsav.test.foldingView;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.firebase.messaging.FirebaseMessaging;
import com.infotsav.test.Main_Activities.NotificationModActivity;
import com.infotsav.test.Main_Activities.TreasurehuntActivity;
import com.infotsav.test.R;
import com.ramotion.foldingcell.FoldingCell;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.infotsav.test.Util.Constants.back1;
import static com.infotsav.test.Util.Constants.back10;
import static com.infotsav.test.Util.Constants.back11;
import static com.infotsav.test.Util.Constants.back12;
import static com.infotsav.test.Util.Constants.back2;
import static com.infotsav.test.Util.Constants.back3;
import static com.infotsav.test.Util.Constants.back4;
import static com.infotsav.test.Util.Constants.back5;
import static com.infotsav.test.Util.Constants.back6;
import static com.infotsav.test.Util.Constants.back7;
import static com.infotsav.test.Util.Constants.back8;
import static com.infotsav.test.Util.Constants.back9;

/**
 * Simple example of ListAdapter for using with Folding Cell
 * Adapter holds indexes of unfolded elements for correct work with default reusable views behavior
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class FoldingCellListAdapter extends ArrayAdapter<Item> {
    
    private static final String TAG = FoldingCellListAdapter.class.getSimpleName();
    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;
    private View.OnClickListener contactEventHead;
    private List<Item> mitem;
    private int backgrounduri[]={back1,back2,back3,back4,back5,back6,back7,back8,back9,back10,back11,back12};
    private Context mContext;


    public FoldingCellListAdapter(Context context, List<Item> objects) {
        super(context, 0, objects);
        this.mContext=context;
    }
    // Implementing Fisher–Yates shuffle
    static int[] shuffleArray(int[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            rnd = ThreadLocalRandom.current();
        }
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = 0;
            if (rnd != null) {
                index = rnd.nextInt(i + 1);
            }
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // get item for selected view
        final Item item = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        final ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);
            AlphaAnimation anim1 = new AlphaAnimation(0.0f, 1.0f);
            anim1.setStartOffset(100);
            anim1.setDuration(1000);
            //anim1.setRepeatCount(10);
            //anim1.setRepeatMode(Animation.ZORDER_BOTTOM);
            cell.startAnimation(anim1);
            // binding view parts to view holder
            viewHolder.price = cell.findViewById(R.id.title_price);
            viewHolder.time = cell.findViewById(R.id.title_time_label);
            viewHolder.date = cell.findViewById(R.id.title_date_label);
            viewHolder.event_detail_short = cell.findViewById(R.id.event_detail_short);
            viewHolder.venue_event = cell.findViewById(R.id.venue_event);
            viewHolder.time_event = cell.findViewById(R.id.time_event);
            viewHolder.event_image = cell.findViewById(R.id.event_image);
            viewHolder.contentRequestBtn = cell.findViewById(R.id.content_request_btn);
            viewHolder.contact_button=cell.findViewById(R.id.contact_button);
            viewHolder.event_description_long=cell.findViewById(R.id.event_description_long);
            viewHolder.event_head_names=cell.findViewById(R.id.event_head_names);
            viewHolder.event_organizers_name=cell.findViewById(R.id.event_organizers_name);
            viewHolder.event_rules=cell.findViewById(R.id.event_rules);
            viewHolder.event_name=cell.findViewById(R.id.event_name);
            viewHolder.head_event_image=cell.findViewById(R.id.head_event_image);
            viewHolder.cardBackground = cell.findViewById(R.id.cardbackground);
            viewHolder.calander=cell.findViewById(R.id.calendarimage);
            viewHolder.location=cell.findViewById(R.id.locationimage);
            viewHolder.subscribe=cell.findViewById(R.id.notification);
            cell.setTag(viewHolder);
        } else {
            // for existing cell set valid valid state(without animation)
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }

        //mod apk for notifications
        /*viewHolder.event_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, NotificationModActivity.class);
                intent.putExtra("eventId", item.getEventId());
                intent.putExtra("eventname", item.getEvent_name());
                mContext.startActivity(intent);
            }
        });*/
        //subscribe button
        viewHolder.subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventId= item.getEventId();
                //debugging
                Log.e(TAG, "The id is "+ eventId);
                if(eventId!=null)
                {
                    FirebaseMessaging.getInstance().subscribeToTopic(eventId);
                    // TODO: Revisit later
                    Toast.makeText(mContext,"You will be notified about "+item.getEvent_name(),Toast.LENGTH_LONG).show();
                }
            }
        });

        if (null == item)
            return cell;

        //calander intent
            viewHolder.calander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(2019, 2, 8, 0, 0);
                Calendar endTime = Calendar.getInstance();
                //endTime.set(2012, 0, 19, 10, 30);
                calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
                //calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
                calendarIntent.putExtra(CalendarContract.Events.TITLE, item.getEvent_name());
                calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, item.getVenue_event());
                mContext.startActivity(calendarIntent);
            }
        });
        //map intent
            viewHolder.location.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri gmmIntentUri = Uri.parse("geo:26.2495,78.1740");
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    if (mapIntent.resolveActivity(mContext.getPackageManager()) != null) {
                        mContext.startActivity(mapIntent);
                    }
                }
            });

        // bind data from selected element to view through view holder
        viewHolder.price.setText(item.getPrice());
        viewHolder.time.setText(item.getTime());
        viewHolder.date.setText(item.getDate());
        viewHolder.event_detail_short.setText(item.getEvent_detail_short());
        viewHolder.venue_event.setText(item.getVenue_event());
        viewHolder.time_event.setText(item.getTime_event());
        //viewHolder.event_image.setImageResource(item.getEvent_image());


        //setting background
        //LinearLayout cardBackground=convertView.findViewById(R.id.cardbackground);

        int index = (position % backgrounduri.length)  ;
        if(index>11)
            index--;
       /* if(index%11==0)
            shuffleArray(backgrounduri);*/
        
      //  Log.e(TAG, "value of index is "+index);
        {
            Glide.with(getContext()).load(backgrounduri[index]).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        viewHolder.cardBackground.setBackground(resource);
                    }
                }
            });
        }

        /*String url = item.getEvent_image();
        if(url!=null) {
            Glide.with(getContext()).load(url).into(viewHolder.event_image);

        }*/
        viewHolder.event_description_long.setText(item.getEvent_description_long());
        viewHolder.event_head_names.setText(item.getEvent_head_names());
        viewHolder.event_organizers_name.setText(item.getEvent_organizers_name());
        viewHolder.event_rules.setText(item.getEvent_rules());
        viewHolder.event_name.setText(item.getEvent_name());
        //viewHolder.head_event_image.setImageResource(item.getHead_event_image());
        String url1 =item.getHead_event_image();
        int resID = mContext.getResources().getIdentifier(url1 , "drawable", mContext.getPackageName());
        viewHolder.head_event_image.setImageResource(resID);


        final String number = item.getPrice();

        viewHolder.contact_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });

        // set custom btn handler for list item from that item
        if (item.getRequestBtnClickListener() != null) {
            viewHolder.contentRequestBtn.setOnClickListener(item.getRequestBtnClickListener());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.contentRequestBtn.setOnClickListener(defaultRequestBtnClickListener);
        }

        return cell;
    }

    private int getRandomNumber() {

        return new Random().nextInt((11 - 0) + 1);
    }

    // simple methods for register cell state changes
    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    public View.OnClickListener getDefaultRequestBtnClickListener() {
        return defaultRequestBtnClickListener;
    }

    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView price;
        TextView contentRequestBtn;
        ImageView event_image;
        TextView event_detail_short;
        TextView venue_event;
        TextView time_event;
        TextView date;
        TextView time;
        TextView event_description_long;
        TextView event_head_names;
        TextView event_organizers_name;
        TextView event_rules;
        TextView event_name;
        ImageView head_event_image;
        LinearLayout cardBackground;
        TextView contact_button;
        ImageView calander;
        ImageView location;
        TextView subscribe;


    }
}
