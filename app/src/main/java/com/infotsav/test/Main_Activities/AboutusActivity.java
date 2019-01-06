package com.infotsav.test.Main_Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.infotsav.test.R;

public class AboutusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        TextView mtitle= (TextView) findViewById(R.id.title_aboutus);

        TextView mtext= (TextView) findViewById(R.id.aboutus_description);
        //mtitle.setText("ABOUT US");
        StringBuilder stringBuilder= new StringBuilder();
        String para="Infotsav is the techno-managerial fest of the institute, " +
                "aimed at nurturing creativity and innovation among the youth in a " +
                "competitive as well as a recreational manner. Participants hail " +
                "from premier technical and managerial institutions of the region," +
                "and from a wide range of backgrounds. Sponsored by businesses behind " +
                "cutting-edge technologies,it has got everything to boast its status " +
                "as a national-level technical festival. Events range from online Contests " +
                "live Trave Trace to nerve-wrecking hackathons, mind boggling quizzes, " +
                "intensive coding contests and perhaps everything in between. Besides Prize Money, " +
                "exposure at the national level serves as a great incentive for the participants. " +
                "From 8th-9th February, every brain out there that has got the guts to battle " +
                "it out in the wars of grey matter ,will be fighting in every domain possible.";

            stringBuilder.append(para);
          mtext.setText(stringBuilder.toString());
    }
    public void fb(View view){
        Intent facebook=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/Infotsav/"));
        startActivity(facebook);
    }
    public void inst(View view){
        Intent instagram=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com/infotsav19/?zr_mid=XA6V9wAEAAFQRW0DTH70nlzoGlIz&ctime=1544459769&rtime=1544459767&hrc=1"));
        startActivity(instagram);
    }
    public void twi(View view){
        Intent twitter=new Intent(Intent.ACTION_VIEW,Uri.parse("https://twitter.com/infotsav"));
        startActivity(twitter);
    }
    public void lin(View view){
        Intent lind=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.linkedin.com/authwall?trk=gf&trkInfo=AQFJQVA82Mmu9AAAAWeY_RSwb8Fp19sXO5Q1hBC7QsBI_XkGgZOz8Vj2ar3GgW8fk0nDKt5Ncdc_zps5pBucvskVq9oQO5cJveNcYUHSRWYLI2Cm27Mo_0jFdJ-lSYu3_xI410w=&originalReferer=https://infotsav.in/&sessionRedirect=https%3A%2F%2Fwww.linkedin.com%2Fin%2Finfotsav-iiitm-9b9941174%2F"));
        startActivity(lind);
    }
    public void web(View view){
        Intent webs=new Intent(Intent.ACTION_VIEW,Uri.parse("https://infotsav.in/"));
        startActivity(webs);
    }
}
