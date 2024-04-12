package com.example.clovercycle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PaymentHistoryAdapter extends RecyclerView.Adapter<PaymentHistoryAdapter.ViewHolder> {

    private final ArrayList<PaymentHistory> paymentHistoryList;

    public PaymentHistoryAdapter(ArrayList<PaymentHistory> paymentHistoryList) {
        this.paymentHistoryList = paymentHistoryList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_history_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PaymentHistory payment = paymentHistoryList.get(position);
        holder.jobIdTextView.setText(String.valueOf(payment.getJobId()));
        holder.jobNameTextView.setText(payment.getJobName());
        holder.amountTextView.setText(String.format("$%.2f", payment.getAmount()));
    }

    @Override
    public int getItemCount() {
        return paymentHistoryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView jobIdTextView;
        public TextView jobNameTextView;
        public TextView amountTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            jobIdTextView = itemView.findViewById(R.id.jobIdTextView);
            jobNameTextView = itemView.findViewById(R.id.jobNameTextView);
            amountTextView = itemView.findViewById(R.id.amountTextView);
        }
    }
}
