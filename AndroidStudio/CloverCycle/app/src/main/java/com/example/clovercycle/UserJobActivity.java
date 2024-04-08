package com.example.clovercycle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserJobActivity extends AppCompatActivity {

    TextView nameTxt;
    TextView addressTxt;
    EditText amountInput;
    Button jobBtn;
    DatabaseSqlite dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_job);
        dbHelper = new DatabaseSqlite(this);
        //find nameTxt, addressTxt, and Button
        nameTxt = findViewById(R.id.nameTxt);
        addressTxt = findViewById(R.id.addressTxt);
        amountInput = findViewById(R.id.amountInput);
        jobBtn = findViewById(R.id.jobBtn);


        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String address = intent.getStringExtra("address");

        //display user data in TextViews
        nameTxt.setText(userName);
        addressTxt.setText(address);

    }

}
