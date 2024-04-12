package com.example.clovercycle;

public class PaymentHistory {
    private int jobId;
    private String jobName;
    private double amount;
    private String date;

    public PaymentHistory(int jobId, String jobName, double amount) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.amount = amount;
        this.date = date;
    }

    // Getters and setters
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
