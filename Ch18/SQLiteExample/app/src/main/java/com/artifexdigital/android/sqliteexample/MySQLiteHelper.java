package com.artifexdigital.android.sqliteexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME="devices";
    public static final int COLNO__ID = 0;
    public static final int COLNO_MODEL_NAME = 1;
    public static final int COLNO_RELEASE_YEAR = 2;
    public static final String COLNAME__ID = "_id";
    public static final String COLNAME_MODEL = "model_name";
    public static final String COLNAME_YEAR = "release_year";

    public static final String[] TABLE_COLUMNS =
            new String[]{COLNAME__ID,COLNAME_MODEL,COLNAME_YEAR};

    private static final String DBFILENAME="devices.db";
    private static final int DBVERSION = 1;

    //Note that for the following two SQL Strings, normally use the Strings
    //declared above to avoid typos etc.  These are presented as text here
    //for readability's sake in this example
    private static final String INITIAL_SCHEMA=
            "create table devices (" +
                    "_id integer primary key autoincrement," +
                    "model_name varchar(100) not null," +
                    "release_year integer not null" +
                    ")";
    private static final String INITIAL_DATA_INSERT=
            "insert into devices (model_name, release_year) values " +
                    "('LG Nexus 4', 2012)," +
                    "('LG Nexus 5', 2013)," +
                    "('Samsung Galaxy S6', 2015)";

    public MySQLiteHelper(Context context) {
        super(context, DBFILENAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(INITIAL_SCHEMA);
        db.execSQL(INITIAL_DATA_INSERT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // perform upgrade logic here
        // This can get quite complex
        if (oldVersion==1) {
            // do upgrade logic to new version
        }
        // and so on
    }

}
