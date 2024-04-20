package com.example.clovercycle;

import org.junit.Before;

import static org.junit.Assert.*;
import android.os.Build;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Build.VERSION_CODES.O_MR1})
public class CollectorActivityTest {

    private ActivityController<CollectorActivity> controller;
    private CollectorActivity activity;
    DatabaseSqlite dbHandler;

    @Before
    public void setUp(){
        controller = Robolectric.buildActivity(CollectorActivity.class).setup();
        activity = controller.get();
    }
    @Test
    public void testReadValueWithId(){
        dbHandler = activity.dbHandler;
        String name, address, amount;
        int userId;

        name = "user";
        address = "D01FFFF";
        amount  = "10";
        userId = 1;

        dbHandler.addNewJob(name, address, amount, userId);

        String testAddress = dbHandler.readValue("address", "jobs", 1);

        assertEquals(address, testAddress);
    }
    @Test
    public void testReadValueWithUsername(){
        dbHandler = activity.dbHandler;
        String name, address, amount;
        int userId;

        name = "user";
        address = "D01FFFF";
        amount  = "10";
        userId = 1;

        dbHandler.addNewJob(name, address, amount, userId);

        String testAddress = dbHandler.readValue("address", "jobs", "'"+name+"'");

        assertEquals(address, testAddress);

    }
    @Test
    public void testGetLastJob(){
        dbHandler = activity.dbHandler;
        String name, address, amount;
        int userId;

        name = "user";
        address = "D01FFFF";
        amount  = "10";
        userId = 1;

        dbHandler.addNewJob(name, address, amount, userId);

        ArrayList<JobsModal> myList = new ArrayList<>();

        myList= dbHandler.getLastJob();

        assertEquals(name, myList.get(0).getName());
        assertEquals(address, myList.get(0).getAddress());
        assertEquals(amount, myList.get(0).getAmount());

    }
    @Test
    public void testDeleteJob(){
        dbHandler = activity.dbHandler;
        String name, address, amount;
        int userId;

        name = "user";
        address = "D01FFFF";
        amount  = "10";
        userId = 1;

        dbHandler.addNewJob(name, address, amount, userId);
        ArrayList<JobsModal> myList = new ArrayList<>();
        myList= dbHandler.getLastJob();

        dbHandler.deleteJob(myList.get(0).getName());

        myList = dbHandler.readJobs();

        assertTrue(myList.isEmpty());

    }
    @Test
    public void testMoveJob(){
        dbHandler = activity.dbHandler;
        String name, address, amount;
        int userId;

        name = "user";
        address = "D01FFFF";
        amount  = "10";
        userId = 1;

        dbHandler.addNewJob(name, address, amount, userId);
        ArrayList<JobsModal> myList = new ArrayList<>();
        myList= dbHandler.getLastJob();

        dbHandler.moveJob(myList, 1);

        myList = dbHandler.readCompleteJobs();

        assertFalse(myList.isEmpty());
    }
}