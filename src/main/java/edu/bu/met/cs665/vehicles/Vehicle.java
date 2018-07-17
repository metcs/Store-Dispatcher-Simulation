package edu.bu.met.cs665.vehicles;

import java.util.Map;
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
}
