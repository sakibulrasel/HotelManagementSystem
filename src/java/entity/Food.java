package entity;
// Generated Oct 14, 2018 8:42:03 AM by Hibernate Tools 4.3.1



/**
 * Food generated by hbm2java
 */
public class Food  implements java.io.Serializable {


     private Integer idfood;
     private String fooId;
     private String FName;
     private double FPrice;
     private double FNetprice;
     private int qty;
     private String description;
     private String FUrl;
     private double discount;

    public Food() {
    }

    public Food(String fooId, String FName, double FPrice, double FNetprice, int qty, String description, String FUrl, double discount) {
       this.fooId = fooId;
       this.FName = FName;
       this.FPrice = FPrice;
       this.FNetprice = FNetprice;
       this.qty = qty;
       this.description = description;
       this.FUrl = FUrl;
       this.discount = discount;
    }
   
    public Integer getIdfood() {
        return this.idfood;
    }
    
    public void setIdfood(Integer idfood) {
        this.idfood = idfood;
    }
    public String getFooId() {
        return this.fooId;
    }
    
    public void setFooId(String fooId) {
        this.fooId = fooId;
    }
    public String getFName() {
        return this.FName;
    }
    
    public void setFName(String FName) {
        this.FName = FName;
    }
    public double getFPrice() {
        return this.FPrice;
    }
    
    public void setFPrice(double FPrice) {
        this.FPrice = FPrice;
    }
    public double getFNetprice() {
        return this.FNetprice;
    }
    
    public void setFNetprice(double FNetprice) {
        this.FNetprice = FNetprice;
    }
    public int getQty() {
        return this.qty;
    }
    
    public void setQty(int qty) {
        this.qty = qty;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getFUrl() {
        return this.FUrl;
    }
    
    public void setFUrl(String FUrl) {
        this.FUrl = FUrl;
    }
    public double getDiscount() {
        return this.discount;
    }
    
    public void setDiscount(double discount) {
        this.discount = discount;
    }




}


