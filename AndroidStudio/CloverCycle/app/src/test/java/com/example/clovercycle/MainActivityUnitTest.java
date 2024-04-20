package com.example.clovercycle;

import static com.ibm.icu.impl.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.robolectric.Shadows.shadowOf;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Build.VERSION_CODES.O_MR1})
public class MainActivityUnitTest {

    private MainActivity activity;
    private ActivityController<MainActivity> controller;
    DatabaseSqlite dbHelper;


    @Before
    public void setUp() {
        controller = Robolectric.buildActivity(MainActivity.class).setup();
        activity = controller.get();
    }

    @Test
    public void testLogIn() {
        dbHelper = activity.dbHelper;
        String username = "user";
        String password = "12345678!";

        activity.LogIn(username, password);
        try {
            assertEquals(username, dbHelper.readValue("user_name", "users", 1));
            assertEquals(username, dbHelper.readValue("user_name", "collectors", 1));
            assertEquals(password, dbHelper.readValue("password", "collectors", 1));
            assertEquals(password, dbHelper.readValue("password", "users", 1));
        } catch (CursorIndexOutOfBoundsException e) {
            System.out.println("Cursor is empty for the given credentials.");
        }
    }
}

