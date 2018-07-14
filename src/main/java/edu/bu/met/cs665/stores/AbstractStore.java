package edu.bu.met.cs665.stores;

import java.util.List;
import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.orders.Order;
import edu.bu.met.cs665.products.Product;

public abstract class AbstractStore implements Store {
  protected List<Product> products;
  
  public List<Product> getProducts(){
    return this.products;
  }

}
