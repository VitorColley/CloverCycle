package com.example.clovercycle;

public class User {
    private String userName, password, bankDetails, address;
    private int userId;

    public User() {

    }

    public User(String userName, String password, String bankDetails, String address, int userId) {
        this.userName = "Oisin McC";
        this.password = "password";
        this.bankDetails = "BOIE11D";
        this.address = "2 The Links,Donabate,Co.Dublin, K36F437";
        this.userId = 6;
    }

    public String getUserName() {

        //hardcoding in the below info for our initial test
         return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
//returning the hardcoded password
    public String getPassword() {
        return password;
    }
//setting the password for the user
    public void setPassword(String password) {
        this.password = password;
    }

    public String getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(String bankDetails) {
        this.bankDetails = bankDetails;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
