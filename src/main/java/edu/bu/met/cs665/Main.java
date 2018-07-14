package edu.bu.met.cs665;

import edu.bu.met.cs665.customers.Customer;

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
    Customer customer3 = new Customer(candyStore);
    Customer customer4 = new Customer(candyStore);
    Customer customer5 = new Customer(flowerStore);
    Customer customer6 = new Customer(flowerStore);
    Customer customer7 = new Customer(foodStore);
    Customer customer8 = new Customer(foodStore);
    Customer customer9 = new Customer(partyStore);
    Customer customer10 = new Customer(partyStore);
    
    // 10 drivers
    // 1 high traffic event

  }

}
