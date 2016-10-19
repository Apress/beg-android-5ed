package com.artifexdigital.android.edittextexample;

import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;;

public class EditTextExample extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_example);
        
        EditText myfield=(EditText)findViewById(R.id.myfield);
        myfield.setText("Veni, Vidi, Vici");
    }
   
}
