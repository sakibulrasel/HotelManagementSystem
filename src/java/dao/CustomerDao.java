/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Reservation;
import entity.Room;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author Another User
 */
public class CustomerDao {
    
    public List allCustomer() {
  
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();   
        Query query = session.createQuery("SELECT p FROM Reservation p ");
        
        
        List<Reservation> cList= query.list();
        
        cList.toString();
        
        
        
        session.close();
        return cList;
    }
    
    public List searchCustomerbyDt(Date dt) {
  
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();   
        Query query = session.createQuery("SELECT p FROM Reservation p where arrival=? ");
        query.setParameter(0, dt);
        
        
        List<Reservation> cList= query.list();
        
        cList.toString();
        
        
        
        session.close();
        return cList;
    }
    
    public List searchbetweenDt(Date dt, Date dt1) {
  
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();   
        Query query = session.createQuery("SELECT p FROM Reservation p where arrival between ? and ? ");
        query.setParameter(0, dt);
        query.setParameter(1, dt1);
        
        
        List<Reservation> cList= query.list();
        
        cList.toString();
        
        
        
        session.close();
        return cList;
    }
}
