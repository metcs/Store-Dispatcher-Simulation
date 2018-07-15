package edu.bu.met.cs665.stores;

import java.util.ArrayList;
import java.util.List;
import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.orders.Order;
import edu.bu.met.cs665.products.ColdMeal;
import edu.bu.met.cs665.products.HotMeal;
import edu.bu.met.cs665.products.Product;

public class FoodStore extends AbstractStore{


  public FoodStore(){
    this.products = new ArrayList<>();
    this.products.add(new ColdMeal());
    this.products.add(new HotMeal());
  }


  @Override
  public void submitDeliveryRequest(Order order, Customer customer) {
    // TODO Auto-generated method stub
    
  }


}
