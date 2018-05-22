package com.example.liua4835.mycontactapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public abstract class DataBaseHelper  extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Contact2018.db";
    public static final String TABLE_NAME = "Contact2018_Table";
    public static final String ID = "ID";

    public static final String COLUMN_NAME_CONTACT = "Contact";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NAME_CONTACT + " TEXT)";

    public static final String SQUL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTE " + TABLE_NAME;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase(); //for initial test of db creation
        Log.d("MyContactApp", "Databasehelper:  constructed Databasehelper");
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        Log.d("MyContactApp", "Databasehelper:  creating database");
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db){
        Log.d("MyContactApp", "Databasehelper:  upgrading database");
        db.execSQL(SQUL_DELETE_ENTRIES);
        onCreate(db);
    }


}



