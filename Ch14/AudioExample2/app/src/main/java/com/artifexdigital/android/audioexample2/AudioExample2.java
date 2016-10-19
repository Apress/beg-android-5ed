package com.artifexdigital.android.audioexample2;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class AudioExample2 extends Activity implements OnPreparedListener {
    // useful for debugging
    // String mySourceFile=
    //    "https://ia801400.us.archive.org/2/items/rhapblue11924/rhapblue11924_64kb.mp3";
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_example2);
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.startButton:
                try {
                    EditText mySourceFile=(EditText)findViewById(R.id.sourceFile);
                    doPlayAudio(mySourceFile.toString());
                } catch (Exception e) {
                    // error handling logic here
                }
                break;
            case R.id.stopButton:
                doStopAudio();
                break;
        }
    }

    private void doPlayAudio(String audioUrl) throws Exception {
        mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mp.setDataSource(audioUrl);
        mp.setOnPreparedListener(this);
        mp.prepareAsync();
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
