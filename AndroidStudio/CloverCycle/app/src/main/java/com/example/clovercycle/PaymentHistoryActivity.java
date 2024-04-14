package com.example.clovercycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PaymentHistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PaymentHistoryAdapter adapter;
    private ArrayList<PaymentHistory> paymentHistories;
    private DatabaseSqlite databaseHelper;
    private Button mainMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_history);

        recyclerView = findViewById(R.id.recyclerViewPaymentHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainMenuButton = findViewById(R.id.Button4);

        // initialize database helper
        databaseHelper = new DatabaseSqlite(this);
        try {
            // try fetch payment histories
            paymentHistories = databaseHelper.getAllPayments();
            if (paymentHistories.isEmpty()) {
                Toast.makeText(this, "No payment history available.", Toast.LENGTH_SHORT).show();
            } else {
                adapter = new PaymentHistoryAdapter(paymentHistories);
                recyclerView.setAdapter(adapter);
            }
        } catch (Exception e) {
            // catch any other exceptions
            Toast.makeText(this, "Failed to retrieve payment histories: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        mainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutActivity();
            }
        });
    }

    public void logoutActivity() {
        Intent intent1 = new Intent(this, UserJobActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent1);
        finish();
    }
}
