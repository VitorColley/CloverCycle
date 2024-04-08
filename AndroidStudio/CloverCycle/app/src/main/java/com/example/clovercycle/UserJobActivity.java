package com.example.clovercycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserJobActivity extends AppCompatActivity {

    TextView nameTxt;
    TextView addressTxt;
    EditText amountInput;
    Button jobBtn;
    Button menuBtn;
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


        //create event listener
        menuBtn = (Button) findViewById(R.id.menuBtn);
        menuBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                logoutActivity();
            }
        });
    }
            public void logoutActivity() {
                Intent intent1 = new Intent(this, MainActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent1);
                finish();
            }
        }