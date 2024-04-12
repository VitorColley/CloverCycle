package com.example.clovercycle;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PaymentHistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PaymentHistoryAdapter adapter;
    private ArrayList<PaymentHistory> paymentHistories;
    private DatabaseSqlite databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_history);

        recyclerView = findViewById(R.id.recyclerViewPaymentHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseHelper = new DatabaseSqlite(this);
        paymentHistories = databaseHelper.getAllPayments();

        adapter = new PaymentHistoryAdapter(paymentHistories);
        recyclerView.setAdapter(adapter);
    }
}
