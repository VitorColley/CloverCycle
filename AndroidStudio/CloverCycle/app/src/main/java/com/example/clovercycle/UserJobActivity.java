package com.example.clovercycle;

import static com.example.clovercycle.DatabaseSqlite.KEY_NAME;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserJobActivity extends AppCompatActivity {

    TextView nameTxt;
    TextView addressTxt;
    EditText amountInput;
    Button jobBtn;
    Button menuBtn;
    String name, address, amount;
    int result;
    DatabaseSqlite dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_job);
        //initiate the database
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

        jobBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve values from EditText fields
                name = nameTxt.getText().toString();
                address = addressTxt.getText().toString();
                amount = amountInput.getText().toString();

                // Call postJob method to insert data into database
                postJob();
            }
        });

    }

    private void postJob() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues jobs = new ContentValues();

        // inset data as we wish
        jobs.put("name", name);
        jobs.put("address", address);
        jobs.put("amount", amount);

        db.insert("users", null, jobs);

        db.close();
        //if result is not -1, this indicates a successful inserstion and will display toast message
        if (result != -1) {
            //data insertion was successful
            //toast is a android studio utility that allows to show messages
            showToast("Job posted successfully");
        } else {
            //data insertion failed
            showToast("Failed to post job");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void logoutActivity() {
        Intent intent1 = new Intent(this, MainActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent1);
        finish();
    }


}