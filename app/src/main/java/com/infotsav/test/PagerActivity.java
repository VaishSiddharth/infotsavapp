package com.infotsav.test;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;


import com.infotsav.test.GlazyCard;
import com.infotsav.test.GlazyImageView;
import com.infotsav.test.GlazyPagerTransformer;
import com.infotsav.test.GlazyViewPager;
import com.infotsav.test.R;
import com.infotsav.test.Utils;

import static com.infotsav.test.Util.Constants.all;
import static com.infotsav.test.Util.Constants.gamiacs;
import static com.infotsav.test.Util.Constants.managerial;
import static com.infotsav.test.Util.Constants.online;
import static com.infotsav.test.Util.Constants.onsite;
import static com.infotsav.test.Util.Constants.robotics;
import static com.infotsav.test.Util.Constants.school;
import static com.infotsav.test.Util.Constants.technical;


public class PagerActivity extends AppCompatActivity {

    private GlazyViewPager mPager;
    private GlazyFragmentPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setTitle("GlazyViewPager");*/

        mPager = (GlazyViewPager) findViewById(R.id.pager);
        mPager.hasOnClickListeners();
        mPagerAdapter = new GlazyFragmentPagerAdapter(getSupportFragmentManager(), getApplicationContext());

        Resources resources = getApplicationContext().getResources();
        int img_matt = resources.getIdentifier("matt_le_blanc", "drawable", getPackageName());
        int img_courteny = resources.getIdentifier("courteny_cox", "drawable", getPackageName());
        int img_david = resources.getIdentifier("david_schwimmer", "drawable", getPackageName());
        int img_jennifer = resources.getIdentifier("jennifer_aniston", "drawable", getPackageName());
        int img_lisa = resources.getIdentifier("lisa_kudrow", "drawable", getPackageName());
        int img_matthew = resources.getIdentifier("matthew_perry", "drawable", getPackageName());

        String desc_jenif = "Jennifer Joanna Aniston (born February 11, 1969) is an American" +
                " actress, producer, and businesswoman. Aniston gained worldwide recognition" +
                " for portraying Rachel Green on the popular television sitcom Friends," +
                " a role which earned her a Primetime Emmy Award, a Golden Globe Award, and a" +
                " Screen Actors Guild Award.";

        String desc_david = "Born in Queens, New York, in 1966, David Schwimmer appeared on " +
                "TV shows such as The Wonder Years, NYPD Blue and Friends in 1994." +
                "Following the hit sitcom's 10-year run, Schwimmer starred in theater" +
                " productions and directed the feature films Run Fatboy Run (2007) a" +
                "nd Trust (2010).";

        String desc_lisa = "Lisa Valerie Kudrow; born July 30, 1963 is an American actress," +
                " comedian, writer and producer. She gained worldwide recognition for her" +
                " ten-season run as Phoebe Buffay and Ursula Buffay on the television sitcom " +
                "Friends, for which she received an Emmy Award in 1998, and two " +
                "Screen Actors Guild Awards in 1996 and 2000.";

        String desc_matt = "Matthew Steven LeBlanc (born July 25, 1967) is an American actor," +
                " comedian, television host, and producer, best known for his role as " +
                "Joey Tribbiani on sitcom Friends. He won a Golden Globe award; nominated for " +
                "an Emmy three times for his work on Friends and four times for Episodes." +
                " LeBlanc has hosted the BBC motoring show Top Gear.";

        String desc_corteny = "Courteney Bass Cox (born June 15, 1964) is an American actress," +
                " producer, and director. She is best known for her roles as Monica Geller on " +
                "the NBC sitcom Friends, Gale Weathers in the horror series Scream, and Jules" +
                " Cobb in the ABC/TBS sitcom Cougar Town, for which she earned her first Golden" +
                " Globe nomination. Cox also starred in the FX series Dirt.";

        String desc_matthew = "Matthew Langford Perry (born August 19, 1969) is a Canadian and " +
                "American actor. Perry is best known for his role as Chandler Bing on the " +
                "long-running NBC television sitcom Friends. Perry has appeared in a number " +
                "of films, including Fools Rush In (1997), The Whole Nine Yards (2000)," +
                " and 17 Again (2009).";

        mPagerAdapter.addCardItem(
                new GlazyCard()
                        .withTitle("ONSITE")
                        .withSubTitle("EVENTS")
                        .withDescription(desc_matt.toUpperCase())
                        .withImageRes(R.drawable.thoronsite)
                        .withImageCutType(GlazyImageView.ImageCutType.WAVE)
                        .withImageCutHeightDP(40)
        );


        mPagerAdapter.addCardItem(
                new GlazyCard()
                        .withTitle("ROBOTICS")
                        .withSubTitle("EVENTS")
                        .withDescription(desc_matt.toUpperCase())
                        .withImageRes(R.drawable.ultronrobotics)
                        .withImageCutType(GlazyImageView.ImageCutType.ARC)
                        .withImageCutHeightDP(40)
        );

        mPagerAdapter.addCardItem(
                new GlazyCard()
                        .withTitle("GAMIACS")
                        .withSubTitle("EVENTS")
                        .withDescription(desc_matt.toUpperCase())
                        .withImageRes(R.drawable.hulkgames)
                        .withImageCutType(GlazyImageView.ImageCutType.LINE_POSITIVE)
                        .withImageCutHeightDP(40)
        );
        mPagerAdapter.addCardItem(
                new GlazyCard()
                        .withTitle("MANAGERIAL")
                        .withSubTitle("EVENTS")
                        .withDescription(desc_corteny.toUpperCase())
                        .withImageRes(R.drawable.captainmanagerial)
                        .withImageCutType(GlazyImageView.ImageCutType.WAVE)
                        .withImageCutHeightDP(40)
        );
        mPagerAdapter.addCardItem(
                new GlazyCard()
                        .withTitle("SCHOOL")
                        .withSubTitle("EVENTS")
                        .withDescription(desc_david.toUpperCase())
                        .withImageRes(R.drawable.spidermanschool)
                        .withImageCutType(GlazyImageView.ImageCutType.ARC)
                        .withImageCutHeightDP(40)
        );
        mPagerAdapter.addCardItem(
                new GlazyCard()
                        .withTitle("TECHNICAL")
                        .withSubTitle("EVENTS")
                        .withDescription(desc_jenif.toUpperCase())
                        .withImageRes(R.drawable.irontechnical)
                        .withImageCutType(GlazyImageView.ImageCutType.LINE_POSITIVE)
                        .withImageCutHeightDP(40)
        );
        mPagerAdapter.addCardItem(
                new GlazyCard()
                        .withTitle("ONLINE")
                        .withSubTitle("EVENTS")
                        .withDescription(desc_lisa.toUpperCase())
                        .withImageRes(R.drawable.rocketonline)
                        .withImageCutType(GlazyImageView.ImageCutType.WAVE)
                        .withImageCutHeightDP(40)
        );
        mPagerAdapter.addCardItem(
                new GlazyCard()
                        .withTitle("ALL")
                        .withSubTitle("EVENTS")
                        .withDescription(desc_matthew.toUpperCase())
                        .withImageRes(R.drawable.thanosall)
                        .withImageCutType(GlazyImageView.ImageCutType.ARC)
                        .withImageCutHeightDP(40)
        );


        mPager.setAdapter(mPagerAdapter);
        mPager.setPageMargin(Utils.dpToPx(getApplicationContext(), 25));
        mPager.setPageTransformer(false, new GlazyPagerTransformer());
    }

}
