package edu.bu.met.cs665.vehicles;

import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.dispatchers.StoreDispatcher;

public abstract class AbstractVehicle implements Vehicle {

  // This is the dispatcher that will be used for all vehicles
  protected Dispatcher dispatcher;
  
  /**
   * Send the dispatcher instance the updated distance for this vehicle.
   */
  @Override
  public void updateDispatcher(int newDistance) {
    dispatcher.updateVehicleDistance(this, newDistance);
  }
  
  /**
   * Vehicles will be passed the Dispatcher object to communicate with.
   * @param dispatcher
   */
  public AbstractVehicle(Dispatcher dispatcher){
    this.dispatcher = dispatcher;
  }

}
