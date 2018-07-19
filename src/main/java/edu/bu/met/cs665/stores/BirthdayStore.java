package edu.bu.met.cs665.stores;

import edu.bu.met.cs665.products.EliteChocolateBox;
import edu.bu.met.cs665.products.SimpleFlowerArrangement;

import java.util.ArrayList;

public class BirthdayStore extends AbstractStore {

  /**
   * This is only here to satisfy the Google style checker.
   * This is the constructor.
   */
  public BirthdayStore() {
    super();
    this.products = new ArrayList<>();
    this.products.add(new EliteChocolateBox());
    this.products.add(new SimpleFlowerArrangement());
  }

  public String toString() {
    return "Birthday Store";
  }
}
