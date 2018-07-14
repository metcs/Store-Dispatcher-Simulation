package edu.bu.met.cs665.orders;

import java.util.List;
import edu.bu.met.cs665.products.Product;

public class Order {
    List<Product> products;
    public Order(List<Product> products){
      this.products = products;
    }
    
    public String toString(){
      StringBuffer returnString = new StringBuffer();
      for(Product product: products){
        returnString.append(product.toString());
      }
      return returnString.toString();
    }
}
