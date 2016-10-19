package com.artifexdigital.android.audioexample3;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import java.io.File;


public class AudioExample3 extends Activity {
    private MediaRecorder mr;
    private MediaPlayer mp;
    private String myRecording="myAudioRecording";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_example3);
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.startRecordingButton:
                doStartRecording();
                break;
            case R.id.stopRecordingButton:
                doStopRecording();
                break;
            case R.id.startButton:
                doPlayAudio();
                break;
            case R.id.stopButton:
                doStopAudio();
                break;
        }
    }

    private void doStartRecording() {
        File recFile = new File(myRecording);
        if(recFile.exists()) {
            try {
                recFile.delete();
            } catch (Exception e) {
                // do exception handling here
            }
        }

        mr = new MediaRecorder();
        mr.setAudioSource(MediaRecorder.AudioSource.MIC);
        mr.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
        mr.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        mr.setOutputFile(myRecording);
        try {
            mr.prepare();
        } catch (Exception e) {
            // do exception handling here
        }
        mr.start();
    }

    private void doStopRecording() {
        if (mr != null) {
            mr.stop();
        }
    }

    private void doPlayAudio() {
        mp = new MediaPlayer();
        try {
            mp.setDataSource(myRecording);
        } catch (Exception e) {
            // do exception handling here
        }
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mp.prepare();
        } catch (Exception e) {
            // do exception handling here
        }
        mp.start();
    }

    private void doStopAudio() {
        if (mp != null) {
            mp.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mp != null) {
            mp.release();
        }
    }

}
