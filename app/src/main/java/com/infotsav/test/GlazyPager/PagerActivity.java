package com.infotsav.test.GlazyPager;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.infotsav.test.R;


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

        String desc_thor = "The hammer of Thor can only be wielded by those who are worthy. However, in the comics, " +
                "there are a long line of those who qualify, including an alien named Beta Ray Bill. During a fight, Bill" +
                " managed to grab Mjolnir, which deemed him worthy. They were both transported back to Asgard where Odin " +
                "had the two fight it out to see who got to keep the hammer. Bill won, but being the upstanding guy he is, " +
                "refused to kill Thor. Odin gave Mjolnir back to Thor and made a new hammer for Bill.\n\n";

        String desc_loki = "As a prank, Loki once transformed Thor into a frog. An actual frog. Thor subsequently participated" +
                " in a rats vs. frogs war in New York’s Central Park. Even when he got his hammer back, he transformed back only " +
                "half way, to a frog man. Fellow god and humorless friend Volstagg ultimately returned Thor to his fully normal self \n\n\n";

        String desc_michael = "Michael Jackson tried to buy Marvel Comics in the early 1990' so that he could play Spider-Man in his " +
                "own produced movie. According to Marvel legend Stan Lee, Jackson had a particular liking to the web-slinging " +
                "neighbourhood friend, Spider-Man. Eventually, Jacko was unable to secure the rights to Marvel and his dream of " +
                "swinging through New York City with spidey senses was gone.\n\n\n\n\n";

        String desc_gamora = "Guardians fans might be surprised to find out that Saldana (Gamora) was a dancer for most of her early life." +
                " The actress studied ballet, but eventually chose acting since it gave her a voice. Saldana said that dance uses your whole " +
                "body except for your voice, and she didn't want to be voiceless. Also, she was told she didn't have the feet for ballet, " +
                "and didn't want to be sentenced to a life of an in-house background dancer. \n\n\n\n";

        String desc_hulk = "In the debut of Hulk, Stan Lee chose gray for the Hulk because he wanted a color that did not suggest any" +
                " particular ethnic group. Colorist Stan Goldberg, however, had problems with the gray coloring, resulting in different " +
                "shades of grey, and even green, in the issue. After seeing the first published issue, Lee chose to change the skin color " +
                "to green. \n\n\n\n\n";

        String desc_mandarin = "The Mandarin is the true villain in the world of Iron Man comics. He is the one who keeps bringing new " +
                "twists and turns in the life of Tony Stark. And he is the one who keeps escaping and evades every attack. But in the movie" +
                " he was wandered off as a Gag piece. Initially Jon Favreau wanted The Mandarin as the main anti-hero in the first installment" +
                " of Iron Man. But then decided against it because he felt it would see as too strong for the first part. Hence, dropped the " +
                "idea altogether.\n\n";

        String desc_ironman = "Terrence Howard had a three movie contract with Marvel, with ‘Iron Man’ as the first project. Also, he was" +
                " promised an increased pay if the movie Iron Man became a success and was turned into a franchisee. The money deal offered " +
                "to him was actually way more than what Marvel had offered to Robert Downey Jr. But once the movie made a killing at the Box " +
                "Office, Howard received only a fraction of what was promised. Hence, Terrence decided to walk away from the project and all" +
                " the money went to Robert Downey Jr’s pocket. Hence, Terrence Howard was dethroned even before he got used to his act.";

        String desc_avengers = "Marvel created a superhero named Throg. He is a frog that has the power of Thor and is in a group called the" +
                " Pet Avengers." +
                "Aside from acting, Jeremy Renner also has quite a few hidden talents. Renner renovates houses, fixing and flipping them" +
                " for a higher price. It's a business that helped him and business partner Kristoffer Winter during their struggling actor " +
                "days. But this is just one of Renner's many skills. \n\n\n\n\n";

        mPagerAdapter.addCardItem(
                new GlazyCard()
                        .withTitle("ONLINE")
                        .withSubTitle("EVENTS")
                        .withDescription(desc_gamora.toUpperCase())
                        .withImageRes(R.drawable.rocketonline)
                        .withImageCutType(GlazyImageView.ImageCutType.WAVE)
                        .withImageCutHeightDP(40)
        );

        mPagerAdapter.addCardItem(
                new GlazyCard()
                        .withTitle("ONSITE")
                        .withSubTitle("EVENTS")
                        .withDescription(desc_thor.toUpperCase())
                        .withImageRes(R.drawable.thoronsite)
                        .withImageCutType(GlazyImageView.ImageCutType.WAVE)
                        .withImageCutHeightDP(40)
        );

        mPagerAdapter.addCardItem(
                new GlazyCard()
                        .withTitle("TECHNICAL")
                        .withSubTitle("EVENTS")
                        .withDescription(desc_ironman.toUpperCase())
                        .withImageRes(R.drawable.irontechnical)
                        .withImageCutType(GlazyImageView.ImageCutType.LINE_POSITIVE)
                        .withImageCutHeightDP(40)
        );

        mPagerAdapter.addCardItem(
                new GlazyCard()
                        .withTitle("SCHOOL")
                        .withSubTitle("EVENTS")
                        .withDescription(desc_michael.toUpperCase())
                        .withImageRes(R.drawable.spidermanschool)
                        .withImageCutType(GlazyImageView.ImageCutType.ARC)
                        .withImageCutHeightDP(40)
        );

        mPagerAdapter.addCardItem(
                new GlazyCard()
                        .withTitle("MANAGERIAL")
                        .withSubTitle("EVENTS")
                        .withDescription(desc_avengers.toUpperCase())
                        .withImageRes(R.drawable.captainmanagerial)
                        .withImageCutType(GlazyImageView.ImageCutType.WAVE)
                        .withImageCutHeightDP(40)
        );

        mPagerAdapter.addCardItem(
                new GlazyCard()
                        .withTitle("GAMIACS")
                        .withSubTitle("EVENTS")
                        .withDescription(desc_hulk.toUpperCase())
                        .withImageRes(R.drawable.hulkgames)
                        .withImageCutType(GlazyImageView.ImageCutType.LINE_POSITIVE)
                        .withImageCutHeightDP(40)
        );

        mPagerAdapter.addCardItem(
                new GlazyCard()
                        .withTitle("ROBOTICS")
                        .withSubTitle("EVENTS")
                        .withDescription(desc_mandarin.toUpperCase())
                        .withImageRes(R.drawable.ultronrobotics)
                        .withImageCutType(GlazyImageView.ImageCutType.ARC)
                        .withImageCutHeightDP(40)
        );


        /*mPagerAdapter.addCardItem(
                new GlazyCard()
                        .withTitle("ALL")
                        .withSubTitle("EVENTS")
                        .withDescription(desc_loki.toUpperCase())
                        .withImageRes(R.drawable.thanosall)
                        .withImageCutType(GlazyImageView.ImageCutType.ARC)
                        .withImageCutHeightDP(40)
        );*/


        mPager.setAdapter(mPagerAdapter);
        mPager.setPageMargin(Utils.dpToPx(getApplicationContext(), 25));
        mPager.setPageTransformer(false, new GlazyPagerTransformer());
    }

}
