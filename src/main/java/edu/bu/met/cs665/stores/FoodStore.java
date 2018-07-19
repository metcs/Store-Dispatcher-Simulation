package edu.bu.met.cs665.stores;

import edu.bu.met.cs665.products.ColdMeal;
import edu.bu.met.cs665.products.HotMeal;

import java.util.ArrayList;

public class FoodStore extends AbstractStore {


  /**
   * Constructor adds products to the List of products.
   */
  public FoodStore() {
    this.products = new ArrayList<>();
    this.products.add(new ColdMeal());
    this.products.add(new HotMeal());
  }


  public String toString() {
    return "Food Store";
  }

}
