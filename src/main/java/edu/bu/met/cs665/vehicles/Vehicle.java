package edu.bu.met.cs665.vehicles;

import java.util.Map;
import java.util.UUID;
import edu.bu.met.cs665.orders.Order;
import edu.bu.met.cs665.stores.Store;

public interface Vehicle {
    public void updateDispatcher(int newDistance);
    public void updateDistance(int distanceChanged);
    public void receiveMessageFromDispatch(String message);
    public boolean getStatus();
    public void toggleStatus();
    public Map<Store, Integer> getDistancesFromEachStore();
    public void deliverOrder(Order order, int totalDistance);
    public void setAvailableForDelivery(boolean available);
    public UUID getVIN();
    public Order getCurrentOrder();
    public void setCurrentOrderToNull();
    public void setDistanceTravelledOnThisOrder(int distanceTravelledOnThisORder);
    public int getDistanceTravelledOnThisOrder();
    public void setDistanceLeftToTravelOnThisOrder(int distanceLeftToTravelOnThisOrder);
    public int getDistanceLeftToTravelOnThisOrder();
    public void setDistanceFromEachStore(Map<Store, Integer> newDistanceFromEachStore);
    public void sendStatusMessageToDispatch(String message);
}
