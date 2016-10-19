package com.artifexdigital.android.fragmentpreferencesexample;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class FragmentPreferencesExample extends ActionBarActivity {
    private TextView checkbox1=null;
    private TextView checkbox2=null;
    private TextView checkbox3=null;
    private TextView ringtone=null;
    private TextView text=null;
    private TextView list=null;
    private TextView mySwitch=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_preferences_example);

        checkbox1=(TextView)findViewById(R.id.checkbox1);
        checkbox2=(TextView)findViewById(R.id.checkbox2);
        checkbox3=(TextView)findViewById(R.id.checkbox3);
        ringtone=(TextView)findViewById(R.id.ringtone);
        text=(TextView)findViewById(R.id.text);
        list=(TextView)findViewById(R.id.list);
        mySwitch=(TextView)findViewById(R.id.myswitch);
    }

   @Override
    public void onResume() {
        super.onResume();

        SharedPreferences myPrefs =
            PreferenceManager.getDefaultSharedPreferences(this);

        checkbox1.setText(new Boolean(myPrefs.getBoolean("checkbox1", false))
                 .toString());
        checkbox2.setText(new Boolean(myPrefs.getBoolean("checkbox2", false))
                 .toString());
        checkbox3.setText(new Boolean(myPrefs.getBoolean("checkbox3", false))
                 .toString());
        ringtone.setText(myPrefs.getString("ringtone", "?"));
        text.setText(myPrefs.getString("text", "?"));
        list.setText(myPrefs.getString("list", "?"));
        mySwitch.setText(new Boolean(myPrefs.getBoolean("switch", false))
                 .toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_fragment_preferences_example, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.change_preferences) {
            startActivity(new Intent(this, ChangePreferences.class));
            return true;
        }

        if (id == R.id.action_settings) {
            // We could invoke other preference changes here if desired
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
