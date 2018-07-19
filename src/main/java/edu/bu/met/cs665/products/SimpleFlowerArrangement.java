package edu.bu.met.cs665.products;

public class SimpleFlowerArrangement extends FlowerBouquet {

  public SimpleFlowerArrangement() {
    this.name = "Simple Flower Arrangement";
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
