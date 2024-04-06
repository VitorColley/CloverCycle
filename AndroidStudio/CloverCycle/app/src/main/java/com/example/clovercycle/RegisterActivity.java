package com.example.clovercycle;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText userNameInput;
    EditText passwordInput;
    EditText addressInput;
    EditText emailInput;
    Button registerButton;
    RadioButton userRb = findViewById(R.id.userRb);
    RadioButton collectorRb = findViewById(R.id.collectorRb);

    String userName, password, address, email, passValidation;


    // Declare DatabaseSqlite dbHelper
    DatabaseSqlite dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // we initiate the database
        dbHelper = new DatabaseSqlite(getApplicationContext());

        // well call those buttons and address their variables
        userNameInput = findViewById(R.id.userNameInputTf);
        passwordInput = findViewById(R.id.passwordInputTf);
        addressInput = findViewById(R.id.addressInputTf);
        emailInput = findViewById(R.id.emailInputTf);
        registerButton = findViewById(R.id.registerButtonBtn);

        // set click listener for registration button (make sure to get all variables named properly for buttons)
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get registration data from EditText fields that we created on xml
                userName = userNameInput.getText().toString();
                password = passwordInput.getText().toString();
                address = addressInput.getText().toString();
                email = emailInput.getText().toString();

                // call method to handle registration
                if(userRb.isChecked()){
                    registerUser();
                }else if(collectorRb.isChecked()){
                    registerCollector();
                }

            }
        });
    }

    // method to handle collector registration
    private void registerCollector() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        // inset data as we wish
        values.put("user_name", userName);
        values.put("password", password);
        values.put("address", address);
        values.put("email", email);

        db.insert("collectors", null, values);

        db.close();

        // send to mapsActivity once registration is complete
        Intent intent = new Intent(RegisterActivity.this, MapsActivity.class);
        startActivity(intent);
    }

    private void  registerUser(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        // inset data as we wish
        values.put("user_name", userName);
        values.put("password", password);
        values.put("address", address);
        values.put("email", email);

        db.insert("users", null, values);

        db.close();

        // send to mapsActivity once registration is complete
        Intent intent = new Intent(RegisterActivity.this, MapsActivity.class);
        startActivity(intent);
    }
}