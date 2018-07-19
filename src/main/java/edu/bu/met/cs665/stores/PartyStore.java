package edu.bu.met.cs665.stores;

import edu.bu.met.cs665.products.ColdMeal;
import edu.bu.met.cs665.products.EliteFlowerArrangement;
import edu.bu.met.cs665.products.HotMeal;
import edu.bu.met.cs665.products.SimpleChocolateBox;

import java.util.ArrayList;

public class PartyStore extends AbstractStore {

  /**
   * This is only here to satisfy the Google style checker.
   * This is the constructor.
   */
  public PartyStore() {
    this.products = new ArrayList<>();
    this.products.add(new EliteFlowerArrangement());
    this.products.add(new HotMeal());
    this.products.add(new ColdMeal());
    this.products.add(new SimpleChocolateBox());
  }


  public String toString() {
    return "Party Store";
  }
}
