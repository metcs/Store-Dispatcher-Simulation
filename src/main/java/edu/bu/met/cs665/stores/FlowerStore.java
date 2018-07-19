package edu.bu.met.cs665.stores;

import edu.bu.met.cs665.products.EliteFlowerArrangement;
import edu.bu.met.cs665.products.SimpleFlowerArrangement;

import java.util.ArrayList;

public class FlowerStore extends AbstractStore {

  /**
   * This is only here to satisfy the google style checker.
   */
  public FlowerStore() {
    this.products = new ArrayList<>();
    this.products.add(new SimpleFlowerArrangement());
    this.products.add(new EliteFlowerArrangement());
  }


  public String toString() {
    return "Flower Store";
  }
}
