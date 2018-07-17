package edu.bu.met.cs665.vehicles;

import java.util.Map;
import java.util.UUID;
import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.dispatchers.StoreDispatcher;
import edu.bu.met.cs665.orders.Order;
import edu.bu.met.cs665.stores.Store;

public abstract class AbstractVehicle implements Vehicle {

  // This is the dispatcher that will be used for all vehicles
  protected Dispatcher dispatcher;
  protected Map<Store, Integer> distanceFromEachStore;
  protected boolean availableForDelivery;
  protected UUID VIN;
  protected Order currentOrder;
  protected int distanceTravelledOnThisOrder;
  protected int distanceLeftToTravelOnThisOrder;
  
  @Override
  public int getDistanceTravelledOnThisOrder() {
    return distanceTravelledOnThisOrder;
  }

  @Override
  public void setDistanceTravelledOnThisOrder(int distanceTravelledOnThisOrder) {
    this.distanceTravelledOnThisOrder = distanceTravelledOnThisOrder;
  }

  @Override
  public int getDistanceLeftToTravelOnThisOrder() {
    return distanceLeftToTravelOnThisOrder;
  }

  @Override
  public void setDistanceLeftToTravelOnThisOrder(int distanceLeftToTravelOnThisOrder) {
    this.distanceLeftToTravelOnThisOrder = distanceLeftToTravelOnThisOrder;
  }

  /**
   * Send the dispatcher instance the updated distance for this vehicle.
   */
  @Override
  public void updateDispatcher(int newDistance) {
    dispatcher.updateVehicleDistance(this, newDistance);
  }
  
  public boolean getStatus(){
    return this.availableForDelivery;
  }
  
  public void toggleStatus(){
    this.availableForDelivery = !this.availableForDelivery;
  }
  
  /**
   * Called from the dispatcher when this vehicle is to deliver the given order
   * @param order the Order to be delivered
   * @param the total distance the vehicle will need to traverse to deliver the given order
   */
  public void deliverOrder(Order order, int totalDistance){
    // Vehicle is not currently available for delivery
//    availableForDelivery = false;
//    System.out.println("Vehicle " + VIN + " has been assigned a new order with a total distance of: " + totalDistance);
//    while(totalDistance > 0){
//      totalDistance--;
//      try {
//        Thread.sleep(100L);
//        System.out.println("Distance remaining is: " + totalDistance);
//      } catch (InterruptedException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//      }
//    }
//    this.availableForDelivery = true;
    // Run the delivery on a separate thread so the deliveries can happen concurrently
    // This is the current order on the vehicle.
    this.currentOrder = order;
    Thread deliveryThread = new Thread(new VehicleThread(this, order, totalDistance));
    deliveryThread.start();

  }
  
  /**
   * After a vehicle has delivered their order, the order instance for the vehicle
   * needs to be set back to null to signify that the vehicle doesn't have an order
   * on board.
   */
  public void setCurrentOrderToNull(){
    this.currentOrder = null;
  }
  /**
   * Updates the distance 
   */
  public void updateDistance(int distanceChanged){
    
  }
  
  public Order getCurrentOrder(){
    return this.currentOrder;
  }
  
  public UUID getVIN(){
    return this.VIN;
  }
  
  public void setAvailableForDelivery(boolean available){
    this.availableForDelivery = available;
  }
  
  public Map<Store, Integer> getDistancesFromEachStore(){
    return this.distanceFromEachStore;
  }
  
  public void receiveMessageFromDispatch(String message){
    System.out.println("The following message has been received from dispatch: " + message);
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
    this.availableForDelivery = true;
    VIN = UUID.randomUUID();
  }
  
  public void setDistanceFromEachStore(Map<Store, Integer> newDistanceFromEachStore){
    
  }

}
