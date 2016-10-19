package com.artifexdigital.android.externallibraryexample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;

//importing the IOUtils external library for use
import org.apache.commons.io.*;


public class ExternalLibraryExample extends Activity {
    public final static String FILENAME="ExternalLibraryExample.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_library_example);
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
                // File I/O using the much more elegant Apache IOUtils approach

                StringWriter myWriter = new StringWriter();
                IOUtils.copy(inStrm, myWriter);
                String fileContent = myWriter.toString();

                inStrm.close();
                readField.setText(fileContent);
            }

        }
        catch (Throwable t) {
            // perform exception handling here
        }
    }

    // Code continues unchanged from here

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
