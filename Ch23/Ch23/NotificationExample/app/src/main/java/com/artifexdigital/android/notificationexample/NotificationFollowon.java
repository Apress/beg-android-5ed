package com.artifexdigital.android.notificationexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationFollowon extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView myNotificationFollowon=new TextView(this);

        myNotificationFollowon.setText("Your message here");
        setContentView(myNotificationFollowon);
    }
}
