package com.example.clovercycle;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import android.os.Build;


import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

//used to justify and implement robolectric
//https://robolectric.org/getting-started/
//uses robolectric to bypass the need for an emulator to run the code
@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Build.VERSION_CODES.O_MR1})
public class RegisterActivityTest{
    //declares a controller which will simulate the UI
    private ActivityController<RegisterActivity> controller;
    //declares the Activity
    private RegisterActivity activity;
    DatabaseSqlite dbHelper;

    @Before
    public void setUp() {
        //emulates the activity
        controller = Robolectric.buildActivity(RegisterActivity.class).setup();
        //uses the activity to get the items within the emulation
        activity = controller.get();

    }
    @Test
    public void testRegisterUser(){
        //access the database handler to be able to call the methods in it
        dbHelper = activity.dbHelper;

        //hardcode the values to be added to the db
        String username = "user";
        String password = "12345678@";
        String email = "user@gmail.com";
        String address = "D01FFFF";

        //call the method through the emulation
        activity.registerUser(username, password, address, email);

        //compare the values found through the use of the readValue method
        //the method takes the column name, the table and the id or the username
        // to retrieve specific values from the database
        assertEquals(username, dbHelper.readValue("user_name", "users", 1));
        assertEquals(password, dbHelper.readValue("password", "users", 1));
        assertEquals(email, dbHelper.readValue("email", "users", 1));
        assertEquals(address, dbHelper.readValue("address", "users", 1));

    }
    @Test
    public void testRegisterCollector(){
        //same as RegisterUser, except that we use the username to retrieve the information
        // from the database this time
        dbHelper = activity.dbHelper;

        String username = "collector";
        String password = "12345678@";
        String email = "collector@gmail.com";
        String address = "D01FFFF";

        activity.registerCollector(username, password, address, email);

        assertEquals(username, dbHelper.readValue("user_name", "collectors", "'"+username+"'"));
        assertEquals(password, dbHelper.readValue("password", "collectors", "'"+username+"'"));
        assertEquals(email, dbHelper.readValue("email", "collectors", "'"+username+"'"));
        assertEquals(address, dbHelper.readValue("address", "collectors", "'"+username+"'"));

    }
}