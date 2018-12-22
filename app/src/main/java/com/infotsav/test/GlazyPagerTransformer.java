package com.infotsav.test;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.infotsav.test.R;


public class GlazyPagerTransformer implements ViewPager.PageTransformer {

    private GlazyViewPager mPager;

    public GlazyPagerTransformer() {

    }

    @Override
    public void transformPage(View page, float posActual) {

        float posCorrection = - (float) mPager.getPaddingLeft() / page.getWidth();
        float position = posActual + posCorrection;

        if(Math.abs(position) <= 1.1f) {

            float factor = 1.0f - Math.abs(position);
            ((GlazyImageView) page.findViewById(R.id.glazy_image_view)).update(factor);
            (page.findViewById(R.id.description_text)).setAlpha(factor);

        }
    }

    public void attachedPager(GlazyViewPager pager) {
        mPager = pager;
    }
}