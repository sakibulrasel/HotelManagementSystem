/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.RoomDao;
import entity.User;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author Another User
 */
@ManagedBean
@SessionScoped
public class UserMB {
    User user=new User();
    String next="0";
    User selectedUser;

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }
    
    

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public void add_user(){
        User u=new User();
        u.setUname(user.getUname());
        u.setPass(user.getPass());
        u.setRole(user.getRole());
        u.setFullname(user.getFullname());
        u.setUEmail(user.getUEmail());
        u.setURegDate(new Date());
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session s=sf.openSession();
        s.beginTransaction();
        s.save(u);
        s.getTransaction().commit();
        s.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "User Created Successfully", ""));
    }
    
    public List<User> getAllUsers(){
        List<User> clist = new RoomDao().allUsersList(nextPageNumber()-1);        
        return clist;
    }
    
    public int nextPageNumber(){
        int nextPageNumber = 1;
        try {
            nextPageNumber = Integer.parseInt(next)+1;
        } catch (Exception e) {
        }
        
        return nextPageNumber;
    }
    
    public String updateUser(){
        System.out.println("updating User...");
        selectedUser.setFullname(selectedUser.getFullname());
        selectedUser.setUEmail(selectedUser.getUEmail());
        selectedUser.setPass(selectedUser.getPass());
        selectedUser.setRole(selectedUser.getRole());
        
       
                
        if(new RoomDao().updateUsers(selectedUser)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "User updated successfully", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        return null;
    }
    
    public String deleteUsers(){
        System.out.println("deleting Users...");
        
               
        if(new RoomDao().deleteUsers(selectedUser)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "User deleted successfully", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        return null;
    }
    
}
