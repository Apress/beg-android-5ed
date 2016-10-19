package com.artifexdigital.android.gridviewexample;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class GridViewExample extends Activity
    implements AdapterView.OnItemSelectedListener  {
    private TextView mySelection;
    private static final String[] myListItems={"To", "be",
    	"or", "not", "to", "be",
    	"that", "is", "the", "question"};

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_example);

        GridView myGrid=(GridView) findViewById(R.id.grid);
        myGrid.setAdapter(new ArrayAdapter<String>(this,
                          R.layout.cell,
                          myListItems));
        myGrid.setOnItemSelectedListener(this);
  }
  
  public void onItemSelected(AdapterView<?> parent, View v,
                             int position, long id) {
    mySelection.setText(myListItems[position]);
  }
  
  public void onNothingSelected(AdapterView<?> parent) {
    //no-op
  }

}
