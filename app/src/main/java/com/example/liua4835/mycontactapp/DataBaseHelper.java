package com.example.liua4835.mycontactapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper  extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Contact2018.db";
    public static final String TABLE_NAME = "Contact2018_Table";
    public static final String ID = "ID";
    public static final String PHONE = "PhoneNumber";
    public static final String ADDRESS = "ContactAddress";

    public static final String COLUMN_NAME_CONTACT = "ContactName";
    public static final String COLUMN_NUMBER_CONTACT = "ContactNumber";
    public static final String COLUMN_ADDRESS_CONTACT = "ContactAddress";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NAME_CONTACT + " TEXT)" + " (" +
                        PHONE + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NUMBER_CONTACT + " TEXT)" + " (" +
                    ADDRESS + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_ADDRESS_CONTACT + " TEXT)";

    public static final String SQUL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase(); //for initial test of db creation
        Log.d("MyContactApp", "DataBaseHelper:  constructed DataBaseHelper");
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        Log.d("MyContactApp", "DataBaseHelper:  creating database");
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("MyContactApp", "DataBaseHelper:  upgrading database");
        db.execSQL(SQUL_DELETE_ENTRIES);
        onCreate(db);
    }

    public boolean insertData(String name, String number, String address){
        Log.d("MyContactApp", "DataBaseHelper:  inserting data");
        SQLiteDatabase db = this.getWritableDatabase();
        android.content.ContentValues contentValue = new android.content.ContentValues();
        contentValue.put(COLUMN_NAME_CONTACT, name);
        contentValue.put(COLUMN_NUMBER_CONTACT, number);
        contentValue.put(COLUMN_ADDRESS_CONTACT, address);


        long result = db.insert(TABLE_NAME,null,contentValue);
        if(result == -1){
            Log.d("MyContactApp", "DataBaseHelper: Contact insert = FAILED");
            return false;
        }
        else{
            Log.d("MyContactApp", "DataBaseHelper: Contact insert = PASSED");
            return true;
        }

    }


}



