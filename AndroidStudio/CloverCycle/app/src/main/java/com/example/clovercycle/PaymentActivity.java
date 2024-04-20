package com.example.clovercycle;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {

    public PaymentActivity() {

    }

    //references
    //https://stackoverflow.com/questions/24610527/how-do-i-get-a-button-to-open-another-activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Button submitPayment = findViewById(R.id.paymentBTN);
        Button mainMenuButton = findViewById(R.id.Button2);
        Button viewHistoryButton = findViewById(R.id.HistoryButton);

        submitPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText cardNumberField = findViewById(R.id.cardNUM);
                EditText expiryDateField = findViewById(R.id.expiryNUM);

                String cardNumber = cardNumberField.getText().toString();
                String expiryDate = expiryDateField.getText().toString();

                processPayment(cardNumber, expiryDate);
            }
        });

        mainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutActivity();
            }
        });

        viewHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PaymentHistoryActivity.class);
                startActivity(intent);
            }
        });


    }


    public boolean processPayment(String cardNumber, String expiryDate) {
        if (cardNumber == null || cardNumber.length() != 16) {
            Toast.makeText(PaymentActivity.this, "Invalid card number", Toast.LENGTH_LONG).show();
            return false;
        }
        if (expiryDate == null || expiryDate.length() != 4) {
            Toast.makeText(PaymentActivity.this, "Invalid expiry date", Toast.LENGTH_LONG).show();
            return false;
        }
        // simulate network delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //after payment is successful, save payment info to database
                savePaymentInfoToDatabase(cardNumber, expiryDate);
                Toast.makeText(PaymentActivity.this, "Payment Successful", Toast.LENGTH_LONG).show();
            }
        }, 2000); // 2 seconds delay, will adjust as needed
        return true;
    }


    private void savePaymentInfoToDatabase(String cardNumber, String expiryDate) {
        DatabaseSqlite dbHelper = new DatabaseSqlite(PaymentActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("cardNumber", cardNumber);
        values.put("expiryDate", expiryDate);

        long newRowId = db.insert("PaymentInfo", null, values);

        if (newRowId != -1) {
            Toast.makeText(PaymentActivity.this, "Payment Info Saved", Toast.LENGTH_SHORT).show();
        } else {

        }
    }

    public void logoutActivity() {
        Intent intent1 = new Intent(this, UserJobActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent1);
        finish();
    }
}
