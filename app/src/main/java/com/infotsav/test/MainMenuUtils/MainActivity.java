package com.infotsav.test.MainMenuUtils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.infotsav.test.Main_Activities.AboutusActivity;
import com.infotsav.test.Main_Activities.ContactusActivity;
import com.infotsav.test.Main_Activities.Register_Activity;
import com.infotsav.test.Main_Activities.TabContactUs;
import com.infotsav.test.Main_Activities.TreasurehuntActivity;
import com.infotsav.test.PagerActivity;
import com.infotsav.test.R;
import com.infotsav.test.Main_Activities.SponsorsActivity;
import com.infotsav.test.Main_Activities.UpdatesActivity;
import com.infotsav.test.Util.Constants;
import com.ramotion.expandingcollection.ECBackgroundSwitcherView;
import com.ramotion.expandingcollection.ECCardData;
import com.ramotion.expandingcollection.ECPagerView;
import com.ramotion.expandingcollection.ECPagerViewAdapter;
@SuppressLint("SetTextI18n")
public class MainActivity extends Activity {

    private ECPagerView ecPagerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        setContentView(R.layout.activity_main);

        // Create adapter for pager
        ECPagerViewAdapter adapter = new ECPagerViewAdapter(this, new ExampleDataset().getDataset()) {
            @Override
            public void instantiateCard(LayoutInflater inflaterService, final ViewGroup head, ListView list, final ECCardData data) {
                final CardData cardData = (CardData) data;

                // Create adapter for list inside a card and set adapter to card content
                CommentArrayAdapter commentArrayAdapter = new CommentArrayAdapter(getApplicationContext(), cardData.getListItems());
                list.setAdapter(commentArrayAdapter);
                list.setDivider(getResources().getDrawable(R.drawable.list_divider));
                list.setDividerHeight((int) pxFromDp(getApplicationContext(), 0.5f));
                list.setSelector(R.color.transparent);
                list.setBackgroundColor(Color.WHITE);
                list.setCacheColorHint(Color.TRANSPARENT);

                // Add gradient to root header view
                View gradient = new View(getApplicationContext());
                gradient.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT));
                gradient.setBackgroundDrawable(getResources().getDrawable(R.drawable.card_head_gradient));
                head.addView(gradient);

                // Inflate main header layout and attach it to header root view
                inflaterService.inflate(R.layout.simple_head, head);

                // Set header data from data object
                TextView title = (TextView) head.findViewById(R.id.title);
                title.setText(cardData.getHeadTitle());
                ImageView avatar = (ImageView) head.findViewById(R.id.avatar);
                avatar.setImageResource(cardData.getPersonPictureResource());
                TextView name = (TextView) head.findViewById(R.id.name);
                name.setText(cardData.getPersonName() + ":");
                TextView message = (TextView) head.findViewById(R.id.message);
                message.setText(cardData.getPersonMessage());
                TextView viewsCount = (TextView) head.findViewById(R.id.socialViewsCount);
                viewsCount.setText(" " + cardData.getPersonViewsCount());
                TextView likesCount = (TextView) head.findViewById(R.id.socialLikesCount);
                likesCount.setText(" " + cardData.getPersonLikesCount());
                TextView commentsCount = (TextView) head.findViewById(R.id.socialCommentsCount);
                commentsCount.setText(" " + cardData.getPersonCommentsCount());

                // Add onclick listener to card header for toggle card state
                head.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        //ecPagerView.toggle();
                        //TODO: Get the name of the title (from cardData.get..()), then match them with enums, for example if head's title is home then go to home activity,
                        //TODO: and if its an event go to event library, transitions to activity can be added later that will make it look smoother.
                        
                        if(cardData.getHeadTitle().equals(Constants.Events))
                        {
                            startActivity(new Intent(MainActivity.this, PagerActivity.class));
                        }
                        else if(cardData.getHeadTitle().equals(Constants.Register))
                        {
                            startActivity(new Intent(MainActivity.this, Register_Activity.class));
                        }
                        else if(cardData.getHeadTitle().equals(Constants.Updates))
                        {
                            startActivity(new Intent(MainActivity.this, UpdatesActivity.class));
                        }
                        else if(cardData.getHeadTitle().equals(Constants.Treasurehunt))
                        {
                            startActivity(new Intent(MainActivity.this, TreasurehuntActivity.class));
                        }
                        else if(cardData.getHeadTitle().equals(Constants.Sponsors))
                        {
                            startActivity(new Intent(MainActivity.this, SponsorsActivity.class));
                        }
                        else if(cardData.getHeadTitle().equals(Constants.Contactus))
                        {
                            startActivity(new Intent(MainActivity.this, TabContactUs.class));
                        }
                        else if(cardData.getHeadTitle().equals(Constants.Aboutus))
                        {
                            startActivity(new Intent(MainActivity.this, AboutusActivity.class));
                        }
                    }
                });
            }
        };

        ecPagerView = (ECPagerView) findViewById(R.id.ec_pager_element);

        ecPagerView.setPagerViewAdapter(adapter);
        ecPagerView.setBackgroundSwitcherView((ECBackgroundSwitcherView) findViewById(R.id.ec_bg_switcher_element));

        final ItemsCountView itemsCountView = (ItemsCountView) findViewById(R.id.items_count_view);
        ecPagerView.setOnCardSelectedListener(new ECPagerView.OnCardSelectedListener() {
            @Override
            public void cardSelected(int newPosition, int oldPosition, int totalElements) {
                itemsCountView.update(newPosition, oldPosition, totalElements);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (!ecPagerView.collapse())
            super.onBackPressed();
    }

    public static float dpFromPx(final Context context, final float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    public static float pxFromDp(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

}
