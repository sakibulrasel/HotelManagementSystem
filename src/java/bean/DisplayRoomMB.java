/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.RoomDao;
import entity.Room;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author sakib
 */
@ManagedBean
@SessionScoped
public class DisplayRoomMB {
    Room room=new Room();
    String next="0";
    String keyword;
    
    String singlePostId;
    String singlePostTitle;

    public String getSinglePostId() {
        return singlePostId;
    }

    public void setSinglePostId(String singlePostId) {
        this.singlePostId = singlePostId;
    }

    public String getSinglePostTitle() {
        return singlePostTitle;
    }

    public void setSinglePostTitle(String singlePostTitle) {
        this.singlePostTitle = singlePostTitle;
    }
    
    

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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
    
    public List<Room> getAllPosts(){
        List<Room> plist = new RoomDao().allPostList(nextPageNumber()-1);        
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
    
    public String urlEncode(String s){
        return s.replace(" ", "-");
    }
    
    public List<Room> getSinglePost(){    
        
        
        
        List<Room> plist = new RoomDao().singlePostList();        
        return plist;
    }
}
