package com.example.clovercycle;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //Create Variables:
    String userName, password;
    Button logInBtn;
    EditText userNameInput, passwordInput;

    DatabaseSqlite dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //source reference for getting user input: https://www.youtube.com/watch?v=V0AETAjxqLI&ab_channel=John%27sAndroidStudioTutorials
        //link text fields to variables
        userNameInput = (EditText) findViewById(R.id.userNameTf);
        passwordInput = (EditText) findViewById(R.id.passTf);

        //create event listener
        logInBtn = (Button) findViewById(R.id.logInBtn);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //assign text values to the variables
                userName = userNameInput.getText().toString();
                password = passwordInput.getText().toString();

                //run method with variables
                LogIn(userName, password);
            }
        });


    }


    public void LogIn(String userName, String password) {
        // Set validation message to invisible in case there were other attempts
        findViewById(R.id.invalidPassword).setVisibility(View.INVISIBLE);
        findViewById(R.id.invalidUser).setVisibility(View.INVISIBLE);

        // Query the database to check if the entered username and password match
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE user_name=? AND password=?", new String[]{userName, password});

        if (cursor.moveToFirst()) {
            // User authenticated, move to next activity
            Intent intent;
            if (userName.contains("#")) {
                // Redirect to collector UI
                intent = new Intent(MainActivity.this, Collector.class);
            } else {
                // change adetqualtiy
                intent = new Intent(MainActivity.this, MapsActivity.class);
            }
            startActivity(intent);
        } else {
            // username nnd password cant be found
            findViewById(R.id.invalidPassword).setVisibility(View.VISIBLE);
        }

        cursor.close();
    }
}
