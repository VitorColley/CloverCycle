package com.example.clovercycle;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

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
            KEY_EMAIL + " TEXT,"+
            KEY_JOBS + " TEXT)";

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


}
