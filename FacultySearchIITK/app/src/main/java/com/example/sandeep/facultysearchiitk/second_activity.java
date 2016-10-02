package com.example.sandeep.facultysearchiitk;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;



import static com.example.sandeep.facultysearchiitk.R.array.dept;

/**
 * Created by Sandeep on 10/2/2016.
 */
//String bet;


public class second_activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondlayout);
//        Intent intent = getIntent();
        String bet = getIntent().getStringExtra("One");
//
        EditText txt= (EditText)findViewById(R.id.edit);
       txt.setText(bet);
    }
}
