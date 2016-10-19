package com.artifexdigital.android.firstagain;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class FirstAgainActivity extends Activity implements View.OnClickListener {
	Button myButton;
	Integer myInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_again);
        myButton=(Button)findViewById(R.id.button);
        myButton.setOnClickListener(this);
        myInt = 0;        
        updateClickCounter();
    }
    
    public void onClick(View view) {
    	updateClickCounter();
    }

    private void updateClickCounter() {
    	myInt++;
    	myButton.setText(myInt.toString());
    }
}
