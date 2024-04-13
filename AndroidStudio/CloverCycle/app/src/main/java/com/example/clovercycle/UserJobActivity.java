package com.example.clovercycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class UserJobActivity extends AppCompatActivity {

    TextView nameTxt;
    TextView addressTxt;
    EditText amountInput;
    Button jobBtn;
    Button menuBtn;
    Button myjobs;
    String name, address, amount;

    DatabaseSqlite dbHandler;
    DatabaseSqlite dbHelper;
    SharedPreferences  sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_job);
        sharedPreferences = getSharedPreferences("userTableID", MODE_PRIVATE);
        //initiate the database
        dbHelper = new DatabaseSqlite(this);
        //find nameTxt, addressTxt, and Button
        nameTxt = findViewById(R.id.nameTxt);
        addressTxt = findViewById(R.id.addressTxt);
        amountInput = findViewById(R.id.amountInput);
        jobBtn = findViewById(R.id.jobBtn);
        //create event listener
        menuBtn = (Button) findViewById(R.id.menuBtn);
        myjobs = (Button) findViewById(R.id.myjobs);


        dbHandler = new DatabaseSqlite(UserJobActivity.this);
        //event listener for my jobs btn
        myjobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                myJobActivity();

            }
            });
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutActivity();
            }
        });
        jobBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //https://www.geeksforgeeks.org/how-to-read-data-from-sqlite-database-in-android/
                // Retrieve values from EditText fields
                name = nameTxt.getText().toString();
                address = addressTxt.getText().toString();
                amount = amountInput.getText().toString();
                //explained in main activity
                int userId = sharedPreferences.getInt("userTableID", -1);
                String amountString = amountInput.getText().toString(); //get the text from EditText as a String
                int amountInt = Integer.parseInt(amountString); //parse the String to an int
                amount = String.valueOf(Integer.parseInt(String.valueOf(amountInt))); //convert the int back to a String

                // validating if the text fields are empty or not.
                if (name.isEmpty() || address.isEmpty() || amountString.isEmpty()) {
                    Toast.makeText(UserJobActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }


                // on below line we are calling a method to add new
                // job to sqlite data and pass all our values to it.
                dbHandler.addNewJob(name, address, amount, userId);

                // after adding the data we are displaying a toast message.
                Toast.makeText(UserJobActivity.this, "Jobs has been added.", Toast.LENGTH_SHORT).show();
                Log.d("UserJobActivity", "New Job Added  " + name + ", Address  " + address + ", Amount" + amount + ", userID "+ userId);
                nameTxt.setText("");
                addressTxt.setText("");
                amountInput.setText("");
            }
        });

        Button paymentsBtn;
        paymentsBtn = findViewById(R.id.paymentsBtn);
        paymentsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPaymentsActivity();
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public void myJobActivity(){
        Intent intent2 = new Intent(this, ViewJobs.class);
        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent2);
        finish();
    }

    public void logoutActivity() {
        Intent intent1 = new Intent(this, MainActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent1);
        finish();
    }

    private void goToPaymentsActivity() {
        Intent intent = new Intent(UserJobActivity.this, PaymentActivity.class);
        startActivity(intent);
    }


}