package edu.bu.met.cs665.products;

public class EliteChocolateBox extends GiftChocolateBox {

  public EliteChocolateBox(){
    this.name = "Elite Chocolate Box";
  }

  @Override
  public boolean needsFreezer() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean needsKeepWarm() {
    // TODO Auto-generated method stub
    return false;
  }

}
