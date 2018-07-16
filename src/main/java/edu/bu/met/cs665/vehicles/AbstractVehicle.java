package edu.bu.met.cs665.vehicles;

import java.util.Map;
import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.dispatchers.StoreDispatcher;
import edu.bu.met.cs665.stores.Store;

public abstract class AbstractVehicle implements Vehicle {

  // This is the dispatcher that will be used for all vehicles
  protected Dispatcher dispatcher;
  protected Map<Store, Integer> distanceFromEachStore;
  /**
   * Send the dispatcher instance the updated distance for this vehicle.
   */
  @Override
  public void updateDispatcher(int newDistance) {
    dispatcher.updateVehicleDistance(this, newDistance);
  }
  
  /**
   *Assign the dispatcher instance to the singleton StoreDispatcher
   *and register with the dispatcher.
   * 
   */
  public AbstractVehicle(){
    // Dispatcher is a singleton
    this.dispatcher = StoreDispatcher.getInstance();
    this.distanceFromEachStore = this.dispatcher.registerVehicle(this);
  }

}
