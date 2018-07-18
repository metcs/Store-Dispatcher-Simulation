package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.dispatchers.StoreDispatcher;
import edu.bu.met.cs665.stores.Store;
import edu.bu.met.cs665.stores.StoreFactory;
import edu.bu.met.cs665.traffic.TrafficThread;
import edu.bu.met.cs665.vehicles.TaxiVehicle;
import edu.bu.met.cs665.vehicles.VanVehicle;
import edu.bu.met.cs665.vehicles.VanVehicleWithFreezer;
import edu.bu.met.cs665.vehicles.Vehicle;

public class Main {

  /**
   * A main method to run examples. 
   * @param args not used 
   */
  public static void main(String[] args) {
    // Per instructions:
    // 5 shops with 5 different types of products
//    String birthdayStore = "Birthday Store";
//    String candyStore = "Candy Store";
//    String flowerStore = "Flower Store";
//    String foodStore = "Food Store";
//    String partyStore = "Party Store";
//    Store birthdayStore = StoreFactory.getStore("Birthday Store");
//    Store candyStore = StoreFactory.getStore("Candy Store");
//    Store flowerStore = StoreFactory.getStore("Flower Store");
//    Store foodStore = StoreFactory.getStore("Food Store");
//    Store partyStore = StoreFactory.getStore("Party Store");
    // Create the store instances using the factory pattern
    List<Store> availableStores = new ArrayList<>(Arrays.asList(StoreFactory.getStore("Birthday Store"),
        StoreFactory.getStore("Candy Store"), StoreFactory.getStore("Flower Store"),
        StoreFactory.getStore("Food Store"), StoreFactory.getStore("Party Store")));
    // Create numOrders number of initial orders
    int numOrders = 20;
    for(int i=0; i < numOrders; i++){
      new Customer(availableStores.get(new Random().nextInt(availableStores.size()))).order();
    }
//    // 10 customer orders
//    Customer customer1 = new Customer(birthdayStore);
//    customer1.order();
//    Customer customer2 = new Customer(birthdayStore);
//    customer2.order();
//    Customer customer3 = new Customer(candyStore);
//    customer3.order();
//    Customer customer4 = new Customer(candyStore);
//    customer4.order();
//    Customer customer5 = new Customer(flowerStore);
//    customer5.order();
//    Customer customer6 = new Customer(flowerStore);
//    customer6.order();
//    Customer customer7 = new Customer(foodStore);
//    customer7.order();
//    Customer customer8 = new Customer(foodStore);
//    customer8.order();
//    Customer customer9 = new Customer(partyStore);
//    customer9.order();
//    Customer customer10 = new Customer(partyStore);
//    customer10.order();
    
    // 10 drivers
    Vehicle vehicle1 = new VanVehicleWithFreezer();
    Vehicle vehicle2 = new TaxiVehicle();
    Vehicle vehicle3 = new VanVehicle();
    Vehicle vehicle4 = new TaxiVehicle();
    Vehicle vehicle5 = new VanVehicle();
    Vehicle vehicle6 = new TaxiVehicle();
    Vehicle vehicle7 = new VanVehicle();
    Vehicle vehicle8 = new TaxiVehicle();
    Vehicle vehicle9 = new VanVehicleWithFreezer();
    Vehicle vehicle10 = new TaxiVehicle();
    
    // Kick off a thread that "monitors" the traffic by injecting traffic events into the system
    Thread trafficMonitorThread = new Thread(new TrafficThread());
    trafficMonitorThread.start();
    Dispatcher dispatcher = StoreDispatcher.getInstance();
    dispatcher.dispatchVehicles();
    // 1 high traffic event

  }

}
