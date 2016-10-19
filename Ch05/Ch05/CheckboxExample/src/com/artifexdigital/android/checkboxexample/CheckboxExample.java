package com.artifexdigital.android.checkboxexample;

import android.os.Bundle;
import android.app.Activity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class CheckboxExample extends Activity {

	CheckBox myCheckbox;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox_example);
        
        myCheckbox = (CheckBox)findViewById(R.id.check);
        myCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
        	@Override
        	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        		if (buttonView.isChecked()) {
        			myCheckbox.setText("The checkbox is checked");
        		}
        		else
        		{
        			myCheckbox.setText("The checkbox is unchecked");
        		}
        	}
        });
    }
}
