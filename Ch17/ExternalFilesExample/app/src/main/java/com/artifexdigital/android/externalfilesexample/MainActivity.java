package com.artifexdigital.android.externalfilesexample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends Activity {
    public final static String FILENAME="ExternalFilesExample.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnRead:
                try {
                    doReadFromFile();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnSave:
                doSaveToFile();
                break;
        }
    }

    public void doReadFromFile() throws Exception {
        doHideKeyboard();
        EditText readField;
        readField=(EditText)findViewById(R.id.editTextRead);
        try {
            InputStream inStrm=openFileInput(FILENAME);
            if (inStrm!=null) {
                // We will use the traditional Java I/O streams and builders.
                // This is cumbersome, and we'll return with a better version
                // in chapter 20 using the IOUtils external library

                InputStreamReader inStrmRdr=new InputStreamReader(inStrm);
                BufferedReader buffRdr=new BufferedReader(inStrmRdr);
                String fileContent;
                StringBuilder strBldr=new StringBuilder();

                while ((fileContent=buffRdr.readLine())!=null) {
                    strBldr.append(fileContent);
                }
                inStrm.close();
                readField.setText(strBldr.toString());
            }

        }
        catch (Throwable t) {
            // perform exception handling here
        }
    }

    public void doSaveToFile() {
        doHideKeyboard();
        EditText saveField;
        saveField=(EditText)findViewById(R.id.editText);
        try {
            OutputStreamWriter outStrm=
                new OutputStreamWriter(openFileOutput
                    (FILENAME, Context.MODE_PRIVATE));
            try {
                outStrm.write(saveField.getText().toString());
            }
            catch (IOException i) {
                i.printStackTrace();
            }
            outStrm.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doHideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager myIMM=(InputMethodManager)
                this.getSystemService(Context.INPUT_METHOD_SERVICE);
            myIMM.hideSoftInputFromWindow
                (view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

}
