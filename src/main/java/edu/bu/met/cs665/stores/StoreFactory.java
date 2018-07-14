package edu.bu.met.cs665.stores;

public class StoreFactory {
    static public Store getStore(String storeName){
      Store store = null;
      switch(storeName){
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
