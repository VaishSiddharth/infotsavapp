package com.infotsav.test.foldingView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.infotsav.test.R;
import com.ramotion.foldingcell.FoldingCell;

import java.util.HashSet;
import java.util.List;

/**
 * Simple example of ListAdapter for using with Folding Cell
 * Adapter holds indexes of unfolded elements for correct work with default reusable views behavior
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class FoldingCellListAdapter extends ArrayAdapter<Item> {

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;
    private List<Item> mitem;

    public FoldingCellListAdapter(Context context, List<Item> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // get item for selected view
        Item item = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);
            // binding view parts to view holder
            viewHolder.price = cell.findViewById(R.id.title_price);
            viewHolder.time = cell.findViewById(R.id.title_time_label);
            viewHolder.date = cell.findViewById(R.id.title_date_label);
            viewHolder.event_detail_short = cell.findViewById(R.id.event_detail_short);
            viewHolder.venue_event = cell.findViewById(R.id.venue_event);
            viewHolder.time_event = cell.findViewById(R.id.time_event);
            viewHolder.event_image = cell.findViewById(R.id.event_image);
            viewHolder.contentRequestBtn = cell.findViewById(R.id.content_request_btn);
            viewHolder.event_description_long=cell.findViewById(R.id.event_description_long);
            viewHolder.event_head_names=cell.findViewById(R.id.event_head_names);
            viewHolder.event_organizers_name=cell.findViewById(R.id.event_organizers_name);
            viewHolder.event_rules=cell.findViewById(R.id.event_rules);
            viewHolder.event_name=cell.findViewById(R.id.event_name);
            viewHolder.head_event_image=cell.findViewById(R.id.head_event_image);
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

        if (null == item)
            return cell;

        // bind data from selected element to view through view holder
        viewHolder.price.setText(item.getPrice());
        viewHolder.time.setText(item.getTime());
        viewHolder.date.setText(item.getDate());
        viewHolder.event_detail_short.setText(item.getEvent_detail_short());
        viewHolder.venue_event.setText(item.getVenue_event());
        viewHolder.time_event.setText(item.getTime_event());
        //viewHolder.event_image.setImageResource(item.getEvent_image());
        String url = item.getEvent_image();
        if(url!=null) {
            Glide.with(getContext()).load(url).into(viewHolder.event_image);

        }
        viewHolder.event_description_long.setText(item.getEvent_description_long());
        viewHolder.event_head_names.setText(item.getEvent_head_names());
        viewHolder.event_organizers_name.setText(item.getEvent_organizers_name());
        viewHolder.event_rules.setText(item.getEvent_rules());
        viewHolder.event_name.setText(item.getEvent_name());
        //viewHolder.head_event_image.setImageResource(item.getHead_event_image());
        String url1 =item.getHead_event_image();
        if(url1!=null) {
            Glide.with(getContext()).load(url1).into(viewHolder.head_event_image);

        }

        // set custom btn handler for list item from that item
        if (item.getRequestBtnClickListener() != null) {
            viewHolder.contentRequestBtn.setOnClickListener(item.getRequestBtnClickListener());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.contentRequestBtn.setOnClickListener(defaultRequestBtnClickListener);
        }

        return cell;
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

    }
}
