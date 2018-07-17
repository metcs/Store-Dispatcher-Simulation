package edu.bu.met.cs665;

import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.dispatchers.StoreDispatcher;
import edu.bu.met.cs665.vehicles.TaxiVehicle;
import edu.bu.met.cs665.vehicles.VanVehicle;
import edu.bu.met.cs665.vehicles.Vehicle;

public class Main {

  /**
   * A main method to run examples. 
   * @param args not used 
   */
  public static void main(String[] args) {
    // Per instructions:
    // 5 shops with 5 different types of products
    String birthdayStore = "Birthday Store";
    String candyStore = "Candy Store";
    String flowerStore = "Flower Store";
    String foodStore = "Food Store";
    String partyStore = "Party Store";
    // 10 customer orders
    Customer customer1 = new Customer(birthdayStore);
    customer1.order();
    Customer customer2 = new Customer(birthdayStore);
    customer2.order();
    Customer customer3 = new Customer(candyStore);
    customer3.order();
    Customer customer4 = new Customer(candyStore);
    customer4.order();
    Customer customer5 = new Customer(flowerStore);
    customer5.order();
    Customer customer6 = new Customer(flowerStore);
    customer6.order();
    Customer customer7 = new Customer(foodStore);
    customer7.order();
    Customer customer8 = new Customer(foodStore);
    customer8.order();
    Customer customer9 = new Customer(partyStore);
    customer9.order();
    Customer customer10 = new Customer(partyStore);
    customer10.order();
    
    // 10 drivers
    Vehicle vehicle1 = new VanVehicle();
    Vehicle vehicle2 = new TaxiVehicle();
    Vehicle vehicle3 = new VanVehicle();
    Vehicle vehicle4 = new TaxiVehicle();
    Vehicle vehicle5 = new VanVehicle();
    Vehicle vehicle6 = new TaxiVehicle();
    Vehicle vehicle7 = new VanVehicle();
    Vehicle vehicle8 = new TaxiVehicle();
    Vehicle vehicle9 = new VanVehicle();
    Vehicle vehicle10 = new TaxiVehicle();
    
    Thread systemMonitorThread = new Thread(new SystemMonitorThread());
    systemMonitorThread.start();
    Dispatcher dispatcher = StoreDispatcher.getInstance();
    dispatcher.dispatchVehicles();
    // 1 high traffic event

  }

}
