package edu.bu.met.cs665.stores;

import java.util.List;
import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.orders.Order;
import edu.bu.met.cs665.products.Product;

public interface Store {
    // Return the dispatcher instance
    public Dispatcher getDispatcher();
    // Submit an order request to the dispatcher to have the dispatcher schedule a delivery
    void submitDeliveryRequest(Order order, Customer customer);
    // Create an order out of a list of products
    void createOrder(List<Product> products, Customer customer);
    // Return a list of the products in the store
    public List<Product> getProducts();
    void placeBirthdayOrder(Customer customer);
    
}
