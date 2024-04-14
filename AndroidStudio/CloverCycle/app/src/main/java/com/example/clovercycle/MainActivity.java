package com.example.clovercycle;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;


/* references:
https://developer.android.com/training/data-storage/shared-preferences
https://stackoverflow.com/questions/38817606/sharedpreferences-to-save-login-data
https://www.geeksforgeeks.org/how-to-create-and-add-data-to-sqlite-database-in-android/
https://androidknowledge.com/login-signup-sqlite-android-studio-java/
https://www.geeksforgeeks.org/how-to-create-and-add-data-to-sqlite-database-in-android/
https://androidknowledge.com/login-signup-sqlite-android-studio-java/
https://developer.android.com/training/data-storage/shared-preferences
https://stackoverflow.com/questions/38817606/sharedpreferences-to-save-login-data
https://www.sqlite.org/quickstart.html
https://www.sqlite.org/lang_corefunc.html
https://www.sqlite.org/datatype3.html
 */
public class MainActivity extends AppCompatActivity {
    //create Variables:
    EditText userNameInput, passwordInput;
    Button logInBtn, registerBtn;
    private DatabaseSqlite dbHelper;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Call database to onCreate method
        dbHelper = new DatabaseSqlite(this);
        sharedPreferences = getSharedPreferences("userTableID", MODE_PRIVATE);

        //source reference for getting user input: https://www.youtube.com/watch?v=V0AETAjxqLI&ab_channel=John%27sAndroidStudioTutorials
        //link text fields to variables
        userNameInput = findViewById(R.id.userNameTf);
        passwordInput = findViewById(R.id.passTf);

        //create event listener
        logInBtn = findViewById(R.id.logInBtn);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //assign text values to the variables
                String userName = userNameInput.getText().toString();
                String password = passwordInput.getText().toString();

                //run method with variables
                LogIn(userName, password);
            }
        });
        //create event listener for register
        registerBtn = findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send to register activity when button is pressed
                Register();
            }
        });


    }

    //method to log in
    public void LogIn(String userName, String password) {
        //get database
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        //select the tables and compare info with username and password
        Cursor userCursor = db.rawQuery("SELECT * FROM users WHERE user_name=? AND password=?", new String[]{userName, password});
        Cursor collectorCursor = db.rawQuery("SELECT * FROM collectors WHERE user_name=? AND password=?", new String[]{userName, password});

        //check if they are not null
        int userId = -1;
        int collectorId = -1;

        //check if it is a user or a collector
        if (userCursor.moveToFirst()) {
            int userIdIndex = userCursor.getColumnIndex(DatabaseInterface.KEY_ID_USERS);
            if (userIdIndex != -1) {
                // this variable \/ use this for any other class to be able to tailor user experience
                userId = userCursor.getInt(userIdIndex);
                //simple log to be able to see if userID is being actually stored
                Log.d("MainActivity", "User ID: " + userId);
                // give the activity handler method the call to direct user once authenticated
                activityHandler(userId, collectorId);
            }
        } else if (collectorCursor.moveToFirst()) {
            int collectorIdIndex = collectorCursor.getColumnIndex(DatabaseInterface.KEY_ID_COLLECTORS);
            if (collectorIdIndex != -1) {
                // this variable \/ use this for any other class to be able to tailor user experience
                collectorId = collectorCursor.getInt(collectorIdIndex);
                //simple log to be able to see if collectorID is being actually stored
                Log.d("MainActivity", "Collector ID: " + collectorId);
                // give the activity handler method the call to direct collector once authenticated
                activityHandler(userId, collectorId);
            }
            //display if password is wrong
        } else {
            findViewById(R.id.invalidPassword).setVisibility(View.VISIBLE);
        }

        //close cursors
        userCursor.close();
        collectorCursor.close();
    }

    /*this method will handle the authentication of user/collector sending
    sending them to the correct activity  using shared-preferences */
    private void activityHandler(int userId, int collectorId) {
        Intent intent;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // if userID from previous method is valid, execute the if statement
        if (userId != -1) {
            editor.putInt("userTableID", userId);
            editor.apply();
            intent = new Intent(MainActivity.this, UserJobActivity.class);
            startActivity(intent);
        } else if (collectorId != -1) { // Add curly braces to enclose the else if block
            editor.putInt("collectorTableID", collectorId);
            editor.apply();
            intent = new Intent(MainActivity.this, CollectorActivity.class);
            startActivity(intent);
        }
    }

    public void Register() {
        //this is how you call from one activity to another
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}