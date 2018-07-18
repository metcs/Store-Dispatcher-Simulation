package edu.bu.met.cs665.products;

public class SimpleFlowerArrangement extends FlowerBouquet{
  
    public SimpleFlowerArrangement(){
      this.name = "Simple Flower Arrangement";
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
