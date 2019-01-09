package com.infotsav.test.foldingView;

import android.view.View;

import com.infotsav.test.R;

import java.util.ArrayList;

/**
 * Simple POJO model for example
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Item {

    private String price;
    private String event_image;
    private String event_detail_short;
    private String venue_event;
    private String time_event;
    private String date;
    private String time;
    private String event_description_long;
    private String event_head_names;
    private String event_organizers_name;
    private String event_rules;
    private String event_name;
    private String head_event_image;
    private String eventId;

    private View.OnClickListener requestBtnClickListener;

    public Item() {
    }

    public Item(String price, String event_image, String event_detail_short, String venue_event, String time_event, String date, String time, String event_description_long,String event_head_names, String event_organizers_name, String event_rules,String event_name,String head_event_image,String eventId) {
        this.price = price;
        this.event_image = event_image;
        this.event_detail_short = event_detail_short;
        this.venue_event = venue_event;
        this.time_event = time_event;
        this.date = date;
        this.time = time;
        this.event_description_long=event_description_long;
        this.event_head_names=event_head_names;
        this.event_organizers_name=event_organizers_name;
        this.event_rules=event_rules;
        this.event_name=event_name;
        this.head_event_image=head_event_image;
        this.eventId=eventId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getHead_event_image() {
        return head_event_image;
    }

    public void setHead_event_image(String head_event_image) {
        this.head_event_image = head_event_image;
    }

    public String getPrice() {
        return price;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String  getEvent_image() {
        return event_image;
    }

    public String getEvent_description_long() {
        return event_description_long;
    }

    public String getEvent_head_names() {
        return event_head_names;
    }

    public String getEvent_organizers_name() {
        return event_organizers_name;
    }

    public String getEvent_rules() {
        return event_rules;
    }

    public void setEvent_image(String event_image) {
        this.event_image = event_image;
    }

    public String getEvent_detail_short() {
        return event_detail_short;
    }

    public void setEvent_detail_short(String event_detail_short) {
        this.event_detail_short = event_detail_short;
    }

    public String getVenue_event() {
        return venue_event;
    }

    public void setVenue_event(String venue_event) {
        this.venue_event = venue_event;
    }

    public String getTime_event() {
        return time_event;
    }

    public void setTime_event(String time_event) {
        this.time_event = time_event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEvent_description_long(String event_description_long) {
        this.event_description_long = event_description_long;
    }

    public void setEvent_head_names(String event_head_names) {
        this.event_head_names = event_head_names;
    }

    public void setEvent_organizers_name(String event_organizers_name) {
        this.event_organizers_name = event_organizers_name;
    }

    public void setEvent_rules(String event_rules) {
        this.event_rules = event_rules;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public View.OnClickListener getRequestBtnClickListener() {
        return requestBtnClickListener;
    }

    public void setRequestBtnClickListener(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener = requestBtnClickListener;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (time_event != item.time_event) return false;
        if (price != null ? !price.equals(item.price) : item.price != null) return false;
        //if (event_image != null ? !event_image.equals(item.event_image) : item.event_image != null)
            //return false;
        if (event_detail_short != null ? !event_detail_short.equals(item.event_detail_short) : item.event_detail_short != null)
            return false;
        if (venue_event != null ? !venue_event.equals(item.venue_event) : item.venue_event != null)
            return false;
        if (date != null ? !date.equals(item.date) : item.date != null) return false;
        return !(time != null ? !time.equals(item.time) : item.time != null);

    }

    @Override
    public int hashCode() {
        int result = price != null ? price.hashCode() : 0;
        //result = 31 * result + (event_image != null ? event_image.hashCode() : 0);
        result = 31 * result + (event_detail_short != null ? event_detail_short.hashCode() : 0);
        result = 31 * result + (venue_event != null ? venue_event.hashCode() : 0);
        //result = 31 * result + time_event;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    /**
     * @return List of elements prepared for tests
     */
    public static ArrayList<Item> getTestingList() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("$14", "R.drawable.barry_allen", "RoboWar is an open-source video game in which the player programs onscreen icon-like robots to battle each other with animation and sound effects", "E-Block", "3:30PM", "TODAY", "05:10 PM","Trove Trace is the simulation event of in form of the online treasure hunt contest. A series of hints would be provided on the facebook page and the participants would have to decipher them in order to win the hunt.","Siddharth Vaish","Siddharth Vaish","Rules to be announced","Trove Trace","R.drawable.head_image",""));
        items.add(new Item("$23", "R.drawable.barry_allen", "RoboWar is an open-source video game in which the player programs onscreen icon-like robots to battle each other with animation and sound effects", "B-Block", "10:00AM", "TODAY", "11:10 AM","Trove Trace is the simulation event of in form of the online treasure hunt contest. A series of hints would be provided on the facebook page and the participants would have to decipher them in order to win the hunt.2","Siddharth Vaish2","Siddharth Vaish2","Rules to be announced2","Trove Trace","R.drawable.head_image",""));
        items.add(new Item("$63", "R.drawable.barry_allen", "RoboWar is an open-source video game in which the player programs onscreen icon-like robots to battle each other with animation and sound effects", "A-Block", "5:00PM", "TODAY", "07:11 PM","Trove Trace is the simulation event of in form of the online treasure hunt contest. A series of hints would be provided on the facebook page and the participants would have to decipher them in order to win the hunt.3","Siddharth Vaish3","Siddharth Vaish3","Rules to be announced3","Trove Trace","R.drawable.head_image",""));
        items.add(new Item("$19", "R.drawable.barry_allen", "RoboWar is an open-source video game in which the player programs onscreen icon-like robots to battle each other with animation and sound effects", "C-Block", "2:30PM", "TODAY", "4:15 AM","Trove Trace is the simulation event of in form of the online treasure hunt contest. A series of hints would be provided on the facebook page and the participants would have to decipher them in order to win the hunt.4","Siddharth Vaish4","Siddharth Vaish4","Rules to be announced4","Trove Trace","R.drawable.head_image",""));
        items.add(new Item("$5", "R.drawable.barry_allen", "RoboWar is an open-source video game in which the player programs onscreen icon-like robots to battle each other with animation and sound effects", "D-Block", "6:00AM", "TODAY", "06:15 PM","Trove Trace is the simulation event of in form of the online treasure hunt contest. A series of hints would be provided on the facebook page and the participants would have to decipher them in order to win the hunt.5","Siddharth Vaish5","Siddharth Vaish5","Rules to be announced5","Trove Trace","R.drawable.head_image",""));
        return items;

    }

}
