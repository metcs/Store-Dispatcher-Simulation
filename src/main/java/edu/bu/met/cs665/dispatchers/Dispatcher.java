package edu.bu.met.cs665.dispatchers;

import edu.bu.met.cs665.orders.Order;
import edu.bu.met.cs665.vehicles.Vehicle;

public interface Dispatcher {
  // Handle the interaction with the vehicles
  public void registerVehicle(Vehicle vehicle);
  public void removeVehicle(Vehicle vehicle);
  public void dispatchVehicle(Vehicle vehicle, Order order);
  
  // Handle the interaction with the stores
  // Receive an order from a customer and add it to the collection of orders
  // for processing and vehicle dispatching
  public void receiveOrder(Order order);

}
