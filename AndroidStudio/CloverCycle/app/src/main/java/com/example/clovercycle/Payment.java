package com.example.clovercycle;

public class Payment {
    private double amount;
    private int paymentId, userId, collectorId;
    private String timeDate, deliveryId;

    public Payment(double amount, int paymentId, int userId, int collectorId, String timeDate, String deliveryId) {
        this.amount = amount;
        this.paymentId = paymentId;
        this.userId = userId;
        this.collectorId = collectorId;
        this.timeDate = timeDate;
        this.deliveryId = deliveryId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(int collectorId) {
        this.collectorId = collectorId;
    }

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }
}