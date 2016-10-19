package com.artifexdigital.android.downloadmanagerexample;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class DownloadManagerExample extends ActionBarActivity {
    private DownloadManager myDLManager = null;
    Uri myUri = Uri.parse("https://ia801400.us.archive.org/2/items/" +
                          "rhapblue11924/rhapblue11924_64kb.mp3");
    private long downloadTarget = -1L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_manager_example);

        myDLManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        registerReceiver(onDownloaded,
                new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.startDownload:
                if (downloadTarget != -1L) {
                    // Consider logic here for simultaneous downloads
                    // But for now we will keep it simple
                }
                else {
                    startDownload(view);
                }
                break;
            case R.id.viewDownloads:
                viewDownloads(view);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(onDownloaded);
    }

    public void startDownload(View view) {

        downloadTarget = myDLManager.enqueue(new DownloadManager.Request(myUri)
                        .setAllowedNetworkTypes
                            (DownloadManager.Request.NETWORK_MOBILE |
                             DownloadManager.Request.NETWORK_WIFI )
                        .setTitle("Amazing Tunes")
                        .setDescription("Rhapsody in Blue")
                        .setDestinationInExternalPublicDir(
                                Environment.DIRECTORY_DOWNLOADS,
                                "rhapsody.mp4"));

        //Disable the Start Download button until current download ends
        Button myStartButton=(Button)findViewById(R.id.startDownload);
        myStartButton.setText("Downloading...");
        myStartButton.setEnabled(false);
    }

    public void viewDownloads(View view) {
        startActivity(new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS));
    }

    BroadcastReceiver onDownloaded =new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            //return Start Button to enabled state
            Button myStartButton=(Button)findViewById(R.id.startDownload);
            myStartButton.setText("Start Download");
            myStartButton.setEnabled(true);
        }
    };

}
