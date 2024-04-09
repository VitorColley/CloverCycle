package com.example.clovercycle;

public class JobsModal {
    // variables for our coursename,
    // description, tracks and duration, id.
    private String userName;
    private String address;
    private String amount;

    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getAddress(){
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAmount(){
        return amount;
    }

    public JobsModal(String userName, String address, String amount) {
        this.userName = userName;
        this.address = address;
        this.amount = amount;
    }
}
