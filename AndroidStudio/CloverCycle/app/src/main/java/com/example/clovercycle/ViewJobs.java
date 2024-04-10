package com.example.clovercycle;
import android.os.Bundle;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_jobs);

        // initializing our all variables.
        jobsModalArrayList = new ArrayList<>();
        dbHandler = new DatabaseSqlite(ViewJobs.this);

        // getting our course array
        // list from db handler class.
        jobsModalArrayList = dbHandler.readJobs();

        // on below line passing our array list to our adapter class.
        jobsRVAdapter = new JobsRVAdapter(jobsModalArrayList, ViewJobs.this);
        jobsRV = findViewById(R.id.idRVJobs);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewJobs.this, RecyclerView.VERTICAL, false);
        jobsRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        jobsRV.setAdapter(jobsRVAdapter);
    }
}