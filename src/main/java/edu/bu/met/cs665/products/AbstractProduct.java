package edu.bu.met.cs665.products;

public abstract class AbstractProduct implements Product{
  protected String name;
  
  public String getName(){
    return this.name;
  }
  
  public String toString(){
    return this.getName();
  }
}
