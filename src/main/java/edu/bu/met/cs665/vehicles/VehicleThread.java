package edu.bu.met.cs665.vehicles;

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
  
  
  public VehicleThread(Vehicle vehicle, Order order, int totalDistance){
    this.vehicle = vehicle;
    this.order = order;
    this.totalDistance = totalDistance;
  }
  @Override
  public void run() {
    // Vehicle is not currently available for delivery.
    vehicle.setAvailableForDelivery(false);
    System.out.println("Vehicle " + vehicle.getVIN() + " has been assigned a new order with a total distance of: " + totalDistance);
    while(totalDistance > 0){
      totalDistance--;
      try {
        Thread.sleep(100L);
        System.out.println("Distance remaining is: " + totalDistance);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    // Vehicle has now "delivered" the order and then are open to receive new orders
    vehicle.setAvailableForDelivery(true);
  }

}
