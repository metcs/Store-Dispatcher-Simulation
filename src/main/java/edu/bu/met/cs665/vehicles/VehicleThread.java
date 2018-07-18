package edu.bu.met.cs665.vehicles;

import java.util.stream.Collectors;
import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.dispatchers.StoreDispatcher;
import edu.bu.met.cs665.orders.Order;

/**
 * A class for running a thread that simulates a vehicle delivering an order
 * @author Richard Hanks
 *
 */
public class VehicleThread implements Runnable{

  private Vehicle vehicle;
  private Order order;
  private int totalDistance;
  private Dispatcher dispatcher;
  private boolean increasedTraffic;
  
  
  public VehicleThread(Vehicle vehicle, Order order, int totalDistance){
    this.vehicle = vehicle;
    this.order = order;
    this.totalDistance = totalDistance;
    this.dispatcher = StoreDispatcher.getInstance();
    this.increasedTraffic = false;
  }
  @Override
  public void run() {
    // Vehicle is not currently available for delivery.
    // Keep a copy of the initial total distance to enable to track distance delivered so far
    // Send dispatch a message that this vehicle has begun an order.
    vehicle.sendStatusMessageToDispatch("Vehicle " + vehicle.getVIN() + " has been dispatched to deliver an order with"
        + " the following contents:\n" + vehicle.getCurrentOrder());
    
    int totalDistanceCopy = totalDistance;
//    vehicle.setAvailableForDelivery(false);
//    System.out.println("Vehicle " + vehicle.getVIN() + " has been assigned a new order with a total distance of: " + totalDistance);
    while(totalDistance > 0){
      // Set the distance traveled and distance left
      vehicle.setDistanceLeftToTravelOnThisOrder(totalDistance);
      vehicle.setDistanceTravelledOnThisOrder(totalDistanceCopy - totalDistance);
      totalDistance--;
      try {
        Thread.sleep(100L);
        vehicle.sendStatusMessageToDispatch("Vehicle " + vehicle.getVIN() + " has travled " + vehicle.getDistanceTravelledOnThisOrder() + " miles "
            + " with " + vehicle.getDistanceLeftToTravelOnThisOrder() + " miles left.");
//        System.out.println("Distance remaining is: " + totalDistance);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    // This order has now been delivered, so remove it from the inTransit list with the dispatcher
    ((StoreDispatcher) this.dispatcher).removeOrderFromInTransitOrders(order);
    // Vehicle has now "delivered" the order and then are open to receive new orders
    vehicle.setAvailableForDelivery(true);
    // Once the order has been delivered, the vehicle's new distance from each store is
    // the distance from each store of the order's customer.
    vehicle.setDistanceFromEachStore(order.getCustomer().getDistanceFromEachStore());
    String distancesToEachStore = order.getCustomer().getDistanceFromEachStore().entrySet()
        .stream()
        .map(entry -> entry.getKey() + " - " + entry.getValue() + " miles")
        .collect(Collectors.joining(", "));
    vehicle.sendStatusMessageToDispatch(("Vehicle number: " + vehicle.getVIN() + " has delivered an order.  "
        + "The new distances from each store are (types of store are listed): " + distancesToEachStore));
    // Order has been delivered, this vehicle no longer has an order so set to null
    vehicle.setCurrentOrderToNull();
  }
  


}
