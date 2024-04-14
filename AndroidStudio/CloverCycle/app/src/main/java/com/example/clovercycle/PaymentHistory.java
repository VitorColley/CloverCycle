package com.example.clovercycle;

public class PaymentHistory {
    private int jobId;
    private String jobName;
    private double amount;

    public PaymentHistory(String jobName, double amount) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.amount = amount;
    }

    public int getJobId() {
        return jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public double getAmount() {
        return amount;
    }

}
