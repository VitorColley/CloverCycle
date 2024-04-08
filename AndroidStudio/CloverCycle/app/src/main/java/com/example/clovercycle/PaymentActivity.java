package com.example.clovercycle;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Button submitPayment = findViewById(R.id.paymentBTN);

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
    }

    private void processPayment(String cardNumber, String expiryDate) {
        // simulate network delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // after payment is successful, save payment info to database
                // TODO allow user to toggle this
                savePaymentInfoToDatabase(cardNumber, expiryDate);
                Toast.makeText(PaymentActivity.this, "Payment Successful", Toast.LENGTH_LONG).show();
            }
        }, 2000); // 2 seconds delay, will adjust as needed
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
            Toast.makeText(PaymentActivity.this, "Error Saving Payment Info", Toast.LENGTH_SHORT).show();
        }
    }
}
