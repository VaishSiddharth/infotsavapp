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
import android.hardware.Camera;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;
import com.infotsav.test.CardViewLib.MainActivity;
import com.infotsav.test.R;

import java.io.File;

import cn.pedant.SweetAlert.SweetAlertDialog;
import github.nisrulz.screenshott.ScreenShott;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission.CAMERA;

public class TreasurehuntActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private static final int REQUEST_CAMERA = 1;
    private ZXingScannerView scannerView;
    File file;
    private static int camId = Camera.CameraInfo.CAMERA_FACING_BACK;

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
        final String myResult = result.getText();
        final View view = getLayoutInflater().inflate(R.layout.activity_treasurehunt, null);
        final View viewriddle = getLayoutInflater().inflate(R.layout.treasurehunt_riddle_layout, null);
        String str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12;
        str1 = "World war II";
        str2 = "Sokovia accord";
        str3 = "Sakaar";
        str5 = "Mjolnir";
        str6 = "Johann Schmidh";
        str7 = "Cosmo";
        str9 = "Star Lord";
        str10 = "42";
        str11 = "Jotunheim";
        str4 = "vibranium";
        str8 = "levitation";
        str12 = "carter";
        final TextView riddle, cracker;
        final EditText enterpassword;
        riddle = viewriddle.findViewById(R.id.riddle);
        cracker = viewriddle.findViewById(R.id.passwordcracker);
        enterpassword = view.findViewById(R.id.enterpassword);
        Log.d("QRCodeScanner", result.getText());
        Log.d("QRCodeScanner", result.getBarcodeFormat().toString());


        final SweetAlertDialog sweetAlertDialog1 = new SweetAlertDialog(TreasurehuntActivity.this, SweetAlertDialog.NORMAL_TYPE);
        // .setTitleText("Send a one-time message (25 pts)?")
        sweetAlertDialog1.setCustomView(view);
        sweetAlertDialog1.setConfirmButton("Sure", new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog1.dismiss();
                String resultvar=result.getText();
                //if(resultvar.equalsIgnoreCase("1"))
                {
                    if (result.getText().equalsIgnoreCase(enterpassword.getText().toString())) {
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
                                builder.setPositiveButton("Take Screenshot", new DialogInterface.OnClickListener() {
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
                                        notificationManager.notify(0 /* ID of notification */, builder.build());
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
                    }
                }

            }
        });
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
}