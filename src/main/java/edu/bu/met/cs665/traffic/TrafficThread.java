package edu.bu.met.cs665.traffic;

import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.dispatchers.StoreDispatcher;

/**
 * A class for running a thread that mimics a traffic reporting service.
 * This will interject a high traffic event into the simulation.
 * @author Rich
 *
 */
public class TrafficThread implements Runnable{

  @Override
  public void run() {
    Dispatcher dispatcher = StoreDispatcher.getInstance();
    try {
      // Wait 2 seconds and then inject an increased traffic event
      Thread.sleep(1000);
      dispatcher.setIncreasedTraffic(true);
      // Wait 4 more seconds and then set the traffic level back to normal (less traffic)
      Thread.sleep(2000);
      dispatcher.setIncreasedTraffic(false);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }

}
