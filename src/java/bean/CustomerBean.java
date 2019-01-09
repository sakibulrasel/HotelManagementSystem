/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.CustomerDao;
import dao.RoomDao;
import entity.Reservation;
import entity.Room;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Another User
 */
@ManagedBean
@SessionScoped
public class CustomerBean {
    Reservation reservation=new Reservation();
    String next="0";
    String keyword;
    Date dt, dt1;

    public Date getDt1() {
        return dt1;
    }

    public void setDt1(Date dt1) {
        this.dt1 = dt1;
    }

    
    
    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }
    
    
    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    
    
    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    
    public List<Reservation> getCustomer(){
        List<Reservation> plist = new RoomDao().allPostList(nextPageNumber()-1);        
        return plist;
    }
    
    public int nextPageNumber(){
        int nextPageNumber = 1;
        try {
            nextPageNumber = Integer.parseInt(next)+1;
        } catch (Exception e) {
        }
        
        return nextPageNumber;
    }
    
    public long getTotalCustomer(){
        long total = new RoomDao().getTotalCustomer();        
        return total;
    }
    
    public List<Reservation> getCustomerDetails(){
        List<Reservation> plist = new CustomerDao().allCustomer();        
        return plist;
    }
    
    public List<Reservation> getCustomerDetailsBydt(){
        
        List<Reservation> plist = new CustomerDao().searchCustomerbyDt(dt);        
        return plist;
    }
    
    public List<Reservation> getCustomerBetdt(){
        
        List<Reservation> plist = new CustomerDao().searchbetweenDt(dt, dt1);        
        return plist;
    }
}
