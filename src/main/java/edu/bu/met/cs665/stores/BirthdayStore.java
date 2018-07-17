package edu.bu.met.cs665.stores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.orders.Order;
import edu.bu.met.cs665.products.EliteChocolateBox;
import edu.bu.met.cs665.products.Product;
import edu.bu.met.cs665.products.SimpleFlowerArrangement;

public class BirthdayStore extends AbstractStore{

  public BirthdayStore(){
    super();
    this.products = new ArrayList<>();
    this.products.add(new EliteChocolateBox());
    this.products.add(new SimpleFlowerArrangement());
  }


  @Override
  public void submitDeliveryRequest(Order order, Customer customer) {
    // TODO Auto-generated method stub
    
  }

  public String toString(){
    return "Birthday Store";
  }
}
