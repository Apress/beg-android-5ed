package com.artifexdigital.android.seekbarexample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;


public class SeekBarExample extends ActionBarActivity {

    private SeekBar seekBar;
    private TextView seekBarVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar_example);

        seekBar = (SeekBar) findViewById(R.id.mySeekBar);
        seekBarVal = (TextView) findViewById(R.id.mySeekBarValue);

        // Set display value for the TextView based on SeekBar value
        seekBarVal.setText("" + seekBar.getProgress());

        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // any logic for notifying user a change is detected, e.g. a Toast
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // on detecting the user has ceased adjusting the SeekBar, update the display val
                seekBarVal.setText("" + progress);
            }
        });
    }

}
