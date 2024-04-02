package com.example.clovercycle;

public class User {
    private String userName, password, address;
    private int userId;
    public User(String userName, String password, String address, int userId) {
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.userId = userId;
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
