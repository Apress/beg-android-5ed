package com.artifexdigital.android.sqliteexample;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class SQLiteExample extends ListActivity {
    private SQLiteDatabase myDB;
    private MySQLiteHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_example);

        myDBHelper = new MySQLiteHelper(this);
        myDB = myDBHelper.getWritableDatabase();

        displayModels();
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.addNewModel:
                addModel();
                break;
            case R.id.getModelInfo:
                getModelInfo(view);
                break;
        }
    }

    public List<String> getModels() {
        List<String> models = new ArrayList<>();

        Cursor cursor = myDB.query(MySQLiteHelper.TABLE_NAME,
                MySQLiteHelper.TABLE_COLUMNS, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String model = cursor.getString(MySQLiteHelper.COLNO_MODEL_NAME);
            models.add(model);
            cursor.moveToNext();
        }

        cursor.close();
        return models;

    }

    public void displayModels() {
        List<String> modelEntries = getModels();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, modelEntries);
        setListAdapter(adapter);
    }

    public void getModelInfo(View view) {

        Cursor cursor = myDB.rawQuery(
                "select _id, model_name, release_year " +
                        "from devices", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String model = cursor.getString(MySQLiteHelper.COLNO_MODEL_NAME);
            Integer year = cursor.getInt(MySQLiteHelper.COLNO_RELEASE_YEAR);
            Toast.makeText(this, "The " + model +
                    " was released in " + year.toString(),
                    Toast.LENGTH_LONG).show();
            cursor.moveToNext();
        }

        cursor.close();

    }

    private void addModel() {
        LayoutInflater myInflater=LayoutInflater.from(this);
        View addView=myInflater.inflate(R.layout.add_model_edittext, null);
        final DialogWrapper myWrapper=new DialogWrapper(addView);

        new AlertDialog.Builder(this)
                .setTitle(R.string.add_model_title)
                .setView(addView)
                .setPositiveButton(R.string.ok,
                     new DialogInterface.OnClickListener() {
                         public void onClick(DialogInterface dialog,
                                                int whichButton) {
                             insertModelRow(myWrapper);
                         }
                     })
                .setNegativeButton(R.string.cancel,
                     new DialogInterface.OnClickListener() {
                         public void onClick(DialogInterface dialog,
                                                int whichButton) {
                             // Nothing to do here
                         }
                     })
                .show();
    }

    private void insertModelRow(DialogWrapper wrapper) {
        ContentValues myValues=new ContentValues(2);

        myValues.put(MySQLiteHelper.COLNAME_MODEL, wrapper.getModel());
        myValues.put(MySQLiteHelper.COLNAME_YEAR, Calendar.getInstance().get(Calendar.YEAR));

        myDB.insert(MySQLiteHelper.TABLE_NAME, MySQLiteHelper.COLNAME_MODEL, myValues);
        //uncomment if you want inserts to be displayed immediately
        //displayModels();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        myDB.close();
    }

}
