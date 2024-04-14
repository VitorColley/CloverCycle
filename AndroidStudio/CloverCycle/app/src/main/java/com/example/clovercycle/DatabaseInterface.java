package com.example.clovercycle;

public interface DatabaseInterface {
    // Table names
    String TABLE_USERS = "users";
    String TABLE_COLLECTORS = "collectors";
    String TABLE_JOBS = "jobs";

    String TABLE_COMPLETED_JOBS = "completedJobs";
    String TABLE_PAYMENT_INFO = "paymentInfo";
    // Column names
    String KEY_ID_USERS = "user_id";
    String KEY_ID_COLLECTORS = "collector_id";
    String KEY_ID_JOBS = "job_id";
    String KEY_ID_COMPLETED_JOBS = "complete_job_id";
    String KEY_ID_PAYMENT_INFO = "payment_id";
    String KEY_USER_NAME = "user_name";
    String KEY_PASSWORD = "password";
    String KEY_ADDRESS = "address";
    String KEY_EMAIL = "email";
    String KEY_AMOUNT = "amount";
    String KEY_NAME = "name";
    String KEY_CARD_NUMBER = "card_number";
    String KEY_EXPIRY_DATE = "expiry_date";


}