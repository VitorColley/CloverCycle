package com.example.clovercycle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    // Variables declaration
    EditText userNameInput, passwordInput;
    Button logInBtn, registerBtn;
    DatabaseSqlite dbHelper; // Declare dbHelper
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize database helper and shared preferences
        dbHelper = new DatabaseSqlite(this); // Initialize dbHelper with a new instance
        sharedPreferences = getSharedPreferences("userTableID", MODE_PRIVATE);

        // Link layout elements to Java variables
        userNameInput = findViewById(R.id.userNameTf);
        passwordInput = findViewById(R.id.passTf);

        // Set OnClickListener for login button
        logInBtn = findViewById(R.id.logInBtn);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get entered username and password
                String userName = userNameInput.getText().toString();
                String password = passwordInput.getText().toString();
                // Attempt login
                LogIn(userName, password);
            }
        });

        // Set OnClickListener for register button
        registerBtn = findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open RegisterActivity
                Register();
            }
        });
    }

    // Method to handle user login
    public void LogIn(String userName, String password) {
        // Get readable database
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        // Query users table for matching credentials
        Cursor userCursor = db.rawQuery("SELECT * FROM users WHERE user_name=? AND password=?", new String[]{userName, password});
        Cursor collectorCursor = db.rawQuery("SELECT * FROM collectors WHERE user_name=? AND password=?", new String[]{userName, password});

        // Initialize user and collector IDs
        int userId = -1;
        int collectorId = -1;

        // Check if user credentials are valid
        if (userCursor.moveToFirst()) {
            int userIdIndex = userCursor.getColumnIndex(DatabaseInterface.KEY_ID_USERS);
            if (userIdIndex != -1) {
                userId = userCursor.getInt(userIdIndex);
                activityHandler(userId, collectorId);
            }
        } else if (collectorCursor.moveToFirst()) {
            int collectorIdIndex = collectorCursor.getColumnIndex(DatabaseInterface.KEY_ID_COLLECTORS);
            if (collectorIdIndex != -1) {
                collectorId = collectorCursor.getInt(collectorIdIndex);
                activityHandler(userId, collectorId);
            }
        } else {
            // Display error message if credentials are invalid
            findViewById(R.id.invalidPassword).setVisibility(View.VISIBLE);
        }

        // Close cursors
        userCursor.close();
        collectorCursor.close();
    }

    // Method to handle activity redirection after login
    private void activityHandler(int userId, int collectorId) {
        Intent intent;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // Redirect user or collector based on ID
        if (userId != -1) {
            editor.putInt("userTableID", userId);
            editor.apply();
            intent = new Intent(MainActivity.this, UserJobActivity.class);
            startActivity(intent);
        } else if (collectorId != -1) {
            editor.putInt("collectorTableID", collectorId);
            editor.apply();
            intent = new Intent(MainActivity.this, CollectorActivity.class);
            startActivity(intent);
        }
    }

    // Method to open RegisterActivity
    public void Register() {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}