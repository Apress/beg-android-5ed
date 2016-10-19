package com.artifexdigital.android.spinnerexample;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Activity;

public class SpinnerExample extends Activity 
    implements AdapterView.OnItemSelectedListener {
    private TextView mySelection;
    private static final String[] myListItems={"To", "be",
    	"or", "not", "to", "be",
    	"that", "is", "the", "question"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_example);
        
        mySelection=(TextView)findViewById(R.id.mySelection);
        
        Spinner spin=(Spinner)findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        
        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(this,
                                 android.R.layout.simple_spinner_item,
                                 myListItems);
        
        myAdapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(myAdapter);
    }
      
    public void onItemSelected(AdapterView<?> parent,
        View v, int position, long id) {
        mySelection.setText(myListItems[position]);
    }
      
    public void onNothingSelected(AdapterView<?> parent) {
        mySelection.setText("");
    }

}
