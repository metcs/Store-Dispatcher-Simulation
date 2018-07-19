package edu.bu.met.cs665.stores;

import edu.bu.met.cs665.products.EliteChocolateBox;
import edu.bu.met.cs665.products.SimpleChocolateBox;

import java.util.ArrayList;

public class CandyStore extends AbstractStore {

  /**
   * This comment is only here because of the Google style check.
   * This is the constructor.
   */
  public CandyStore() {
    this.products = new ArrayList<>();
    this.products.add(new EliteChocolateBox());
    this.products.add(new SimpleChocolateBox());
  }

  public String toString() {
    return "Candy Store";
  }
}
