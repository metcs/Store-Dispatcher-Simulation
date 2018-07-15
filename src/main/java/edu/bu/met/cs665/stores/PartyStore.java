package edu.bu.met.cs665.stores;

import java.util.ArrayList;
import java.util.List;
import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.orders.Order;
import edu.bu.met.cs665.products.ColdMeal;
import edu.bu.met.cs665.products.EliteFlowerArrangement;
import edu.bu.met.cs665.products.HotMeal;
import edu.bu.met.cs665.products.Product;
import edu.bu.met.cs665.products.SimpleChocolateBox;

public class PartyStore extends AbstractStore{
  
  public PartyStore(Dispatcher dispatcher){
    super(dispatcher);
    this.products = new ArrayList<>();
    this.products.add(new EliteFlowerArrangement());
    this.products.add(new HotMeal());
    this.products.add(new ColdMeal());
    this.products.add(new SimpleChocolateBox());
  }

  @Override
  public Dispatcher getDispatcher(String dispatcherName) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void submitDeliveryRequest(Order order, Customer customer) {
    // TODO Auto-generated method stub
    
  }

}
