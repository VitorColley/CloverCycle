package com.example.clovercycle;

public class Collector {
    private String userName, password, address;
    private int collectorId;
    //private boolean isCollector;
    public Collector(String userName,String password,String address, int collectorId) {
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.collectorId = collectorId;
        //initializing the boolean expression to check if the username belongs to the collector.
     //   this.isCollector = userName.startsWith("#");

    }
    public String getUserName() {
        return userName;
        }
        public void setUserName(String userName){
            this.userName = userName;
           // this.isCollector= userName.startsWith("#");
        }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(int collectorId) {
        this.collectorId = collectorId;
    }

 //  public boolean isCollector() {
      //  return isCollector;
  // }

 //   public void setCollector(boolean collector) {
   //     isCollector = collector;
  //  }
}
