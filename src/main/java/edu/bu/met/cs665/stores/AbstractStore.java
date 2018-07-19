package edu.bu.met.cs665.stores;

import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.dispatchers.StoreDispatcher;
import edu.bu.met.cs665.orders.BirthdayOrder;
import edu.bu.met.cs665.orders.Order;
import edu.bu.met.cs665.products.Product;

import java.util.List;

public abstract class AbstractStore implements Store {
  protected List<Product> products;
  protected Dispatcher dispatcher;

  /**
   * This is only here to satisfy the Google style checker.
   * This is the constructor.
   */
  public AbstractStore() {
    // The StoreDispatcher object is a singleton
    this.dispatcher = StoreDispatcher.getInstance();
    this.dispatcher.registerStore(this);
  }


  public List<Product> getProducts() {
    return this.products;
  }

  /**
   * Given a list of products and a customer, creates an order and sends the order to the dispatcher
   * to schedule delivery.
   */
  public void createOrder(List<Product> products, Customer customer) {
    Order order = new Order(products, customer, this);
    this.dispatcher.receiveOrder(order);
    if (customer.getHasBirthday()) {
      System.out.println("Customer has a birthday!  Sending out some chocolate and flowers!");
      this.placeBirthdayOrder(customer);
    }
  }

  public Dispatcher getDispatcher() {
    return this.dispatcher;
  }

  public void placeBirthdayOrder(Customer customer) {
    dispatcher.placeBirthdayOrder(new BirthdayOrder(customer, this));
  }
}
