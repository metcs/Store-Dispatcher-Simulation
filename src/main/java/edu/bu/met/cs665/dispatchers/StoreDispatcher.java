package edu.bu.met.cs665.dispatchers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import edu.bu.met.cs665.orders.Order;
import edu.bu.met.cs665.stores.Store;
import edu.bu.met.cs665.vehicles.Vehicle;

/**
 * Creates a StoreDispatcher singleton for all classes to communicate with
 * @author Richard Hanks
 *
 */
public class StoreDispatcher implements Dispatcher {
  List<Vehicle> registeredVehicles = new ArrayList<>();
  List<Store> registeredStores = new ArrayList<>();
  
  private static  StoreDispatcher storeDispatcherInstance;
  
  static{
    storeDispatcherInstance = new StoreDispatcher();
    
  }


  /**
   * Method for getting the singleton StoreDispatcher instance.
   * @return The singleton StoreDispatcher instance
   */
  public static StoreDispatcher getInstance(){
    return storeDispatcherInstance;
  }
  
  /**
   * Method for registering a vehicle with the dispatcher.  Upon successful
   * registration with the dispatcher, a map of is returned that assigns the 
   * vehicle to a distance from each store.
   */
  @Override
  public Map<Store, Integer> registerVehicle(Vehicle vehicle) {
    // Only register the vehicle if it isn't already registered
    if(!registeredVehicles.contains(vehicle)){
      registeredVehicles.add(vehicle);
    }
    return makeVehicleDistanceAssignments();
  }
  
  /**
   * 
   * @return A map where the keys are all of the registerd stores and the
   * values are randomly assigned Integer values with indicates the assigned
   * distance in arbitrary units from the the given Store key.
   */
  private Map<Store, Integer> makeVehicleDistanceAssignments(){
    Map<Store, Integer> assignmentMapping = new HashMap<>();
    int random;
    for(Store store: this.registeredStores){
      random = new Random().nextInt(50);
      assignmentMapping.put(store, random);
    }
    return assignmentMapping;
  }

  @Override
  public void removeVehicle(Vehicle vehicle) { 
      // Only try removing a vehicle from the list if it is in the list
      if(this.registeredVehicles.contains(vehicle)){
        this.registeredVehicles.remove(this.registeredVehicles.indexOf(vehicle));
      }
  }

  @Override
  public void dispatchVehicle(Vehicle vehicle, Order order) {
    // TODO Auto-generated method stub

  }

  @Override
  public void receiveOrder(Order order) {
    // TODO Auto-generated method stub

  }

  @Override
  public void updateVehicleDistance(Vehicle vehicle, int distance) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public List<Vehicle> getRegisteredVehicles() {
    return this.registeredVehicles;
  }

  @Override
  public void registerStore(Store store) {
    if(!this.registeredStores.contains(store)){
      this.registeredStores.add(store);
    }
  }

  @Override
  public void removeStore(Store store) {
    if(this.registeredStores.contains(store)){
      this.registeredStores.remove(this.registeredStores.indexOf(store));
    }
  }

}
