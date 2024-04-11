package com.example.clovercycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clovercycle.JobsModal;

import java.util.ArrayList;

public class JobsRVAdapter extends RecyclerView.Adapter<JobsRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<JobsModal> jobsModalArrayList;
    private Context context;

    // constructor
    public JobsRVAdapter(ArrayList<JobsModal> jobsModalArrayList, Context context) {
        this.jobsModalArrayList = jobsModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_jobs, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        JobsModal modal = jobsModalArrayList.get(position);
        holder.nameTv.setText(modal.getName());
        holder.addressTv.setText(modal.getAddress());
        holder.amountTv.setText(modal.getAmount());

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return jobsModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView nameTv, addressTv, amountTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            nameTv = itemView.findViewById(R.id.nameTv);
            addressTv = itemView.findViewById(R.id.addressTv);
            amountTv = itemView.findViewById(R.id.amountTV);
        }
    }
}