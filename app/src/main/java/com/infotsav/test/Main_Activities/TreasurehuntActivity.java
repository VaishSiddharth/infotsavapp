package com.infotsav.test.Main_Activities;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.media.MediaScannerConnection;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;
import com.infotsav.test.CardViewLib.MainActivity;
import com.infotsav.test.R;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.pedant.SweetAlert.Constants;
import cn.pedant.SweetAlert.SweetAlertDialog;
import github.nisrulz.screenshott.ScreenShott;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission.CAMERA;
import static com.infotsav.test.Util.Constants.Aboutus;
import static com.infotsav.test.Util.Constants.fact1;
import static com.infotsav.test.Util.Constants.pc1;
import static com.infotsav.test.Util.Constants.pc10;
import static com.infotsav.test.Util.Constants.pc11;
import static com.infotsav.test.Util.Constants.pc12;
import static com.infotsav.test.Util.Constants.pc2;
import static com.infotsav.test.Util.Constants.pc3;
import static com.infotsav.test.Util.Constants.pc4;
import static com.infotsav.test.Util.Constants.pc5;
import static com.infotsav.test.Util.Constants.pc6;
import static com.infotsav.test.Util.Constants.pc7;
import static com.infotsav.test.Util.Constants.pc8;
import static com.infotsav.test.Util.Constants.pc9;
import static com.infotsav.test.Util.Constants.pcfake;
import static com.infotsav.test.Util.Constants.r1;
import static com.infotsav.test.Util.Constants.r10;
import static com.infotsav.test.Util.Constants.r11;
import static com.infotsav.test.Util.Constants.r12;
import static com.infotsav.test.Util.Constants.r2;
import static com.infotsav.test.Util.Constants.r3;
import static com.infotsav.test.Util.Constants.r4;
import static com.infotsav.test.Util.Constants.r5;
import static com.infotsav.test.Util.Constants.r6;
import static com.infotsav.test.Util.Constants.r7;
import static com.infotsav.test.Util.Constants.r8;
import static com.infotsav.test.Util.Constants.r9;
import static com.infotsav.test.Util.Constants.rfake;

public class TreasurehuntActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private static final int REQUEST_CAMERA = 1;
    private ZXingScannerView scannerView;
    File file;
    private static int camId = Camera.CameraInfo.CAMERA_FACING_BACK;

    final String str1 = "World war 2";
    final String str2 = "Sokovia accord";
    final String str3 = "Sakaar";
    final String str5 = "Mjolnir";
    final String str6 = "Johann Schmidh";
    final String str7 = "Cosmo";
    final String str9 = "Star Lord";
    final String str10 = "42";
    final String str11 = "Jotunheim";
    final String str4 = "vibranium";
    final String str8 = "levitation";
    final String str12 = "carter";
    TextView riddle, cracker,crackertext;
    EditText enterpassword;
    ImageView image_th;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
        int currentApiVersion = Build.VERSION.SDK_INT;

        if (currentApiVersion >= Build.VERSION_CODES.M) {
            if (checkPermission()) {
                Toast.makeText(getApplicationContext(), "Permission already granted!", Toast.LENGTH_LONG).show();
            } else {
                requestPermission();
            }
        }
    }

    private boolean checkPermission() {
        return (ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA) == PackageManager.PERMISSION_GRANTED);
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{CAMERA}, REQUEST_CAMERA);
    }

    @Override
    public void onResume() {
        super.onResume();

        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= android.os.Build.VERSION_CODES.M) {
            if (checkPermission()) {
                if (scannerView == null) {
                    scannerView = new ZXingScannerView(this);
                    setContentView(scannerView);
                }
                scannerView.setResultHandler(this);
                scannerView.startCamera();
            } else {
                requestPermission();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        scannerView.stopCamera();
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CAMERA:
                if (grantResults.length > 0) {

                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (cameraAccepted) {
                        Toast.makeText(getApplicationContext(), "Permission Granted, Now you can access camera", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Permission Denied, You cannot access and camera", Toast.LENGTH_LONG).show();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(CAMERA)) {
                                showMessageOKCancel("You need to allow access to both the permissions",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{CAMERA},
                                                            REQUEST_CAMERA);
                                                }
                                            }
                                        });
                                return;
                            }
                        }
                    }
                }
                break;
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new android.support.v7.app.AlertDialog.Builder(TreasurehuntActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    @Override
    public void handleResult(final Result result) {
        final View view = getLayoutInflater().inflate(R.layout.activity_treasurehunt, null);
        final View viewriddle = getLayoutInflater().inflate(R.layout.treasurehunt_riddle_layout, null);
        final String myResult = result.getText();
        riddle = viewriddle.findViewById(R.id.riddle);
        cracker = viewriddle.findViewById(R.id.passwordcracker);
        crackertext=viewriddle.findViewById(R.id.crackertext);
        enterpassword = view.findViewById(R.id.enterpassword);
        image_th=viewriddle.findViewById(R.id.image_th);
        final Drawable d=getResources().getDrawable(R.drawable.route24);
        Log.d("QRCodeScanner", result.getText());
        Log.d("QRCodeScanner", result.getBarcodeFormat().toString());


        final SweetAlertDialog sweetAlertDialog1 = new SweetAlertDialog(TreasurehuntActivity.this, SweetAlertDialog.NORMAL_TYPE);
        sweetAlertDialog1.setCustomView(view);
        sweetAlertDialog1.setConfirmButton("Sure", new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog1.dismiss();
                crackertext.setVisibility(View.VISIBLE);
                if(myResult.equalsIgnoreCase("asdfghjkqwertyui")){
                    image_th.setVisibility(View.GONE);
                    fun(str1,sweetAlertDialog1,view,viewriddle,r1,pc1,d);
                }
                else if(myResult.equalsIgnoreCase("fghjrtyuiodfghjkldfghjkl;")){
                    image_th.setVisibility(View.GONE);
                    fun(str2,sweetAlertDialog1,view,viewriddle,r2,pc2,d);

                }
                else if(myResult.equalsIgnoreCase("qwazxcvbasdfghzxcvbnm")){
                    image_th.setVisibility(View.VISIBLE);
                    Drawable drawable= getResources().getDrawable(R.drawable.route14);
                    fun(str3,sweetAlertDialog1,view,viewriddle,r3,pc3,drawable);

                }
                else if(myResult.equalsIgnoreCase("zxcvbnmasdfghjkqwertyucvbn")){
                    image_th.setVisibility(View.GONE);
                    crackertext.setVisibility(View.GONE);
                    fun(str4,sweetAlertDialog1,view,viewriddle,r4,pc4,d);

                }
                else if(myResult.equalsIgnoreCase("mbvcxzsdfghjkiuytrefghj")){
                    image_th.setVisibility(View.GONE);
                    fun(str5,sweetAlertDialog1,view,viewriddle,r5,pc5,d);

                }
                else if(myResult.equalsIgnoreCase("qwertyujmnbvcxzxdfghjklol")){
                    image_th.setVisibility(View.GONE);
                    fun(str6,sweetAlertDialog1,view,viewriddle,r6,pc6,d);

                }
                else if(myResult.equalsIgnoreCase("qwertyuikmxcvbdfghjkpoiuyh")){
                    image_th.setVisibility(View.VISIBLE);
                    Drawable drawable = getResources().getDrawable(R.drawable.route24);
                    fun(str7,sweetAlertDialog1,view,viewriddle,r7,pc7,drawable);

                }
                else if(myResult.equalsIgnoreCase("unhggrvth hyunbgh jkdjjdjd")){
                    image_th.setVisibility(View.GONE);
                    crackertext.setVisibility(View.GONE);
                    fun(str8,sweetAlertDialog1,view,viewriddle,r8,pc8,d);

                }
                else if(myResult.equalsIgnoreCase("bgbsteheyeurjjhtjtjtutkkdjed")){
                    image_th.setVisibility(View.GONE);
                    fun(str9,sweetAlertDialog1,view,viewriddle,r9,pc9,d);

                }
                else if(myResult.equalsIgnoreCase("qwefgbnmasdfghzxcvbqwertasdfcvb")){
                    image_th.setVisibility(View.GONE);
                    fun(str10,sweetAlertDialog1,view,viewriddle,r10,pc10,d);

                }
                else if(myResult.equalsIgnoreCase("pllnjjhghbgsnbdhenbehnd")){
                    image_th.setVisibility(View.VISIBLE);
                    Drawable drawable = getResources().getDrawable(R.drawable.route34);
                    fun(str11,sweetAlertDialog1,view,viewriddle,r11,pc11,drawable);

                }
                else if(myResult.equalsIgnoreCase("qqwertyuasdfghjksdfghjk")){
                    image_th.setVisibility(View.GONE);
                    crackertext.setVisibility(View.GONE);
                    fun(str12,sweetAlertDialog1,view,viewriddle,r12,pc12,d);

                }
                else{
                    final SweetAlertDialog sweetAlertDialog12 = new SweetAlertDialog(TreasurehuntActivity.this, SweetAlertDialog.ERROR_TYPE);
                    sweetAlertDialog12.setTitleText("Oops...");
                    sweetAlertDialog12.setContentText("This is a FAKE QR!");
                    sweetAlertDialog12.setConfirmButton("Retry", new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            scannerView.resumeCameraPreview(TreasurehuntActivity.this);
                            sweetAlertDialog12.dismiss();
                        }
                    });
                    sweetAlertDialog12.show();
                }


                /*if (result.getText().equalsIgnoreCase(enterpassword.getText().toString())) {
                    final SweetAlertDialog sweetAlertDialog2 = new SweetAlertDialog(TreasurehuntActivity.this, SweetAlertDialog.SUCCESS_TYPE);
                    sweetAlertDialog2.setTitle("Great Job!");
                    sweetAlertDialog2.setContentText("PRESS Done to see next RIDDLE & PASSWORD CRACKER");
                    sweetAlertDialog2.setConfirmButton("Done", new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TreasurehuntActivity.this);
                            builder.setTitle("NEXT QUESTION");
                                /*builder.setMessage("Riddle 4\n" +
                                        "Go to a place where people stand\n" +
                                        "The roads are wide and the vehicles grand\n" +
                                        "This the place where the coaches stop\n" +
                                        "Password Cracker\n" +
                                        "Your Answer has 9 letters with one the letter as “U”. find the other words by filling the table\n" +
                                        "What does the word I stand for in the acronym S.H.I.E.L.D ?\n" +
                                        "What is the name of the Super Soldier project in Captain America: The First Avenger?\n" +
                                        "What alien race does Ronan the Accuser belong to?\n" +
                                        "What virus was Pepper Potts injected with in Iron Man 3?\n" +
                                        "What is the name of star lords mother?\n" +
                                        "which of the infinity stones can alter reality?");*/
                            /*builder.setPositiveButton("Take Screenshot", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Bitmap bitmap_hiddenview = ScreenShott.getInstance().takeScreenShotOfRootView(viewriddle);
                                    try {
                                        file = ScreenShott.getInstance().saveScreenshotToPicturesFolder(getApplicationContext(), bitmap_hiddenview, "my_screenshot_filename");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }


                                    //notification
                                    Intent intent = new Intent(TreasurehuntActivity.this, TreasurehuntActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    PendingIntent pendingIntent = PendingIntent.getActivity(TreasurehuntActivity.this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
                                    Context context = getApplicationContext();
                                    String channelId = getString(R.string.default_notification_channel_id);
                                    NotificationCompat.Builder builder = new NotificationCompat.Builder(TreasurehuntActivity.this, channelId)
                                            .setSmallIcon(R.drawable.notificationicon)
                                            //.setLargeIcon(bitmap)
                                            .setContentTitle("Screenshot Saved")
                                            .setContentText("Open Gallery to see screenshot")
                                            .setDefaults(Notification.DEFAULT_ALL)
                                            .setPriority(Notification.PRIORITY_HIGH);
                                    //.setStyle(new NotificationCompat.BigTextStyle().bigText(body));
                                    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                                    builder.setSound(alarmSound);
                                    builder.setAutoCancel(true);
                                    builder.setContentIntent(pendingIntent);

                                    NotificationManager notificationManager =
                                            (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                        NotificationChannel channel = new NotificationChannel(channelId,
                                                "INFOTSAV",
                                                NotificationManager.IMPORTANCE_HIGH);
                                        notificationManager.createNotificationChannel(channel);
                                        builder.setSmallIcon(R.drawable.notificationicon);
                                    } else {
                                        builder.setSmallIcon(R.drawable.notificationicon);
                                    }
                                    notificationManager.notify(0 , builder.build());
                                    //notification finished
                                }
                            });
                            sweetAlertDialog2.dismiss();
                            riddle.setText("This is the next riddle");
                            cracker.setText("Solve this password cracker");
                            builder.setView(viewriddle);
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                        }
                    });
                    sweetAlertDialog2.show();
                    //riddle.setText("This is the next riddle");
                    //cracker.setText("Solve this password cracker");
                    //Toast.makeText(getApplicationContext(),"Works",Toast.LENGTH_LONG).show();
                    //scannerView.resumeCameraPreview(TreasurehuntActivity.this);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong password re-enter it", Toast.LENGTH_LONG).show();
                    final SweetAlertDialog sweetAlertDialog3 = new SweetAlertDialog(TreasurehuntActivity.this, SweetAlertDialog.ERROR_TYPE);
                    sweetAlertDialog3.setTitle("Oops Wrong Password!!");
                    sweetAlertDialog3.setCancelButton("Retry", new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            sweetAlertDialog3.dismiss();
                            sweetAlertDialog1.show();

                        }
                    });
                    sweetAlertDialog3.show();
                }*/


            }
        });
        sweetAlertDialog1.setCancelable(false);
        sweetAlertDialog1.show();


                /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (result.getText().equals(enterpassword.getText().toString()))
                {
                    riddle.setText("This is the next riddle");
                    cracker.setText("Solve this password cracker");
                    Toast.makeText(getApplicationContext(),"Works",Toast.LENGTH_LONG).show();
                    //scannerView.resumeCameraPreview(TreasurehuntActivity.this);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Wrong password re-enter it",Toast.LENGTH_LONG).show();
                }
                //scannerView.resumeCameraPreview(TreasurehuntActivity.this);
            }
        });
        builder.setView(view);
        AlertDialog dialog=builder.create();
        dialog.show();*/
    }

    public void fun(String result, final SweetAlertDialog sweetAlertDialog1, final View view, final View viewriddle, final String riddletext, final String crackertext, final Drawable drawable) {
        if (result.equalsIgnoreCase(enterpassword.getText().toString())) {
            final SweetAlertDialog sweetAlertDialog2 = new SweetAlertDialog(TreasurehuntActivity.this, SweetAlertDialog.SUCCESS_TYPE);
            sweetAlertDialog2.setTitle("Great Job!");
            sweetAlertDialog2.setContentText("PRESS Done to see next RIDDLE & PASSWORD CRACKER");
            sweetAlertDialog2.setConfirmButton("Done", new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sweetAlertDialog) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(TreasurehuntActivity.this);
                    builder.setTitle("Next Question");
                    Toast.makeText(getApplicationContext(),"Take a SCREENSHOT",Toast.LENGTH_LONG).show();
                                /*builder.setMessage("Riddle 4\n" +
                                        "Go to a place where people stand\n" +
                                        "The roads are wide and the vehicles grand\n" +
                                        "This the place where the coaches stop\n" +
                                        "Password Cracker\n" +
                                        "Your Answer has 9 letters with one the letter as “U”. find the other words by filling the table\n" +
                                        "What does the word I stand for in the acronym S.H.I.E.L.D ?\n" +
                                        "What is the name of the Super Soldier project in Captain America: The First Avenger?\n" +
                                        "What alien race does Ronan the Accuser belong to?\n" +
                                        "What virus was Pepper Potts injected with in Iron Man 3?\n" +
                                        "What is the name of star lords mother?\n" +
                                        "which of the infinity stones can alter reality?");*/
                    builder.setPositiveButton("Press this after taking a SCREENSHOT!!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Bitmap bitmap_hiddenview = ScreenShott.getInstance().takeScreenShotOfRootView(viewriddle);
                            try {
                                file = saveScreenshotToPicturesFolder(getApplicationContext(), bitmap_hiddenview, "my_screenshot_filename");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }


                            //notification
                            Intent intent = new Intent();
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            PendingIntent pendingIntent = PendingIntent.getActivity(TreasurehuntActivity.this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
                            Context context = getApplicationContext();
                            String channelId = getString(R.string.default_notification_channel_id);
                            NotificationCompat.Builder builder = new NotificationCompat.Builder(TreasurehuntActivity.this, channelId)
                                    .setSmallIcon(R.drawable.notificationicon)
                                    //.setLargeIcon(bitmap)
                                    .setContentTitle("Congratulations")
                                    .setContentText("You are one step closer!!")
                                    .setDefaults(Notification.DEFAULT_ALL)
                                    .setPriority(Notification.PRIORITY_HIGH);
                            //.setStyle(new NotificationCompat.BigTextStyle().bigText(body));
                            Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                            builder.setSound(alarmSound);
                            builder.setAutoCancel(true);
                            builder.setContentIntent(pendingIntent);

                            NotificationManager notificationManager =
                                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                NotificationChannel channel = new NotificationChannel(channelId,
                                        "INFOTSAV",
                                        NotificationManager.IMPORTANCE_HIGH);
                                notificationManager.createNotificationChannel(channel);
                                builder.setSmallIcon(R.drawable.notificationicon);
                            } else {
                                builder.setSmallIcon(R.drawable.notificationicon);
                            }
                            notificationManager.notify(0 /* ID of notification */, builder.build());
                            //notification finished
                        }
                    });
                    sweetAlertDialog2.dismiss();
                    riddle.setText(riddletext);
                    cracker.setText(crackertext);
                    image_th.setImageDrawable(drawable);
                    builder.setView(viewriddle);
                    final AlertDialog alertDialog = builder.create();
                    alertDialog.setOnShowListener( new DialogInterface.OnShowListener() {
                        @Override
                        public void onShow(DialogInterface arg0) {
                            alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                            alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(android.R.color.white));
                        }
                    });
                    alertDialog.setCancelable(false);
                    alertDialog.show();
                }
            });
            sweetAlertDialog2.setCancelable(false);
            sweetAlertDialog2.show();
            //riddle.setText("This is the next riddle");
            //cracker.setText("Solve this password cracker");
            //Toast.makeText(getApplicationContext(),"Works",Toast.LENGTH_LONG).show();
            //scannerView.resumeCameraPreview(TreasurehuntActivity.this);
        } else {
            Toast.makeText(getApplicationContext(), "Wrong password re-enter it", Toast.LENGTH_LONG).show();
            final SweetAlertDialog sweetAlertDialog3 = new SweetAlertDialog(TreasurehuntActivity.this, SweetAlertDialog.ERROR_TYPE);
            sweetAlertDialog3.setTitle("Oops Wrong Password!!");
            sweetAlertDialog3.setCancelButton("Retry", new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sweetAlertDialog) {
                    sweetAlertDialog3.dismiss();
                    sweetAlertDialog1.show();

                }
            });
            sweetAlertDialog3.show();
        }
        scannerView.resumeCameraPreview(TreasurehuntActivity.this);

    }

    public File saveScreenshotToPicturesFolder(Context context, Bitmap image, String filename)
            throws Exception {
        File bitmapFile = getOutputMediaFile(filename);
        if (bitmapFile == null) {
            throw new NullPointerException("Error creating media file, check storage permissions!");
        }
        FileOutputStream fos = new FileOutputStream(bitmapFile);
        image.compress(Bitmap.CompressFormat.PNG, 90, fos);
        fos.close();

        // Initiate media scanning to make the image available in gallery apps
        MediaScannerConnection.scanFile(context, new String[] { bitmapFile.getPath() },
                new String[] { "image/jpeg" }, null);
        return bitmapFile;
    }
    private File getOutputMediaFile(String filename) {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.
        File mediaStorageDirectory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/Screenshots" + File.separator);
        // Create the storage directory if it does not exist
        if (!mediaStorageDirectory.exists()) {
            if (!mediaStorageDirectory.mkdirs()) {
                return null;
            }
        }
        // Create a media file name
        String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
        File mediaFile;
        String mImageName = filename + timeStamp + ".jpg";
        mediaFile = new File(mediaStorageDirectory.getPath() + File.separator + mImageName);
        return mediaFile;
    }

}