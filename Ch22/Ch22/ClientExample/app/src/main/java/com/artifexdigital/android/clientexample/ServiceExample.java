package com.artifexdigital.android.clientexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class ServiceExample extends Service {
    public static final String EXTRA_ALBUM="EXTRA_ALBUM";
    private boolean isShared=false;

    @Override
    public IBinder onBind(Intent intent) {
        // We need to implement onBind as a Service subclass
        // In this case we do not actually need it, so can simply return
        return(null);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String album=intent.getStringExtra(EXTRA_ALBUM);
        startSharing(album);
        return(START_NOT_STICKY);
    }

    @Override
    public void onDestroy() {
        stopSharing(); }

    private void startSharing(String album) {
        if(!isShared) {
            // Simplified logic - you might have much more going on here
            Log.w(getClass().getName(), "Album successfully shared");
            isShared=true;
        }
    }

    private void stopSharing() {
        if(isShared) {
            // Simplified logic - you might have much more going on here
            Log.w(getClass().getName(), "Album sharing removed");
            isShared=false;
        }
    }


}
