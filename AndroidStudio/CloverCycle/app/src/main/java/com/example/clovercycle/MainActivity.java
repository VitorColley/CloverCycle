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


        /* references: https://developer.android.com/training/data-storage/shared-preferences
        https://stackoverflow.com/questions/38817606/sharedpreferences-to-save-login-data
         */
public class MainActivity extends AppCompatActivity {
    //Create Variables:
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
        sharedPreferences = getSharedPreferences("TablesID", MODE_PRIVATE);

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
    public void LogIn(String userName, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor userCursor = db.rawQuery("SELECT * FROM users WHERE user_name=? AND password=?", new String[]{userName, password});
        Cursor collectorCursor = db.rawQuery("SELECT * FROM collectors WHERE user_name=? AND password=?", new String[]{userName, password});

        if (userCursor.moveToFirst()) {

            int userIdIndex = userCursor.getColumnIndex(DatabaseInterface.KEY_ID_USERS);
            if (userIdIndex != -1) {
                // this variable \/ use this for any other class to be able to tailor user experience
                int userId = userCursor.getInt(userIdIndex);
                //simple log to be able to see if userID is being actually stored
                Log.d("MainActivity", "User ID: " + userId);
                // give the activity handler method the call to direct users
                activityHandler(userId);
            }
        } else if (collectorCursor.moveToFirst()) {
            int collectorIdIndex = collectorCursor.getColumnIndex(DatabaseInterface.KEY_ID_COLLECTORS);
            if (collectorIdIndex != -1) {
                // this variable \/ use this for any other class to be able to tailor user experience
                int collectorId = collectorCursor.getInt(collectorIdIndex);
                //simple log to be able to see if collectorID is being actually stored
                Log.d("MainActivity", "Collector ID: " + collectorId);
                // give the activity handler method the call to direct users
                activityHandler(collectorId);
            }
        } else {
            findViewById(R.id.invalidPassword).setVisibility(View.VISIBLE);
        }

        userCursor.close();
        collectorCursor.close();
    }

    /*this method will handle the authentication of user/collector sending
    sending them to the correct activity  using shared-preferences */
    private void activityHandler(int userId) {
        Intent intent;
        if (userId != -1) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("tableID", userId);
            editor.apply();
            intent = new Intent(MainActivity.this, UserJobActivity.class);
        } else {
            intent = new Intent(MainActivity.this, CollectorActivity.class);
        }
        startActivity(intent);
    }

    public void Register(){
        //this is how you call from one activity to another
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}