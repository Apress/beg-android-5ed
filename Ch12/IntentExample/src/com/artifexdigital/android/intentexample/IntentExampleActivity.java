package com.artifexdigital.android.intentexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class IntentExampleActivity extends Activity {
	private EditText myContact;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent_example);
	    myContact=(EditText)findViewById(R.id.myContact);
	}

    public void viewContact(View view) {
        String myContactNumber=myContact.getText().toString();
        Uri myUri = Uri.parse("content://contacts/people/"+myContactNumber);
        startActivity(new Intent(Intent.ACTION_VIEW, myUri));
    }
}
