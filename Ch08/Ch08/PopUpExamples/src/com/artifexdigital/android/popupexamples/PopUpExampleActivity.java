package com.artifexdigital.android.popupexamples;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PopUpExampleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pop_up_example);
	}

	public void showAlertDialog(View view) {
		new AlertDialog.Builder(this)
		.setTitle("AlertDialog Exmaple")
		.setMessage("This is the example AlertDialog.  Press the button to see the Toast notification")
		.setPositiveButton("Show Toast", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(PopUpExampleActivity.this, "The Toast Message", Toast.LENGTH_LONG)
				.show();
				
			}
		}).show();
	}

}
