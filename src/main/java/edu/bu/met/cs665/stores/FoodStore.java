package edu.bu.met.cs665.stores;

import java.util.List;
import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.orders.Order;
import edu.bu.met.cs665.products.Product;

public class FoodStore implements Store{

  @Override
  public Dispatcher getDispatcher(String dispatcherName) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void submitDeliveryRequest(Order order, Customer customer) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Order createOrder(List<Product> products) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Product> productsInStore() {
    // TODO Auto-generated method stub
    return null;
  }

}
