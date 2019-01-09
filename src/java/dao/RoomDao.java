/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entity.Reservation;
import entity.Room;
import entity.User;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;
import util.SessionUtil;

/**
 *
 * @author sakib
 */
public class RoomDao {
    public List catList(){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        List<Room> cList=session.createQuery("select al.roomNo from Room al where book='Unbooked'").list();
        cList.toString();
        session.close();
        return cList;
    }
    
    public List typeList(Room room){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        Query q=session.createQuery("select al.roomType from Room al where roomNo=?");
        q.setParameter(0, room.getRoomNo());
        List<Room> cList=q.list();
        cList.toString();
        session.close();
        return cList;
    }
    
    public boolean login(User user) {
        try {

            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
            
            Query query = session.createQuery("SELECT u FROM User u WHERE u.uname=:uname AND u.pass =:pass");
            query.setString("uname", user.getUname());
            query.setString("pass", user.getPass());          
            
            List<User> cList= query.list();
            cList.toString();
            session.getTransaction().commit();
            session.close();
            
            if(cList.size()>0){
                HttpSession session1 = SessionUtil.getSession();
                session1.setAttribute("uname", cList.get(0).getUname());
                session1.setAttribute("urole", cList.get(0).getRole());                
                return true;
            } else{
                return false;                
            }
            

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateRoom(Room room){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        Query q= session.createQuery("update Room set book = 'Booked' where roomNo = ?");
       
        q.setParameter(0, room.getRoomNo());
        int count=q.executeUpdate();
        session.getTransaction().commit();
        session.close();
        if(count>0){
            return true;
        }else{
            return false;
        }
        
    }
    
    public List<User> allUsersList(int page) {
        int postPerPage = 5;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();        
        Query query = session.createQuery("SELECT u FROM User u");
        
        query.setFirstResult(page*postPerPage);
        query.setMaxResults(postPerPage);
        
        List<User> cList= query.list();
        cList.toString();
        session.close();
        return cList;
    }
    
    public long getTotalUser() {
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();        
        Query query = session.createQuery("SELECT COUNT(*) FROM User");
        
        long total =(long) query.uniqueResult();
      
        return total;
    }
    
    public long getTotalManager() {
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();        
        Query query = session.createQuery("SELECT COUNT(*) FROM User where role='Manager'");
        
        long total =(long) query.uniqueResult();
      
        return total;
    }
    
    public long getTotalEvent() {
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();        
        Query query = session.createQuery("SELECT COUNT(*) FROM User where role='Event'");
        
        long total =(long) query.uniqueResult();
      
        return total;
    }
    
    public long getTotalCustomer() {
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();        
        Query query = session.createQuery("SELECT COUNT(*) FROM Reservation ");
        
        long total =(long) query.uniqueResult();
      
        return total;
    }
    
    public long adminM() {
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();        
        Query query = session.createQuery("SELECT COUNT(*) FROM User where role='Admin'");
        
        long total =(long) query.uniqueResult();
      
        return total;
    }
    
    
    public boolean updateUsers(User u) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            session.update(u);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteUsers(User u) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(u);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
    
    public boolean addingRoom(Room room) {
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();
            session.save(room);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List allPostList(int page) {
       
        int postPerPage = 5;
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();   
        Query query = session.createQuery("SELECT p FROM Room p where book='Unbooked' ");
        query.setFirstResult(page*postPerPage);
        query.setMaxResults(postPerPage);
        
        List<Room> cList= query.list();
        
        cList.toString();
        
        for (int i = 0; i < cList.size(); i++) {
            String old = cList.get(i).getDescription();
            
            cList.get(i).setDescription(summary(old) + "...");
        }
        
        session.close();
        return cList;
    }
    
    public List allCustomer(int page) {
       
        int postPerPage = 5;
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();   
        Query query = session.createQuery("SELECT p FROM Reservation p ");
        query.setFirstResult(page*postPerPage);
        query.setMaxResults(postPerPage);
        
        List<Reservation> cList= query.list();
        
        cList.toString();
        
       
        
        session.close();
        return cList;
    }
    
    public String summary(String s){
        String summary = "";
        boolean adding = true;
        
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '<'){
                adding = false;
            }
            
            if(s.charAt(i) == '>'){
                adding = true;
            }
            
            if(adding && s.charAt(i) != '>' && s.charAt(i) != '<'){
                summary += s.charAt(i);
            }
            
            if(summary.length()>222){
                break;
            }
        }
        
        return summary;
    
    }
    
    public List singlePostList(){
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();        
        Query query = session.createQuery("SELECT p FROM Room ");
        
        
        List<Room> cList= query.list();
        cList.toString();
        session.close();
        return cList;
    }
    
    
    
}
