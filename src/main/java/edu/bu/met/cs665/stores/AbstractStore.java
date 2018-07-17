package edu.bu.met.cs665.stores;

import java.util.List;
import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.dispatchers.StoreDispatcher;
import edu.bu.met.cs665.orders.Order;
import edu.bu.met.cs665.products.Product;

public abstract class AbstractStore implements Store {
  protected List<Product> products;
  protected Dispatcher dispatcher;
  
  public AbstractStore(){
    // The StoreDispatcher object is a singleton
    this.dispatcher = StoreDispatcher.getInstance();
    this.dispatcher.registerStore(this);
    System.out.println("In the abstract store is: " + this);
  }
  
//  @Override
//  public int hashCode() {
//    final int prime = 31;
//    int result = 1;
//    result = prime * result + ((dispatcher == null) ? 0 : dispatcher.hashCode());
//    result = prime * result + ((products == null) ? 0 : products.hashCode());
//    return result;
//  }
//
//  @Override
//  public boolean equals(Object obj) {
//    if (this == obj)
//      return true;
//    if (obj == null)
//      return false;
//    if (getClass() != obj.getClass())
//      return false;
//    AbstractStore other = (AbstractStore) obj;
//    if (dispatcher == null) {
//      if (other.dispatcher != null)
//        return false;
//    } else if (!dispatcher.equals(other.dispatcher))
//      return false;
//    if (products == null) {
//      if (other.products != null)
//        return false;
//    } else if (!products.equals(other.products))
//      return false;
//    return true;
//  }

  public List<Product> getProducts(){
    return this.products;
  }

  /**
   * Given a list of products and a customer, creates an order and sends the order
   * to the dispatcher to schedule delivery.
   */
  public void createOrder(List<Product> products, Customer customer){
    Order order =  new Order(products, customer, this);
    this.dispatcher.receiveOrder(order);
  }
  
  public Dispatcher getDispatcher(){
    return this.dispatcher;
  }
}
