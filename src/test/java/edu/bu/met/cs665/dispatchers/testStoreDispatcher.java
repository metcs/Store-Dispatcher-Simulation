package edu.bu.met.cs665.dispatchers;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import edu.bu.met.cs665.vehicles.VanVehicle;
import edu.bu.met.cs665.vehicles.Vehicle;

public class testStoreDispatcher {

  Dispatcher dispatcher;
  Vehicle vehicle;
  @Before
  public void setUp() throws Exception {
    dispatcher = StoreDispatcher.getInstance();
    vehicle = new VanVehicle();
  }

  @Test
  public void testThatVehicleCanBeRegistered() {
    // Get the current list of vehicles
    List<Vehicle> initialVehiclesState = dispatcher.getRegisteredVehicles();
    // Test that the vehicle instance is not in the first list
    assertFalse(initialVehiclesState.contains(vehicle));
    // Register vehicle
    dispatcher.registerVehicle(vehicle);
    // Test that the vehicle has now been registered
    assertTrue(initialVehiclesState.contains(vehicle));
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
    assertFalse(dispatcher.getRegisteredVehicles().contains(vehicle));
  }
  
  @Test
  public void testThatVechicleCanOnlyOccurInRegistryOnce(){
    // Test the initial state has zero occurrences of vehicle
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
    dispatcher.removeVehicle(new VanVehicle());
  }
}
