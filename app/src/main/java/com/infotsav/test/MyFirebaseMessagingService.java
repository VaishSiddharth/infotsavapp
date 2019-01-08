package com.infotsav.test;

import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

import static android.support.constraint.Constraints.TAG;

        public class MyFirebaseMessagingService  extends FirebaseMessagingService {
            @Override
            public void onMessageReceived(RemoteMessage remoteMessage) {
                super.onMessageReceived(remoteMessage);
                Log.e(TAG, "The message received is " + remoteMessage);
                showNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody(), remoteMessage.getData());
            }

            private void showNotification(String title, String body, Map<String, String> data) {
                Context context = getApplicationContext();
                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(context)
                                .setSmallIcon(R.drawable.callbutton)
                                //.setLargeIcon(bitmap)
                                .setContentTitle(title)
                                .setContentText(body)
                                .setStyle(new NotificationCompat.BigTextStyle()
                                        .bigText(body));
                Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                builder.setSound(alarmSound);
                builder.setAutoCancel(true);
    }
}
