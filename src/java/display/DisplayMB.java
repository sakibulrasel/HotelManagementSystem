/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import dao.RoomDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author sakib
 */
@ManagedBean
@SessionScoped
public class DisplayMB {
    public long getTotalUser(){
        long total = new RoomDao().getTotalUser();        
        return total;
    }
    
    public long getTotalRoomManager(){
        long total = new RoomDao().getTotalManager();        
        return total;
    }
    
    public long getTotalEventManager(){
        long total = new RoomDao().getTotalEvent();        
        return total;
    }
    
    public long admin(){
        long total = new RoomDao().adminM();        
        return total;
    }
    
}
