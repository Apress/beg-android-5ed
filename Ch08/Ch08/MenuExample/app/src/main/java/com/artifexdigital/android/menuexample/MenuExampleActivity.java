package com.artifexdigital.android.menuexample;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;


public class MenuExampleActivity extends ListActivity {
    private static final String[] items={"To", "be",
            "or", "not", "to", "be",
            "that", "is", "the", "question"};
    public static final int MENU_RESET = Menu.FIRST+1;
    public static final int MENU_UPPER = Menu.FIRST+2;
    public static final int MENU_REMOVE = Menu.FIRST+3 ;
    private ArrayList<String> words=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_example);
        setupAdapter();
        registerForContextMenu(getListView());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, MENU_RESET, Menu.NONE, "Reset");
        return(super.onCreateOptionsMenu(menu));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,
                                    View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(Menu.NONE, MENU_UPPER, Menu.NONE, "Upper Case");
        menu.add(Menu.NONE, MENU_REMOVE, Menu.NONE, "Remove Word");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_RESET:
                setupAdapter();
                return(true);
        }

        return(super.onOptionsItemSelected(item));
    }

    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo=
                (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        ArrayAdapter<String> adapter=(ArrayAdapter<String>)getListAdapter();

        switch (item.getItemId()) {
            case MENU_UPPER:
                String word=words.get(menuInfo.position);
                word=word.toUpperCase();
                adapter.remove(words.get(menuInfo.position));
                adapter.insert(word, menuInfo.position);
                return(true);

            case MENU_REMOVE:
                adapter.remove(words.get(menuInfo.position));
                return(true);
        }

        return(super.onContextItemSelected(item));
    }

    private void setupAdapter() {
        words=new ArrayList<>();

        for (String someItem : items) {
            words.add(someItem);
        }

        setListAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, words));
    }

}

