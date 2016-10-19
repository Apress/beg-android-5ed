package com.artifexdigital.android.listviewexample;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewExample extends ListActivity {
    private TextView mySelection;
    private static final String[] myListItems={"To", "be",
    	"or", "not", "to", "be",
    	"that", "is", "the", "question"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_example);
        
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                myListItems));
        mySelection=(TextView)findViewById(R.id.mySelection);
    }
    
    public void onListItemClick(ListView parent, View v, int position,
            long id) {
    mySelection.setText(myListItems[position]);
    }

}
