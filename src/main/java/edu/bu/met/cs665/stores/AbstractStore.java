package edu.bu.met.cs665.stores;

import java.util.List;
import edu.bu.met.cs665.orders.Order;
import edu.bu.met.cs665.products.Product;

public abstract class AbstractStore implements Store {
  protected List<Product> products;
  
  public List<Product> getProducts(){
    return this.products;
  }

  public void createOrder(List<Product> products){
    Order order =  new Order(products);
    System.out.println("A new order has been received with the following products: " + order);
  }
}
