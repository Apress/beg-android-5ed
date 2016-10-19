package com.artifexdigital.android.audioexample;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.view.View;


public class AudioExample extends Activity implements OnPreparedListener {
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_example);
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.startButton:
                doPlayAudio();
                break;
            case R.id.stopButton:
                doStopAudio();
                break;
        }
    }

    private void doPlayAudio() {
        mp = MediaPlayer.create(this, R.raw.audio_file);
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mp.start();
    }

    private void doStopAudio() {
        if (mp != null) {
            mp.stop();
        }
    }

    // The onPrepared callback is for you to implement
    // as part of the OnPreparedListener interface
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mp != null) {
            mp.release();
        }
    }

}
