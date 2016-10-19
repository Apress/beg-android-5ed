package com.artifexdigital.com.phonecallexample;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;


public class PhoneCallExample extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone_call_example);
	}

    public void callWithActionDialIntent(View view) {
    	EditText targetNumber=(EditText)findViewById(R.id.phonenumber);
    	String dialThisNumber="tel:"+targetNumber.getText().toString();
    	startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dialThisNumber)));
    }
    
    public void callWithActionCallIntent(View view) {
    	//
    	
    }
    
}
