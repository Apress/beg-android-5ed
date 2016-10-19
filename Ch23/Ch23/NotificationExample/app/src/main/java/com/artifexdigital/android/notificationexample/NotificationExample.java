package com.artifexdigital.android.notificationexample;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


public class NotificationExample extends Activity {
    private static final int NOTIFICATION_ID=12345;
    private int notifyCount = 0;
    private NotificationManager myNotifyMgr = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_example);
        myNotifyMgr = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.notify:
                raiseNotification(view);
                break;
            case R.id.clearNotify:
                dismissNotificaiton(view);
                break;
        }
    }

    public void raiseNotification(View view) {
        Notification myNotification = new Notification(
                                              R.drawable.wavinghand,
                                              "Notice This",
                                              System.currentTimeMillis());
        PendingIntent myPendingI = PendingIntent.getActivity(this, 0,
                new Intent(this, NotificationFollowon.class), 0);

        myNotification.setLatestEventInfo(this, "Title", "Notification contents", myPendingI);

        myNotification.sound = Uri.parse("android.resource://" +
                                         getPackageName() +
                                         "/" +
                                         R.raw.pop);
        myNotification.vibrate=new long[] {1000L, 500L, 1000L, 500L, 1000L};
        myNotification.number=++notifyCount;
        myNotification.flags|=Notification.FLAG_AUTO_CANCEL;

        myNotifyMgr.notify(NOTIFICATION_ID,myNotification);
    }

    public void dismissNotificaiton(View view) {
        myNotifyMgr.cancel(NOTIFICATION_ID);
    }
}
