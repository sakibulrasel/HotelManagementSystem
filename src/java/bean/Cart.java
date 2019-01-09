package bean;



import bean.FoodMB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Cart implements Serializable {
    
    private static final long serialVersionUID = 1L;
    ArrayList<FoodMB> foods = new ArrayList<FoodMB>();
    
//    public boolean add(FoodMB newfood) {
//        // if books is already in the cart then add 1 to qty 
//        FoodMB f = getBook(newfood.food.getFooId());
//        if (f != null) {
//            f.food.setQty(f.food.getQty()+ 1);
//        } else {
//            foods.add(newfood);
//        }
//        
//        return true;
//    }
    
    public ArrayList<FoodMB> getBooks() {
        return foods;
    }
    
    public double getTotal() {
        double total = 0;
        for (FoodMB food : foods) {
            total += food.food.getFNetprice();
        }
        return total;
    }
    
//    public boolean remove(String bookid) {
////        for (BookBean book : books) {
////            if (book.getBookid().equals(bookid)) {
////                books.remove(book);
////                return true;
////            }
////        }
//        Iterator<BookBean> i = books.iterator();
//        while (i.hasNext()) {
//            String s = i.next().getBookid(); // must be called before you can call i.remove()
//            if (s.equals(bookid)) {
//                i.remove();
//                return true;
//            }
//        }
//        
//        return false;
//    }
//    
//    public BookBean getBook(String bookid) {
//        for (BookBean book : books) {
//            if (book.getBookid().equals(bookid)) {
//                return book;
//            }
//        }
//        
//        return null;
//    }
}
