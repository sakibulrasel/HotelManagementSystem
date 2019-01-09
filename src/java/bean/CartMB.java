/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.FoodDao;
import entity.Food;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.Util;

/**
 *
 * @author Another User
 */
@ManagedBean
@SessionScoped
public class CartMB {
    Food food=new Food();
    
    
    

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
    
    public String addToCart() {
        Food food = Util.getCart();
        String foodid = Util.getRequest().getParameter("foodid");
        System.out.println(foodid + " is being added to cart");
//        food=new FoodDao().cartFood(bookid);
//        food.add(food);
        List<Food> Clist=new FoodDao().cartFood(foodid);
        return "Clist";
    }
    
}
