package com.example.clovercycle;

import static com.example.clovercycle.DatabaseSqlite.KEY_NAME;

<<<<<<< Updated upstream
=======
import static com.example.clovercycle.R.id.nameTxt;
import static com.example.clovercycle.R.id.userName;

import android.annotation.SuppressLint;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    String name, address, amount;
    int result;
=======
    String name, address;

    int amount;
    DatabaseSqlite dbHandler;

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
        dbHandler = new DatabaseSqlite(UserJobActivity.this);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
                amount = amountInput.getText().toString();
=======
                String amountString = amountInput.getText().toString(); //get the text from EditText as a String
                int amountInt = Integer.parseInt(amountString); //parse the String to an int
                amount = Integer.parseInt(String.valueOf(amountInt)); //convert the int back to a String

                // validating if the text fields are empty or not.
                if (name.isEmpty() || address.isEmpty() || amountString.isEmpty()) {
                    Toast.makeText(UserJobActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }
>>>>>>> Stashed changes

                // on below line we are calling a method to add new
                // job to sqlite data and pass all our values to it.
                dbHandler.addNewJob(name, address, String.valueOf(amount));

                // after adding the data we are displaying a toast message.
                Toast.makeText(UserJobActivity.this, "Jobs has been added.", Toast.LENGTH_SHORT).show();
                nameTxt.setText("");
                addressTxt.setText("");
            }
        });
<<<<<<< Updated upstream

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
=======


        Button paymentsBtn;
        paymentsBtn = findViewById(R.id.paymentsBtn);
        paymentsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPaymentsActivity();
            }
        });

    }
>>>>>>> Stashed changes

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