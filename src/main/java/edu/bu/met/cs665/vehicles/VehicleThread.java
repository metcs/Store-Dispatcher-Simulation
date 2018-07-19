package edu.bu.met.cs665.vehicles;

import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.dispatchers.StoreDispatcher;
import edu.bu.met.cs665.orders.Order;

import java.util.stream.Collectors;

/**
 * A class for running a thread that simulates a vehicle delivering an order.
 * 
 * @author Richard Hanks
 *
 */
public class VehicleThread implements Runnable {

  private Vehicle vehicle;
  private Order order;
  private int totalDistance;
  private Dispatcher dispatcher;
  private boolean increasedTraffic;


  /**
   * To satisfy the google style check.  This is the constructor.
   * @param vehicle the vehicle instance
   * @param order the order intance
   * @param totalDistance the totalDistance the delivery will take.
   */
  public VehicleThread(Vehicle vehicle, Order order, int totalDistance) {
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
    if (this.order.getTypeOfOrder().equals("Birthday Order")) {
      vehicle.sendStatusMessageToDispatch(
          "Vehicle " + vehicle.getVIN() + " has been dispatched to deliver a BIRTHDAY order.  Order number is: " + order.getOrderNumber() + ".");
    } else {
      vehicle.sendStatusMessageToDispatch(
          "Vehicle " + vehicle.getVIN() + " has been dispatched to deliver an order with"
              + " the following contents:\n" + vehicle.getCurrentOrder() + ".  Order number is: " + order.getOrderNumber() + ".");
    }
    int totalDistanceCopy = totalDistance;
    while (totalDistance > 0) {
      // Set the distance traveled and distance left
      vehicle.setDistanceLeftToTravelOnThisOrder(totalDistance);
      vehicle.setDistanceTravelledOnThisOrder(totalDistanceCopy - totalDistance);
      totalDistance--;
      try {
        Thread.sleep(100L);
        vehicle.sendStatusMessageToDispatch("Vehicle " + vehicle.getVIN() + " has travled "
            + vehicle.getDistanceTravelledOnThisOrder() + " miles " + " with "
            + vehicle.getDistanceLeftToTravelOnThisOrder() + " miles left.");
      } catch (InterruptedException e) {
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
    String distancesToEachStore = order.getCustomer().getDistanceFromEachStore().entrySet().stream()
        .map(entry -> entry.getKey() + " - " + entry.getValue() + " miles")
        .collect(Collectors.joining(", "));
    vehicle.sendStatusMessageToDispatch(
        ("Vehicle number: " + vehicle.getVIN() + " has delivered an order.  "
            + "The new distances from each store are (types of store are listed): "
            + distancesToEachStore));
    // Order has been delivered, this vehicle no longer has an order so set to null
    vehicle.setCurrentOrderToNull();
  }

}
