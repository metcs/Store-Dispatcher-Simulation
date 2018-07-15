package edu.bu.met.cs665.stores;

import edu.bu.met.cs665.dispatchers.Dispatcher;

public class StoreFactory {
    static public Store getStore(String storeName, Dispatcher dispatcher){
      Store store = null;
      switch(storeName){
        case "Candy Store":
          store = new CandyStore(dispatcher);
          break;
        case "Flower Store":
          store = new FlowerStore(dispatcher);
          break;
        case "Food Store":
          store = new FoodStore(dispatcher);
          break;
        case "Birthday Store":
          store = new BirthdayStore(dispatcher);
          break;
        case "Party Store":
          store = new PartyStore(dispatcher);
          break;
         default:
           store = null;
      }
      return store;
    }
}
