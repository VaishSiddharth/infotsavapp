package com.infotsav.test.CardViewLib;

import com.infotsav.test.R;
import com.ramotion.expandingcollection.ECCardData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.infotsav.test.Util.Constants.fact1;
import static com.infotsav.test.Util.Constants.fact10;
import static com.infotsav.test.Util.Constants.fact11;
import static com.infotsav.test.Util.Constants.fact12;
import static com.infotsav.test.Util.Constants.fact13;
import static com.infotsav.test.Util.Constants.fact14;
import static com.infotsav.test.Util.Constants.fact15;
import static com.infotsav.test.Util.Constants.fact16;
import static com.infotsav.test.Util.Constants.fact17;
import static com.infotsav.test.Util.Constants.fact18;
import static com.infotsav.test.Util.Constants.fact19;
import static com.infotsav.test.Util.Constants.fact2;
import static com.infotsav.test.Util.Constants.fact20;
import static com.infotsav.test.Util.Constants.fact21;
import static com.infotsav.test.Util.Constants.fact22;
import static com.infotsav.test.Util.Constants.fact3;
import static com.infotsav.test.Util.Constants.fact4;
import static com.infotsav.test.Util.Constants.fact5;
import static com.infotsav.test.Util.Constants.fact6;
import static com.infotsav.test.Util.Constants.fact7;
import static com.infotsav.test.Util.Constants.fact8;
import static com.infotsav.test.Util.Constants.fact9;

public class ExampleDataset {

    private ArrayList<ECCardData> dataset;
    private String facts[]={fact1,fact2,fact3,fact4,fact5,fact6,fact7,fact8,fact9,fact10,fact11,fact12,
            fact13,fact14,fact15,fact16,fact17,fact18,fact19,fact20,fact21,fact22};

    public ExampleDataset() {
        dataset = new ArrayList<>();

        int index1 = getRandomNumber();
        int index2 = getRandomNumber();
        int index3 = getRandomNumber();
        int index4 = getRandomNumber();
        int index5 = getRandomNumber();
        int index6 = getRandomNumber();
        int index7 = getRandomNumber();

        CardData item6 = new CardData();
        item6.setMainBackgroundResource(R.drawable.blackwidow60port);
        item6.setHeadBackgroundResource(R.drawable.blackwidow60land);
        item6.setHeadTitle("Events");
        item6.setPersonMessage("Captain America’s costume in Infinity War is based on two separate looks from the comics");
        item6.setPersonName(facts[index7]);
        item6.setPersonPictureResource(R.drawable.aaron_bradley);
        item6.setListItems(prepareCommentsArray());
        dataset.add(item6);

        CardData item5 = new CardData();
        item5.setMainBackgroundResource(R.drawable.spidey60port);
        item5.setHeadBackgroundResource(R.drawable.spidey60land);
        item5.setHeadTitle("Register");
        item5.setPersonMessage("Marvel may be developing that Black Widow movie after all");
        item5.setPersonName(facts[index6]);
        item5.setPersonPictureResource(R.drawable.aaron_bradley);
        item5.setListItems(prepareCommentsArray());
        dataset.add(item5);

        CardData item4 = new CardData();
        item4.setMainBackgroundResource(R.drawable.nickfurry60port);
        item4.setHeadBackgroundResource(R.drawable.nickfurry60land);
        item4.setHeadTitle("Updates");
        item4.setPersonMessage("Tony Stark is still nursing an injured left arm");
        item4.setPersonName(facts[index5]);
        item4.setPersonPictureResource(R.drawable.aaron_bradley);
        item4.setListItems(prepareCommentsArray());
        dataset.add(item4);

        CardData item3 = new CardData();
        item3.setMainBackgroundResource(R.drawable.thor60port);
        item3.setHeadBackgroundResource(R.drawable.thor60land);
        item3.setHeadTitle("Treasure Hunt");
        item3.setPersonMessage("In the comic books, Thanos erases half of the life in the universe");
        item3.setPersonName(facts[index4]);
        item3.setPersonPictureResource(R.drawable.aaron_bradley);
        item3.setListItems(prepareCommentsArray());
        dataset.add(item3);

        CardData item2 = new CardData();
        item2.setMainBackgroundResource(R.drawable.captainamerica60port);
        item2.setHeadBackgroundResource(R.drawable.captainamerica60);
        item2.setHeadTitle("Sponsors");
        item2.setPersonName(facts[index3]);
        item2.setPersonMessage("The final battle in Black Panther is more symbolic than you think");
        item2.setListItems(prepareCommentsArray());
        item2.setPersonPictureResource(R.drawable.tina_caldwell);
        dataset.add(item2);

        CardData item1a = new CardData();
        item1a.setMainBackgroundResource(R.drawable.ultron60port);
        item1a.setHeadBackgroundResource(R.drawable.ultron60land);
        item1a.setHeadTitle("About Us");
        item1a.setPersonMessage("Cur adelphis studere?");
        item1a.setPersonName(facts[index2]);
        item1a.setPersonPictureResource(R.drawable.aaron_bradley);
        item1a.setListItems(prepareCommentsArray());
        dataset.add(item1a);

        CardData item1 = new CardData();
        item1.setMainBackgroundResource(R.drawable.ironman60);
        item1.setHeadBackgroundResource(R.drawable.ironman60land);
        item1.setHeadTitle("Contact Us");
        item1.setPersonMessage("Cur adelphis studere?");
        item1.setPersonName(facts[index1]);
        item1.setPersonPictureResource(R.drawable.aaron_bradley);
        item1.setListItems(prepareCommentsArray());
        dataset.add(item1);

    }
    private int getRandomNumber() {

        return new Random().nextInt((21 - 0) + 1);
    }

    public List<ECCardData> getDataset() {
        //Collections.shuffle(dataset);
        return dataset;
    }

    private List<Comment> prepareCommentsArray() {
        Random random = new Random();
        List<Comment> comments = new ArrayList<>();
        comments.addAll(Arrays.asList(
                new Comment(R.drawable.aaron_bradley, "Aaron Bradley", "When the sensor experiments for deep space, all mermaids accelerate mysterious, vital moons.", "jan 12, 2014"),
                new Comment(R.drawable.aaron_bradley, "Barry Allen", "It is a cold powerdrain, sir.", "jun 1, 2015"),
                new Comment(R.drawable.aaron_bradley, "Bella Holmes", "Particle of a calm shield, control the alignment!", "sep 21, 1937"),
                new Comment(R.drawable.aaron_bradley, "Caroline Shaw", "The human kahless quickly promises the phenomenan.", "may 23, 1967"),
                new Comment(R.drawable.aaron_bradley, "Connor Graham", "Ionic cannon at the infinity room was the sensor of voyage, imitated to a dead pathway.", "sep 1, 1972"),
               // new Comment(R.drawable.deann_hunt, "Deann Hunt", "Vital particles, to the port.", "aug 13, 1995"),
                new Comment(R.drawable.aaron_bradley, "Ella Cole", "Stars fly with hypnosis at the boldly infinity room!", "nov 18, 1952"),
                new Comment(R.drawable.aaron_bradley, "Jayden Shaw", "Hypnosis, definition, and powerdrain.", "apr 1, 2013"),
                new Comment(R.drawable.aaron_bradley, "Jerry Carrol", "When the queen experiments for nowhere, all particles control reliable, cold captains.", "nov 14, 1964"),
                new Comment(R.drawable.aaron_bradley, "Lena Lukas", "When the c-beam experiments for astral city, all cosmonauts acquire remarkable, virtual lieutenant commanders.", "may 4, 1965"),
                new Comment(R.drawable.aaron_bradley, "Leonard Kim", "Starships walk with love at the cold parallel universe!", "jul 3, 1974"),
                new Comment(R.drawable.aaron_bradley, "Mark Baker", "Friendship at the bridge that is when quirky green people yell.", "dec 24, 1989")));
        Collections.shuffle(comments);
        return comments.subList(0, 6 + random.nextInt(5));
    }
}
