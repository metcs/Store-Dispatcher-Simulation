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


public class testCustomer {

  Customer customerCandyStore;
  Customer customerFlowerStore;
  Customer customerFoodStore;
  Customer customerBirthdayStore;
  Customer customerPartyStore;
  @Before
  public void setUp() throws Exception {
    customerCandyStore = new Customer("Candy Store");
    customerFlowerStore = new Customer("Flower Store");
    customerFoodStore = new Customer("Food Store");
    customerBirthdayStore = new Customer("Birthday Store");
    customerPartyStore = new Customer("Party Store");
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
