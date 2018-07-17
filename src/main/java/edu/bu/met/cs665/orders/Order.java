package edu.bu.met.cs665.orders;

import java.util.List;
import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.products.Product;
import edu.bu.met.cs665.stores.Store;

public class Order {
    private Customer customer;
    List<Product> products;
    private Store store;
    
    public Order(List<Product> products, Customer customer, Store store){
      this.products = products;
      this.customer = customer;
      this.store = store;
    }
    
    public Store getStore(){
      return this.store;
    }
    
    public Customer getCustomer(){
      return this.customer;
    }
    public String toString(){
      StringBuffer returnString = new StringBuffer();
      for(Product product: products){
        returnString.append(product.toString() + ", ");
      }
      if(returnString.length() > 0){
        return returnString.toString().substring(0, returnString.length()-2);
      }
      return returnString.toString();
    }
    
    public List<Product> getProducts(){
      return this.products;
    }
}
