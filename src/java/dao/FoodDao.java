/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Food;
import entity.Room;
import entity.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author sakib
 */
public class FoodDao {
    public boolean addingFood(Food f) {
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();
            session.save(f);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<Food> allFoodList(int page) {
        int postPerPage = 5;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();        
        Query query = session.createQuery("SELECT u FROM Food u");
        
        query.setFirstResult(page*postPerPage);
        query.setMaxResults(postPerPage);
        
        List<Food> cList= query.list();
        cList.toString();
        session.close();
        return cList;
    }
    
    public boolean updateFood(Food f) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            session.update(f);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteFood(Food f) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(f);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
    
    public List<Food> cartFood(String fid) {
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();        
        Query query = session.createQuery("SELECT u FROM Food u where fooId=?");
        query.setParameter(0, fid);
        
        
        List<Food> cList= query.list();
        cList.toString();
        session.close();
        return cList;
    }
}
