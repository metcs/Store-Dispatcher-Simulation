package edu.bu.met.cs665.products;

public class HotMeal extends Food {

  public HotMeal() {
    this.name = "Hot Meal";
  }

  @Override
  public boolean needsFreezer() {
    return false;
  }

  @Override
  public boolean needsKeepWarm() {
    return true;
  }

}
