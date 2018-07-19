package edu.bu.met.cs665.stores;

import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.products.Product;

import java.util.List;

public interface Store {
  // Return the dispatcher instance
  public Dispatcher getDispatcher();

  // Submit an order request to the dispatcher to have the dispatcher schedule a delivery
  // Create an order out of a list of products
  void createOrder(List<Product> products, Customer customer);

  // Return a list of the products in the store
  public List<Product> getProducts();

  void placeBirthdayOrder(Customer customer);

}
