package com.artifexdigital.android.autoexample;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.app.Activity;

public class AutoExample extends Activity implements TextWatcher {
    private TextView mySelection;
    private AutoCompleteTextView myEdit;
    private static final String[] myListItems={"To", "be",
    	"or", "not", "to", "be",
    	"that", "is", "the", "question"};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_example);
        mySelection=(TextView)findViewById(R.id.mySelection);
        myEdit=(AutoCompleteTextView)findViewById(R.id.edit);
        myEdit.addTextChangedListener(this);
        
        myEdit.setAdapter(new ArrayAdapter<String>(this,
                             android.R.layout.simple_dropdown_item_1line,
                             myListItems));
      }
      
      public void onTextChanged(CharSequence s, int start, int before,
                                 int count) {
        mySelection.setText(myEdit.getText());
      }
      
      public void beforeTextChanged(CharSequence s, int start,
                                     int count, int after) {
        // no-op
      }
      
      public void afterTextChanged(Editable s) {
        // no-op
      }
    
}
