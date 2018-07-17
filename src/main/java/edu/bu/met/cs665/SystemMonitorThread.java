package edu.bu.met.cs665;

import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.dispatchers.StoreDispatcher;
import edu.bu.met.cs665.orders.Order;
import edu.bu.met.cs665.vehicles.Vehicle;

/**
 * This class takes care of monitoring the dispatcher singleton and printing 
 * the updated statuses to the screen
 * @author Richard hanks
 *
 */
public class SystemMonitorThread implements Runnable{

  // dispatcher is a singleton
  private Dispatcher dispatcher = StoreDispatcher.getInstance();
  @Override
  public void run() {
    // Keep track of a "clock" to display the number of time cycles that have been traversed
    int timeCounter = 0;
    // While there are orders in either the list of orders not scheduled or 
    // orders in the in transit list, keep checking the vehicle statuses
    while(((StoreDispatcher) this.dispatcher).getOrdersNotScheduled().size() > 0 ||
        ((StoreDispatcher) this.dispatcher).getOrdersInTransit().size() > 0){
      timeCounter++;
      System.out.println("\n\n Beginning time cycle number " + timeCounter + "\n\n");
      // Get all vehicles from dispatcher
      for(Vehicle vehicle: this.dispatcher.getRegisteredVehicles()){
        System.out.println("\n-----------------\n");
        System.out.println("Vehicle ID is: " + vehicle.getVIN());
        System.out.println("Vehicle available for deliveries: " + vehicle.getStatus());
//        System.out.println("Current order is: " + vehicle.getCurrentOrder());
        if(vehicle.getCurrentOrder() == null){
          System.out.println("Vehicle is not currently delivering an order.");
        }else{
          System.out.println("Vehicle is currently delivering an order with "
              + "the following products: " + vehicle.getCurrentOrder());
          System.out.println("The vehicle has traveled " + vehicle.getDistanceTravelledOnThisOrder() +
          " miles on the current order with " + vehicle.getDistanceLeftToTravelOnThisOrder() + " miles left.");
          
        }
        System.out.println("\n-----------------\n");
      }
//      System.out.println("\n\n Beginning time cycle number " + timeCounter + "\n\n");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

  }

}
