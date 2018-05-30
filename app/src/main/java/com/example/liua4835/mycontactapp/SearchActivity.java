package com.example.liua4835.mycontactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //get the intent that initiated this activity
        Intent intent = getIntent();
        String message = intent .getStringExtra(MainActivity.EXTRA_MESSAGE);
        String number = intent .getStringExtra(MainActivity.EXTRA_NUMBER);
        String email = intent .getStringExtra(MainActivity.EXTRA_EMAIL);

        //Capture the layout's textView and set the string as the text
        TextView textView = findViewById(R.id.textView4);
        textView.setText(message);


        //Capture the layout's textView and set the string as the text
        TextView textView2 = findViewById(R.id.textView5);
        textView2.setText(number);
        //textView2.setText(number);


        //Capture the layout's textView and set the string as the text
        TextView textView3 = findViewById(R.id.textView6);
        textView3.setText(email);
    }
}
