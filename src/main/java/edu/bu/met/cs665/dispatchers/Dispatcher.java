package edu.bu.met.cs665.dispatchers;

import java.util.List;
import java.util.Map;
import edu.bu.met.cs665.orders.Order;
import edu.bu.met.cs665.stores.Store;
import edu.bu.met.cs665.vehicles.Vehicle;

public interface Dispatcher {
  // Handle the interaction with the vehicles
  public Map<Store, Integer> registerVehicle(Vehicle vehicle);
  public void removeVehicle(Vehicle vehicle);
  public void dispatchVehicle(Vehicle vehicle, Order order);
  public void updateVehicleDistance(Vehicle vehicle, int distance);
  public List<Vehicle> getRegisteredVehicles();
  public void registerStore(Store store);
  public void removeStore(Store store);
  public void dispatchVehicles();
  public void displayMessageFromVehicle(String message);
  public void setIncreasedTraffic(boolean increased);
  
  // Handle the interaction with the stores
  // Receive an order from a customer and add it to the collection of orders
  // for processing and vehicle dispatching
  public void receiveOrder(Order order);

}
