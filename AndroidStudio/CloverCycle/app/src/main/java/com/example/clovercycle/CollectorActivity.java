package com.example.clovercycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class CollectorActivity extends AppCompatActivity {

    Button menuBtn, jobBtn, collectBtn, endBtn;

    SharedPreferences sharedPreferences;

    private ArrayList<JobsModal> jobsModalArrayList, myList;
    private DatabaseSqlite dbHandler;
    private JobsRVAdapter jobsRVAdapter;
    private RecyclerView jobsRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collector);
        sharedPreferences = getSharedPreferences("collectorTableID", MODE_PRIVATE);

        // initializing our all variables.
        jobsModalArrayList = new ArrayList<>();
        myList = new ArrayList<>();
        dbHandler = new DatabaseSqlite(CollectorActivity.this);

        // getting the job array
        // list from db handler class.
        jobsModalArrayList = dbHandler.readJobs();

        // on below line passing our array list to our adapter class.
        jobsRVAdapter = new JobsRVAdapter(jobsModalArrayList, CollectorActivity.this);
        jobsRV = findViewById(R.id.jobList);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CollectorActivity.this, RecyclerView.VERTICAL, false);
        jobsRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        jobsRV.setAdapter(jobsRVAdapter);

        menuBtn = (Button) findViewById(R.id.menuBtn);

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logoutActivity();
            }
        });

        jobBtn = findViewById(R.id.jobBtn);

        jobBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myList = dbHandler.getLastJob();
                String address = myList.get(0).getAddress();

                if (myList.isEmpty()) {
                    Toast.makeText(CollectorActivity.this, "Sorry, There are no jobs available!", Toast.LENGTH_SHORT).show();
                } else {

                    dbHandler.deleteJob(myList.get(0).getName());

                    String map = "http://maps.google.com/maps?q=" + address;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                    startActivity(intent);

                    findViewById(R.id.jobBtn).setVisibility(View.GONE);
                    findViewById(R.id.collectBtn).setVisibility(View.VISIBLE);
                }

            }
        });

        collectBtn = findViewById(R.id.collectBtn);

        collectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "https://re-turn.ie/#WhereToReturn";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                startActivity(intent);

                findViewById(R.id.collectBtn).setVisibility(View.GONE);
                findViewById(R.id.endBtn).setVisibility(View.VISIBLE);
            }
        });

        endBtn = findViewById(R.id.endBtn);

        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jobsModalArrayList = dbHandler.readJobs();
                jobsRVAdapter = new JobsRVAdapter(jobsModalArrayList, CollectorActivity.this);
                jobsRV = findViewById(R.id.jobList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CollectorActivity.this, RecyclerView.VERTICAL, false);
                jobsRV.setLayoutManager(linearLayoutManager);
                jobsRV.setAdapter(jobsRVAdapter);

                int collectorId = sharedPreferences.getInt("collectorTableID", -1);

                dbHandler.moveJob(myList, collectorId);

                findViewById(R.id.endBtn).setVisibility(View.GONE);
                findViewById(R.id.jobBtn).setVisibility(View.VISIBLE);
            }
        });


    }

    public void logoutActivity() {
        Intent intent1 = new Intent(this, MainActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent1);
        finish();
    }
}