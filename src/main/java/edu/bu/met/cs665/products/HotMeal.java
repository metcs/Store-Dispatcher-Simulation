package edu.bu.met.cs665.products;

public class HotMeal extends Food{

  public HotMeal(){
    this.name = "Hot Meal";
  }

  @Override
  public boolean needsFreezer() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean needsKeepWarm() {
    // TODO Auto-generated method stub
    return true;
  }

}
