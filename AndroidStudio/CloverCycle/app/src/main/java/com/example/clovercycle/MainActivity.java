package com.example.clovercycle;

import android.content.Intent;
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


    User newUser = new User("VitorColley", "1234",  "D1 2222", 1);
     //Log In method
    public void LogIn(String userName, String password) {
        //set validation message to invisible in case there were other attempts
        findViewById(R.id.invalidPassword).setVisibility(View.INVISIBLE);
        findViewById(R.id.invalidUser).setVisibility(View.INVISIBLE);

        //check username
        if (userName.equalsIgnoreCase(newUser.getUserName())) {
            //check password
            if (password.equalsIgnoreCase(newUser.getPassword())) {
                //move to next activity
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            } else {
                //return validation message for invalid password
                findViewById(R.id.invalidPassword).setVisibility(View.VISIBLE);
            }
        } else {
            //checks if username contains "#", this is a collectors id
            if (userName.contains("#")) {
                //redirect to a new GUI
                Intent intent = new Intent(MainActivity.this, CollectorUI.class);
                startActivity(intent);
            } else {
                //return validation message for invalid username
                findViewById(R.id.invalidUser).setVisibility(View.VISIBLE);
            }
        }
    }

}