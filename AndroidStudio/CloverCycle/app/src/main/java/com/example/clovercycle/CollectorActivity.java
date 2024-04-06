package com.example.clovercycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class CollectorActivity extends AppCompatActivity {

    EditText userNameInput;
    EditText passwordInput;
    EditText addressInput;
    EditText emailInput;
    Button registerButton;

    // Declare DatabaseSqlite dbHelper
    DatabaseSqlite dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collector_registration);

        // we initiate the database
        dbHelper = new DatabaseSqlite(getApplicationContext());

        // well call those buttons and address their variables
        userNameInput = findViewById(R.id.collectorUserName);
        passwordInput = findViewById(R.id.collectorPassword);
        addressInput = findViewById(R.id.collectorAddress);
        emailInput = findViewById(R.id.collectorEmail);
        registerButton = findViewById(R.id.collectorRegisterButton);

        // set click listener for registration button (make sure to get all variables named properly for buttons)
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call method to handle collector registration
                registerCollector();
            }
        });
    }

    // method to handle collector registration
    private void registerCollector() {
        // get registration data from EditText fields that we created on xml
        String userName = userNameInput.getText().toString();
        String password = passwordInput.getText().toString();
        String address = addressInput.getText().toString();
        String email = emailInput.getText().toString();

        // call method to register collector in the database using our dbHelper
        dbHelper.registerCollector(userName, password, address, email);

        // send to mapsActivity once registration is complete
        Intent intent = new Intent(CollectorActivity.this, MapsActivity.class);
        startActivity(intent);
    }
}
