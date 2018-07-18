package edu.bu.met.cs665.products;

public class SimpleChocolateBox extends GiftChocolateBox{
    public SimpleChocolateBox(){
      this.name = "Simple Chocolate Box";
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
