package edu.bu.met.cs665.stores;

/**
 * A factory for creating Store instances based on a given string storeName.
 * 
 * @author Rich
 *
 */
public class StoreFactory {
  /**
   * This is the factory method for selecting the Store instance.
   * @param storeName The name of the store that maps to the store instance.
   * @return The Store instance that maps to storeName.
   */
  public static Store getStore(String storeName) {
    Store store = null;
    switch (storeName) {
      case "Candy Store":
        store = new CandyStore();
        break;
      case "Flower Store":
        store = new FlowerStore();
        break;
      case "Food Store":
        store = new FoodStore();
        break;
      case "Birthday Store":
        store = new BirthdayStore();
        break;
      case "Party Store":
        store = new PartyStore();
        break;
      default:
        store = null;
    }
    return store;
  }
}
