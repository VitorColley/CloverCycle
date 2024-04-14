package com.example.clovercycle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.clovercycle.DatabaseSqlite;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewJobs extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<JobsModal> jobsModalArrayList;
    private DatabaseSqlite dbHandler;
    private JobsRVAdapter jobsRVAdapter;
    private RecyclerView jobsRV;
    SharedPreferences sharedPreferences;
    Button menuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jobs_view);
        sharedPreferences = getSharedPreferences("userTableID", MODE_PRIVATE);
        // initializing our all variables.
        jobsModalArrayList = new ArrayList<>();
        dbHandler = new DatabaseSqlite(ViewJobs.this);

        int userId = sharedPreferences.getInt("userTableID", -1);

        // getting our course array
        // list from db handler class.
        jobsModalArrayList = dbHandler.readJobs(userId);

        // on below line passing our array list to our adapter class.
        jobsRVAdapter = new JobsRVAdapter(jobsModalArrayList, ViewJobs.this);
        jobsRV = findViewById(R.id.idRVJobs);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewJobs.this, RecyclerView.VERTICAL, false);
        jobsRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        jobsRV.setAdapter(jobsRVAdapter);

        menuBtn = (Button) findViewById(R.id.menuBtn);

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewJobs.this, UserJobActivity.class);
                startActivity(i);
            }
        });

    }
}