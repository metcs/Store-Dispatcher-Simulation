package edu.bu.met.cs665.products;

public class EliteFlowerArrangement extends FlowerBouquet {

  public EliteFlowerArrangement() {
    this.name = "Elite Flower Arrangement";
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
