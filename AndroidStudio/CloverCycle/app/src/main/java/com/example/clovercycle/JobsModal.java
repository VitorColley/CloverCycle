package com.example.clovercycle;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class JobsModal {
    // variables for our jobs,
    // description, tracks and duration, id.
    private String name;
    private String address;
    private String amount;


    public String getName(){

        return name;
    }
    public void setUserName(String userName) {

        this.name = userName;
    }
    public String getAddress(){

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public void setAmount(String amount) {

        this.amount = amount;
    }

    public String getAmount(){

        return amount;
    }

    public JobsModal(String userName, String address, String amount) {
        this.name = userName;
        this.address = address;
        this.amount = amount;
    }

}