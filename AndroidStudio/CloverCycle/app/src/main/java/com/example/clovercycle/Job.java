package com.example.clovercycle;

public class Job{
    private int id;
    private String userName;
    private String address;
    private double amount;

    public Job() {
    }

    public Job(int id, String userName, String address, double amount) {
        this.id = id;
        this.userName = userName;
        this.address = address;
        this.amount = amount;
    }

    // ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // UserName
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Amount
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Optional: Override the toString method for easy printing/debugging
    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", amount=" + amount +
                '}';
    }
}
