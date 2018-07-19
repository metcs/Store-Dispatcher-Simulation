package edu.bu.met.cs665.products;

public class SimpleChocolateBox extends GiftChocolateBox {
  public SimpleChocolateBox() {
    this.name = "Simple Chocolate Box";
  }

  @Override
  public boolean needsFreezer() {
    return false;
  }

  @Override
  public boolean needsKeepWarm() {
    return false;
  }
}
