/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.FoodDao;
import dao.RoomDao;
import entity.Food;
import entity.User;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author sakib
 */
@ManagedBean
@SessionScoped
public class FoodMB {
    public Food food=new Food();
    UploadedFile file;
    String next="0";
    Food selectedFood;

    public Food getSelectedFood() {
        return selectedFood;
    }

    public void setSelectedFood(Food selectedFood) {
        this.selectedFood = selectedFood;
    }
    
    

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
    
    

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    
    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
    
    public void addFood(){
        upload();
        
        food.setFooId(food.getFooId());
        food.setFName(food.getFName());
        food.setFPrice(food.getFPrice());
        food.setFNetprice(food.getFNetprice());
        food.setQty(food.getQty());
        food.setDescription(food.getDescription());
        food.setFUrl(food.getFUrl());
        food.setDiscount(food.getDiscount());
     
        
        boolean status=new FoodDao().addingFood(food);
        if(status){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Food Added",""));
            
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Food Adding Fail",""));
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
                String path = mainURLPath+ "\\web\\resources\\fimages\\" +file.getFileName();
                System.out.println(path);
                File destFile = new File(path);
                if (!destFile.exists()) {
                    FileUtils.copyInputStreamToFile(inputStrim, destFile);
                }
                food.setFUrl(file.getFileName().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
    }
    
     public List<Food> getAllFoods(){
        List<Food> clist = new FoodDao().allFoodList(nextPageNumber()-1);        
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
     
     public String updateFood(){
        System.out.println("updating Food...");
        selectedFood.setFName(selectedFood.getFName());
        selectedFood.setFPrice(selectedFood.getFPrice());
        selectedFood.setDiscount(selectedFood.getDiscount());
        selectedFood.setFNetprice(selectedFood.getFNetprice());

                
        if(new FoodDao().updateFood(selectedFood)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "User updated successfully", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        return null;
    }
     
     public String deleteUsers(){
        System.out.println("deleting Users...");
        
               
        if(new FoodDao().deleteFood(selectedFood)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "User deleted successfully", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        return null;
    }
    
}
