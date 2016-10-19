package com.artifiexdigital.android.switchexample;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Switch;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class SwitchExample extends Activity {

	Switch mySwitch;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_example);
        
        mySwitch = (Switch)findViewById(R.id.switchdemo);
        mySwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
        	@Override
        	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        		if (buttonView.isChecked()) {
        			mySwitch.setText("The switch is on");
        		}
        		else
        		{
        			mySwitch.setText("The switch is off");
        		}
        	}
        });
    }
}
