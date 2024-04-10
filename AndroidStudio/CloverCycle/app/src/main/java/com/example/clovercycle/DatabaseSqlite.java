package com.example.clovercycle;

import android.annotation.SuppressLint;
import android.content.ContentValues;

import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.content.ContentValues;

import java.util.ArrayList;


public class DatabaseSqlite extends SQLiteOpenHelper {


    // https://www.geeksforgeeks.org/how-to-create-and-add-data-to-sqlite-database-in-android/
    //https://androidknowledge.com/login-signup-sqlite-android-studio-java/


    // we give a name to our Database
    private static final String DB_NAME = "clovercycle_db";
    //database version



    private static final int DATABASE_VERSION = 9;



    private static final String TABLE_USERS = "users";
    private static final String TABLE_COLLECTORS = "collectors";
    private static final String TABLE_JOBS = "jobs";


    private static final String KEY_ID = "id";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_PASSWORD = "password";
    public static final String KEY_ADDRESS = "address";

    private static final String KEY_EMAIL ="email";
    private static final String KEY_AMOUNT = "amount";


    public static final String KEY_NAME ="name";

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
            KEY_NAME + " TEXT," +
            KEY_ADDRESS + " TEXT," +
            KEY_AMOUNT + " TEXT)";



    public DatabaseSqlite(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_COLLECTORS);
        db.execSQL(CREATE_TABLE_JOBS);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COLLECTORS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOBS);

        // create new tables
        onCreate(db);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewJob(String name, String address, String amount) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(KEY_NAME, name);
        values.put(KEY_ADDRESS, address);
        values.put(KEY_AMOUNT, amount);
        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_JOBS, null, values);
        // at last we are closing our
        // database after adding database.
        db.close();
    }
    public ArrayList<String> getJobs() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<String> jobsList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT " + KEY_NAME + " FROM " + TABLE_JOBS, null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String jobName = cursor.getString(cursor.getColumnIndex(KEY_NAME));
                jobsList.add(jobName);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return jobsList;
    }
    public ArrayList<JobsModal> readJobs()
    {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to
        // read data from database.
        Cursor cursorCourses
                = db.rawQuery("SELECT * FROM " + TABLE_JOBS, null);

        // on below line we are creating a new array list.
        ArrayList<JobsModal> courseModalArrayList
                = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from
                // cursor to our array list.
                courseModalArrayList.add(new JobsModal(
                        cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3)));

            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }


}
