package entity;
// Generated Oct 14, 2018 8:42:03 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Reservation generated by hbm2java
 */
public class Reservation  implements java.io.Serializable {


     private Integer idreservation;
     private String roomNo;
     private String roomType;
     private String name;
     private String address;
     private String city;
     private String sex;
     private int age;
     private String mobile;
     private Date arrival;
     private Date departure;
     private double charges;
     private double advance;
     private int days;
     private double total;
     private double due;

    public Reservation() {
    }

    public Reservation(String roomNo, String roomType, String name, String address, String city, String sex, int age, String mobile, Date arrival, Date departure, double charges, double advance, int days, double total, double due) {
       this.roomNo = roomNo;
       this.roomType = roomType;
       this.name = name;
       this.address = address;
       this.city = city;
       this.sex = sex;
       this.age = age;
       this.mobile = mobile;
       this.arrival = arrival;
       this.departure = departure;
       this.charges = charges;
       this.advance = advance;
       this.days = days;
       this.total = total;
       this.due = due;
    }
   
    public Integer getIdreservation() {
        return this.idreservation;
    }
    
    public void setIdreservation(Integer idreservation) {
        this.idreservation = idreservation;
    }
    public String getRoomNo() {
        return this.roomNo;
    }
    
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }
    public String getRoomType() {
        return this.roomType;
    }
    
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public Date getArrival() {
        return this.arrival;
    }
    
    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }
    public Date getDeparture() {
        return this.departure;
    }
    
    public void setDeparture(Date departure) {
        this.departure = departure;
    }
    public double getCharges() {
        return this.charges;
    }
    
    public void setCharges(double charges) {
        this.charges = charges;
    }
    public double getAdvance() {
        return this.advance;
    }
    
    public void setAdvance(double advance) {
        this.advance = advance;
    }
    public int getDays() {
        return this.days;
    }
    
    public void setDays(int days) {
        this.days = days;
    }
    public double getTotal() {
        return this.total;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }
    public double getDue() {
        return this.due;
    }
    
    public void setDue(double due) {
        this.due = due;
    }




}


