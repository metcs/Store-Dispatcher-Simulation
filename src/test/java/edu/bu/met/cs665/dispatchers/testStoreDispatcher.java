package edu.bu.met.cs665.dispatchers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.orders.Order;
import edu.bu.met.cs665.products.Product;
import edu.bu.met.cs665.vehicles.VanVehicle;
import edu.bu.met.cs665.vehicles.Vehicle;

public class testStoreDispatcher {

  Dispatcher dispatcher;
  Vehicle vehicle;
  @Before
  public void setUp() throws Exception {
    // Because this is a Singleton object, properties on this object will NOT be reset
    // at the beginning of each test as  you would expect in setUp()
    dispatcher = StoreDispatcher.getInstance();
    vehicle = new VanVehicle();
  }

  @Test
  public void testThatVehicleCanBeRegistered() {
    // Get the current list of vehicles
    List<Vehicle> initialVehiclesState = dispatcher.getRegisteredVehicles();
    // Test that the vehicle instance is not in the first list
    System.out.println("This one:");
    assertTrue(initialVehiclesState.contains(vehicle));
    // Register vehicle
    dispatcher.registerVehicle(vehicle);
    // Test that the vehicle has now been registered
    assertEquals((initialVehiclesState.contains(vehicle)), true);
//    assertFalse(!(initialVehiclesState.contains(vehicle)));
  }

  @Test
  public void testThatVehicleCanBeUnRegistered(){
    // Register vehicle
    dispatcher.registerVehicle(vehicle);
    // Test the initial state contains the registered vehicle
    assertTrue(dispatcher.getRegisteredVehicles().contains(vehicle));
    // Unregister the vehicle
    dispatcher.removeVehicle(vehicle);
    // Test that the vehicle is no longer registered
    assertEquals((dispatcher.getRegisteredVehicles().contains(vehicle)), false);
//    assertTrue(!(dispatcher.getRegisteredVehicles().contains(vehicle)));
  }
  
  @Test
  public void testThatVechicleCanOnlyOccurInRegistryOnce(){
    // Test the initial state has zero occurrences of vehicle
    // Need to throw this check in because dispatcher is a Singleton and
    // This vehicle may have already been assigned in previous test methods.
    if(dispatcher.getRegisteredVehicles().indexOf(vehicle) != -1){
      dispatcher.removeVehicle(vehicle);
    }
    int firstIndex = dispatcher.getRegisteredVehicles().indexOf(vehicle);
    assertEquals(firstIndex, -1);
    // Add vehicle to registry twice
    dispatcher.registerVehicle(vehicle);
    dispatcher.registerVehicle(vehicle);
    // Test that the vehicle was only registered once
    //  (if the first index and last index are the same then it only exists once)
    assertEquals(dispatcher.getRegisteredVehicles().indexOf(vehicle),
        dispatcher.getRegisteredVehicles().lastIndexOf(vehicle));
  }
  
  @Test
  public void testApplicationDoesntErrorWhenTryingToRemoveUnregisteredVehicle(){
    // If an exception is thrown, this test will fail.  
    dispatcher.removeVehicle(new VanVehicle());
  }
  
  @Test
  public void testRecieveOrderAddsToOrdersToBeScheduledList(){
    
    Order orderToBeTested = new Order(new ArrayList<Product>(), new Customer("Birthday Store"));
    List<Order> ordersStateBeforeAddedOrder = ((StoreDispatcher) dispatcher).getOrdersNotScheduled();
    // Check that the order is not in the first state
    assertFalse(ordersStateBeforeAddedOrder.contains(orderToBeTested));
    // Add the order
    dispatcher.receiveOrder(orderToBeTested);
    // Check that the order is in the list after being sent to the dispatcher
    assertEquals((((StoreDispatcher) dispatcher).getOrdersNotScheduled().contains(orderToBeTested)), true);
  }
}
