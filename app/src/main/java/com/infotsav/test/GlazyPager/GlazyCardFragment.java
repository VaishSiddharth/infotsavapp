package com.infotsav.test.GlazyPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.infotsav.test.R;
import com.infotsav.test.foldingView.FoldingActivity;

public class GlazyCardFragment extends Fragment {

    private Context mContext;
    private GlazyCard card;
    String str;

    public static GlazyCardFragment newInstance(GlazyCard card) {
        GlazyCardFragment glazyCardFragment = new GlazyCardFragment();
        Bundle args = new Bundle();
        args.putSerializable("glazy_card", card);
        glazyCardFragment.setArguments(args);

        return glazyCardFragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        card = (GlazyCard) getArguments().getSerializable("glazy_card");
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.layout_page, container, false);
        v.setBackgroundColor(card.getBackgroundColor());
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(card.getTitle().equals("ALL"))
                {
                    str = "all";
                    Intent intent = new Intent(getContext(), FoldingActivity.class);
                    intent.putExtra("message",str);
                    startActivity(intent);
                    //Toast.makeText(getContext(),"Working",Toast.LENGTH_LONG).show();
                }
                else if(card.getTitle().equals("GAMIACS"))
                {
                    str = "gamiacs";
                    Intent intent = new Intent(getContext(), FoldingActivity.class);
                    intent.putExtra("message",str);
                    startActivity(intent);
                }
                else if (card.getTitle().equals("MANAGERIAL")){
                    str = "managerial";
                    Intent intent = new Intent(getContext(), FoldingActivity.class);
                    intent.putExtra("message",str);
                    startActivity(intent);

                }
                else if (card.getTitle().equals("ONLINE")){
                    str = "online";
                    Intent intent = new Intent(getContext(), FoldingActivity.class);
                    intent.putExtra("message",str);
                    startActivity(intent);

                }
                else if (card.getTitle().equals("ONSITE")){
                    str = "onsite";
                    Intent intent = new Intent(getContext(), FoldingActivity.class);
                    intent.putExtra("message",str);
                    startActivity(intent);

                }
                else if (card.getTitle().equals("ROBOTICS")){
                    str = "robotics";
                    Intent intent = new Intent(getContext(), FoldingActivity.class);
                    intent.putExtra("message",str);
                    startActivity(intent);

                }
                else if (card.getTitle().equals("TECHNICAL")){
                    str = "technical";
                    Intent intent = new Intent(getContext(), FoldingActivity.class);
                    intent.putExtra("message",str);
                    startActivity(intent);

                }
                else if (card.getTitle().equals("SCHOOL")){
                    str = "school";
                    Intent intent = new Intent(getContext(), FoldingActivity.class);
                    intent.putExtra("message",str);
                    startActivity(intent);

                }

            }
        });

        TextView description = (TextView) v.findViewById(R.id.description_text);
        description.setText(card.getDescription());
        description.setAlpha(0f);
        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(card.getTitle().equals("ALL"))
                {
                    str = "all";
                    Intent intent = new Intent(getContext(), FoldingActivity.class);
                    intent.putExtra("message",str);
                    startActivity(intent);
                    //Toast.makeText(getContext(),"Working",Toast.LENGTH_LONG).show();
                }
                else if(card.getTitle().equals("GAMIACS"))
                {
                    str = "gamiacs";
                    Intent intent = new Intent(getContext(), FoldingActivity.class);
                    intent.putExtra("message",str);
                    startActivity(intent);
                }
                else if (card.getTitle().equals("MANAGERIAL")){
                    str = "managerial";
                    Intent intent = new Intent(getContext(), FoldingActivity.class);
                    intent.putExtra("message",str);
                    startActivity(intent);

                }
                else if (card.getTitle().equals("ONLINE")){
                    str = "online";
                    Intent intent = new Intent(getContext(), FoldingActivity.class);
                    intent.putExtra("message",str);
                    startActivity(intent);

                }
                else if (card.getTitle().equals("ONSITE")){
                    str = "onsite";
                    Intent intent = new Intent(getContext(), FoldingActivity.class);
                    intent.putExtra("message",str);
                    startActivity(intent);

                }
                else if (card.getTitle().equals("ROBOTICS")){
                    str = "robotics";
                    Intent intent = new Intent(getContext(), FoldingActivity.class);
                    intent.putExtra("message",str);
                    startActivity(intent);

                }
                else if (card.getTitle().equals("TECHNICAL")){
                    str = "technical";
                    Intent intent = new Intent(getContext(), FoldingActivity.class);
                    intent.putExtra("message",str);
                    startActivity(intent);

                }
                else if (card.getTitle().equals("SCHOOL")){
                    str = "school";
                    Intent intent = new Intent(getContext(), FoldingActivity.class);
                    intent.putExtra("message",str);
                    startActivity(intent);

                }

            }
        });

        GlazyImageView imgView = (GlazyImageView) v.findViewById(R.id.glazy_image_view);
        imgView.setImageRes(card.getImageRes());
        imgView.setTitleText(card.getTitle());
        imgView.setTitleTextColor(card.getTitleColor());
        imgView.setTitleTextSize(Utils.dpToPx(mContext, card.getTitleSizeDP()));
        imgView.setSubTitleText(card.getSubTitle());
        imgView.setSubTitleTextColor(card.getSubTitleColor());
        imgView.setSubTitleTextSize(Utils.dpToPx(mContext, card.getSubTitleSizeDP()));
        imgView.setTextMargin(Utils.dpToPx(mContext, card.getTextmatginDP()));
        imgView.setLineSpacing(Utils.dpToPx(mContext, card.getLineSpacingDP()));
        imgView.setAutoTint(card.isAutoTint());
        imgView.setTintColor(card.getTintColor());
        imgView.setTintAlpha(card.getTintAlpha());
        imgView.setCutType(card.getImageCutType());
        imgView.setCutCount(card.getImageCutCount());
        imgView.setCutHeight(Utils.dpToPx(mContext,card.getImageCutHeightDP()));

        return v;
    }

}
