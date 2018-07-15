package edu.bu.met.cs665.orders;

import java.util.List;
import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.products.Product;

public class Order {
    private Customer customer;
    List<Product> products;
    public Order(List<Product> products, Customer customer){
      this.products = products;
      this.customer = customer;
    }
    
    public Customer getCustomer(){
      return this.customer;
    }
    public String toString(){
      StringBuffer returnString = new StringBuffer();
      for(Product product: products){
        returnString.append(product.toString());
      }
      return returnString.toString();
    }
    
    public List<Product> getProducts(){
      return this.products;
    }
}
