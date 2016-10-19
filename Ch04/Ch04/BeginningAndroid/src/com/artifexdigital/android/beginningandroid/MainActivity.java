package com.artifexdigital.android.beginningandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
    Button myButton;
    Integer myInt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myButton = new Button(this);
        myButton.setOnClickListener(this);
        myInt = 0;
        updateClickCounter();
        setContentView(myButton);
    }

    public void onClick(View view) {
        updateClickCounter();
    }

    private void updateClickCounter() {
        myInt++;
        myButton.setText(myInt.toString());
    }
}