package com.artifexdigital.android.tabbedactionbarexample;

import android.app.Activity;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;


public class TabbedActionBar extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
    setContentView(R.layout.activity_tabbed_action_bar);

    ActionBar tabbed = getActionBar();
    tabbed.setTitle("Tabbed ActionBar");
    tabbed.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
    CustomTabListener tabl = new CustomTabListener();
    Tab tab1 = tabbed.newTab();
    tab1.setText("Tab One");
    tab1.setTabListener(tabl);
    tabbed.addTab(tab1);
    Tab tab2 = tabbed.newTab();
    tab2.setText("Tab One");
    tab2.setTabListener(tabl);
    tabbed.addTab(tab2);
  }

  
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.tabbed_action_bar, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
