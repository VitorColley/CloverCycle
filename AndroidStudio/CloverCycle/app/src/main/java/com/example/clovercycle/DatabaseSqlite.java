package com.example.clovercycle;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import com.example.clovercycle.Job;

import java.util.ArrayList;
import java.util.List;


public class DatabaseSqlite extends SQLiteOpenHelper {


    // https://www.geeksforgeeks.org/how-to-create-and-add-data-to-sqlite-database-in-android/
    //https://androidknowledge.com/login-signup-sqlite-android-studio-java/


    // we give a name to our Database
    private static final String DB_NAME = "clovercycle_db";
    //database version
    private static final int DATABASE_VERSION = 2;



    private static final String TABLE_USERS = "users";
    private static final String TABLE_COLLECTORS = "collectors";
    private static final String TABLE_JOBS = "jobs";


    private static final String KEY_ID = "id";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_ADDRESS = "address";

    private static final String KEY_EMAIL ="email";
    private static final String KEY_JOBS = "jobs";

    private static final String TABLE_PAYMENT_INFO = "PaymentInfo";
    private static final String KEY_CARD_NUMBER = "cardNumber";
    private static final String KEY_EXPIRY_DATE = "expiryDate";

    // new table for simulated payment functions
    private static final String CREATE_TABLE_PAYMENT_INFO = "CREATE TABLE " + TABLE_PAYMENT_INFO +
            "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            KEY_CARD_NUMBER + " TEXT," +
            KEY_EXPIRY_DATE + " TEXT)";



    // we only have 2 tables so far but we can create as necessary
    private static final String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_USERS +
            "(" + KEY_ID + " INTEGER PRIMARY KEY," +
            //we add a space and a comma to  represent how the data will look
            KEY_USER_NAME + " TEXT," +
            KEY_PASSWORD + " TEXT," +
            KEY_ADDRESS + " TEXT,"+
            KEY_EMAIL + " TEXT)";



    private static final String CREATE_TABLE_COLLECTORS = "CREATE TABLE " + TABLE_COLLECTORS +
            "(" + KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_USER_NAME + " TEXT," +
            KEY_PASSWORD + " TEXT," +
            KEY_ADDRESS + " TEXT,"+
            KEY_EMAIL + " TEXT)";

    private static final String CREATE_TABLE_JOBS = "CREATE TABLE " + TABLE_JOBS +
            "(" + KEY_ID + " INTEGER PRIMARY KEY," +
            KEY_USER_NAME + " TEXT," +
            KEY_ADDRESS + " TEXT," +
            "amount REAL)";


    public DatabaseSqlite(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_COLLECTORS);
        db.execSQL(CREATE_TABLE_JOBS);
        db.execSQL(CREATE_TABLE_PAYMENT_INFO);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COLLECTORS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOBS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PAYMENT_INFO);

        // create new tables
        onCreate(db);
    }

    /**
     * Inserts a new job into the jobs table.
     * @param userName The name of the user creating the job.
     * @param address The address where the job is to be completed.
     * @param amount The amount ready for collection for the job.
     */
    public void insertJob(String userName, String address, double amount) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER_NAME, userName);
        values.put(KEY_ADDRESS, address);
        values.put("amount", amount); // Assuming 'amount' column name



        // Inserting Row
        db.insert(TABLE_JOBS, null, values);
        // Closing database connection
        db.close();
    }
    /**
     * Fetches all jobs from the database.
     * @return A list of all jobs.
     */
    @SuppressLint("Range")
    public List<Job> getAllJobs() {
        List<Job> jobList = new ArrayList<>();
        // select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_JOBS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Job job = new Job();
                job.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                job.setUserName(cursor.getString(cursor.getColumnIndex(KEY_USER_NAME)));
                job.setAddress(cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)));
                job.setAmount(cursor.getDouble(cursor.getColumnIndex("amount")));
                // adding job to list
                jobList.add(job);
            } while (cursor.moveToNext());
        }
        // return job list
        cursor.close();
        db.close();
        return jobList;
    }

}
