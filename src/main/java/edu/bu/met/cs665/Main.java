package edu.bu.met.cs665;

import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.dispatchers.StoreDispatcher;
import edu.bu.met.cs665.stores.Store;
import edu.bu.met.cs665.stores.StoreFactory;
import edu.bu.met.cs665.traffic.TrafficThread;
import edu.bu.met.cs665.vehicles.TaxiVehicle;
import edu.bu.met.cs665.vehicles.VanVehicle;
import edu.bu.met.cs665.vehicles.VanVehicleWithFreezer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

  /**
   * A main method to run examples.
   * 
   * @param args not used
   */
  public static void main(String[] args) {
    // Per instructions:
    // 5 shops with 5 different types of products
    List<Store> availableStores =
        new ArrayList<>(Arrays.asList(StoreFactory.getStore("Birthday Store"),
            StoreFactory.getStore("Candy Store"), StoreFactory.getStore("Flower Store"),
            StoreFactory.getStore("Food Store"), StoreFactory.getStore("Party Store")));
    // Create numOrders number of initial orders
    int numOrders = 20;
    for (int i = 0; i < numOrders; i++) {
      new Customer(availableStores.get(new Random().nextInt(availableStores.size()))).order();
    }

    // 10 drivers
    new VanVehicleWithFreezer();
    new TaxiVehicle();
    new VanVehicle();
    new TaxiVehicle();
    new VanVehicle();
    new TaxiVehicle();
    new VanVehicle();
    new TaxiVehicle();
    new VanVehicleWithFreezer();
    new TaxiVehicle();

    // Kick off a thread that "monitors" the traffic by injecting traffic events into the system
    Thread trafficMonitorThread = new Thread(new TrafficThread());
    trafficMonitorThread.start();
    Dispatcher dispatcher = StoreDispatcher.getInstance();
    dispatcher.dispatchVehicles();
  }

}
