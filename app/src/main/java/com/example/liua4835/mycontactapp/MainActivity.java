package com.example.liua4835.mycontactapp;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper myDb;
    EditText editName;
    EditText editPhone;
    EditText editAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editText_name);
        editPhone = findViewById(R.id.editText_Phone);
        editAddress = findViewById(R.id.editText_Address);

        myDb = new DataBaseHelper(this);
        Log.d("MyContactApp", "DataBaseHelper:  instantiated database");
    }

    public void addData(View view){
        Log.d("MyContactApp", "MainActivity: Add contact button pressed");

        boolean isInserted = myDb.insertData(editName.getText().toString(),editPhone.getText().toString(),editAddress.getText().toString());

        if(isInserted == true){
            Toast.makeText(MainActivity.this,"Success - contact inserted", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MainActivity.this,"Failed - contact NOT inserted", Toast.LENGTH_LONG).show();

        }

    }
    public void viewData(View view){
        Cursor res = myDb.getAllData();
        Log.d("MyContactApp", "MainActivity: viewData: received cursor" + res.getCount());
        if(res.getCount() == 0){
            showMessage("Error", "No data found in database");
        }

        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            //Append the res column 0, 1, 2, 3

        }
        Log.d("MyContactApp", "MainActivity: viewData: assembled stringBuffer");
        showMessage("Data", buffer.toString());

    }

    public void showMessage(String title, String message) {
        Log.d("MyContactApp", "MainActivity: showMessage: building alert dialog");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
