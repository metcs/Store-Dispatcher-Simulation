package edu.bu.met.cs665.stores;

import org.junit.Before;

public class TestCandyStore {
  Store candyStore;

  @Before
  public void setUp() throws Exception {
    this.candyStore = new CandyStore();
  }

}
