package edu.bu.met.cs665.products;

public class ColdMeal extends Food {


  public ColdMeal() {
    this.name = "Cold Meal";
  }

  @Override
  public boolean needsFreezer() {
    return true;
  }

  @Override
  public boolean needsKeepWarm() {
    return false;
  }
}
