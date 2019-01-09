/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.RoomDao;

import entity.Reservation;
import entity.Room;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.primefaces.model.UploadedFile;
import util.HibernateUtil;

/**
 *
 * @author sakib
 */
@ManagedBean
@SessionScoped
public class RoomMB {
    Room hm=new Room();
    String roomnum, roomtype;
    List<Room> listroom;
    UploadedFile file;
    Reservation reservation=new Reservation();

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    
    
    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }
    
    
    public Room getHm() {
        return hm;
    }

    public void setHm(Room hm) {
        this.hm = hm;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public List<Room> getListroom() {
        return listroom;
    }

    public void setListroom(List<Room> listroom) {
        this.listroom = listroom;
    }
    
    public List<SelectItem> getRoomName(){
    
        List<SelectItem> roomname=new RoomDao().catList();
        return roomname;
    }
    
    public void type_of_room(){
        Room room=new Room();
        room.setRoomNo(room.getRoomNo());
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        Query q=session.createQuery("select al.roomType from Room al where roomNo=?");
        q.setParameter(0, room.getRoomNo());
        roomtype=q.list().toString();
        
        session.close();
        
    }
    
    public List<SelectItem> getRoomType(){
        Room r=new Room();
        r.setRoomNo(r.getRoomNo());
        List<SelectItem> roomtype=new RoomDao().typeList(r);
        return roomtype;
    }
    
    public void book_room(){
        Reservation r=new Reservation();
        r.setRoomNo(reservation.getRoomNo());
        r.setRoomType(reservation.getRoomType());
        r.setName(reservation.getName());
        r.setSex(reservation.getSex());
        r.setAddress(reservation.getAddress());
        r.setCity(reservation.getCity());
        r.setAge(reservation.getAge());
        r.setMobile(reservation.getMobile());
        r.setArrival(reservation.getArrival());
        r.setDeparture(reservation.getDeparture());
        r.setDays(reservation.getDays());
        r.setCharges(reservation.getCharges());
        r.setAdvance(reservation.getAdvance());
        String bb="Booked";
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session s=sf.openSession();
        s.beginTransaction();
        s.save(r);
        s.getTransaction().commit();
        s.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Booking Successfull", ""));
//        new RoomDao().updateRoom(hm);
        Room h=new Room();
        h.setRoomNo(reservation.getRoomNo());
//        new RoomDao().updateRoom(hm);
        if(new RoomDao().updateRoom(h)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Booking Successfull", ""));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        
    }
    
    public void get_r_type(){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session s=sf.openSession();
        s.beginTransaction();
        Query q=s.createQuery("select roomType from Room where roomNo=?");
        
        q.setParameter(0, reservation.getRoomNo());
        
        reservation.setRoomType(q.toString());
        s.getTransaction().commit();
        s.close();
    }
    
    public void addRoom(){
        upload();
        
        hm.setRoomNo(hm.getRoomNo());
        hm.setRoomType(hm.getRoomType());
        hm.setPrice(hm.getPrice());
        hm.setDiscount(hm.getDiscount());
        hm.setBook(hm.getBook());
        hm.setRUrl(hm.getRUrl());
        hm.setDescription(hm.getDescription());
        boolean status=new RoomDao().addingRoom(hm);
        if(status){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Room Added",""));
            
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Room Adding Fail",""));
        }
    }
    
    public void upload() {
        if (file != null) {
            try {
                FacesContext context = FacesContext.getCurrentInstance();
                ServletContext servletcontext = (ServletContext) context.getExternalContext().getContext();
                String dbpath = servletcontext.getRealPath("/");
                String webcut = dbpath.substring(0, dbpath.lastIndexOf("\\"));
                String biuldcut = webcut.substring(0, webcut.lastIndexOf("\\"));
                String mainURLPath = biuldcut.substring(0, biuldcut.lastIndexOf("\\"));
                InputStream inputStrim = file.getInputstream();
                String path = mainURLPath+ "\\web\\resources\\images\\" +file.getFileName();
                System.out.println(path);
                File destFile = new File(path);
                if (!destFile.exists()) {
                    FileUtils.copyInputStreamToFile(inputStrim, destFile);
                }
                hm.setRUrl(file.getFileName().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
