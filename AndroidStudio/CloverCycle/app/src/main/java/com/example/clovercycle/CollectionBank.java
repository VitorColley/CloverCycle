package com.example.clovercycle;

public class CollectionBank {
    private String address, bankId;

    public CollectionBank(String address, String bankId) {
        this.address = address;
        this.bankId = bankId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }
}
