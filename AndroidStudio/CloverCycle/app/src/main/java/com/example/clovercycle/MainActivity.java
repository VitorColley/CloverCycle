package com.example.clovercycle;

import   android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.ContentValues;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //Create Variables:
    String userName, password;
    Button logInBtn, registerBtn;
    EditText userNameInput, passwordInput;

    DatabaseSqlite dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Call database to onCreate method
        dbHelper = new DatabaseSqlite(this);
        // we use this to call the method fillDatabase on creation of the activity
        fillDatabase();

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
        //create event listener for register
        registerBtn = (Button) findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send to register activity when button is pressed
                Register();
            }
        });


    }


    public void LogIn(String userName, String password) {
        /*
        // Set validation message to invisible in case there were other attempts
        findViewById(R.id.invalidPassword).setVisibility(View.INVISIBLE);
        findViewById(R.id.invalidUser).setVisibility(View.INVISIBLE);
         */

        // this updated version use function cursor to check for both user and collectors columns
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        //checking the value from inside database
        Cursor userCursor = db.rawQuery("SELECT * FROM users WHERE user_name=? AND password=?", new String[]{userName, password});
        Cursor collectorCursor = db.rawQuery("SELECT * FROM collectors WHERE user_name=? AND password=?", new String[]{userName, password});

        if (userCursor.moveToFirst()) {
            // User authenticated, move to next activity
            Intent intent = new Intent(MainActivity.this, UserJobActivity.class);
            startActivity(intent);
        } else if (collectorCursor.moveToFirst()){
            Intent intent = new Intent(MainActivity.this, CollectorActivity.class);
            startActivity(intent);
        }else {
            // Username and password can't be found
            findViewById(R.id.invalidPassword).setVisibility(View.VISIBLE);
        }

        userCursor.close();
        collectorCursor.close();

    }

    public void Register(){
        //this is how you call from one activity to another
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
    // method to add data manually to database
    private void fillDatabase() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues userValues = new ContentValues();
        ContentValues collectorValues = new ContentValues();

        // inset data as we wish
        //were gonna use this to insert data for users
        userValues.put("user_name", "gus");
        userValues.put("password", "gus");
        db.insert("users", null, userValues);


        //insert data for collectors
        collectorValues.put("user_name", "conor");
        collectorValues.put("password", "conor");
        db.insert("collectors", null, collectorValues);

        db.close();
    }
}
