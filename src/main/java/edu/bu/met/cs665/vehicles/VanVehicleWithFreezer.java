package edu.bu.met.cs665.vehicles;

public class VanVehicleWithFreezer extends AbstractVehicle {

  @Override
  public boolean canTransportFrozen() {
    return true;
  }

}
