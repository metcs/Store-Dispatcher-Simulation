package edu.bu.met.cs665.customers;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import edu.bu.met.cs665.stores.BirthdayStore;
import edu.bu.met.cs665.stores.CandyStore;
import edu.bu.met.cs665.stores.FlowerStore;
import edu.bu.met.cs665.stores.FoodStore;
import edu.bu.met.cs665.stores.PartyStore;
import edu.bu.met.cs665.stores.Store;
import edu.bu.met.cs665.stores.StoreFactory;


public class testCustomer {

  Customer customerCandyStore;
  Customer customerFlowerStore;
  Customer customerFoodStore;
  Customer customerBirthdayStore;
  Customer customerPartyStore;

  @Before
  public void setUp() throws Exception {
    Store birthdayStore = StoreFactory.getStore("Birthday Store");
    Store candyStore = StoreFactory.getStore("Candy Store");
    Store flowerStore = StoreFactory.getStore("Flower Store");
    Store foodStore = StoreFactory.getStore("Food Store");
    Store partyStore = StoreFactory.getStore("Party Store");
    customerCandyStore = new Customer(candyStore);
    customerFlowerStore = new Customer(flowerStore);
    customerFoodStore = new Customer(foodStore);
    customerBirthdayStore = new Customer(birthdayStore);
    customerPartyStore = new Customer(partyStore);
  }

  // Test for the five types of stores
  @Test
  public void testForCorrectTypesOfStores() {
    assertThat(customerCandyStore.getStore(), instanceOf(CandyStore.class));
    assertThat(customerFlowerStore.getStore(), instanceOf(FlowerStore.class));
    assertThat(customerFoodStore.getStore(), instanceOf(FoodStore.class));
    assertThat(customerBirthdayStore.getStore(), instanceOf(BirthdayStore.class));
    assertThat(customerPartyStore.getStore(), instanceOf(PartyStore.class));
  }

}
