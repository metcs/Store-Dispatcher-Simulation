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

  Customer customer;
  @Before
  public void setUp() throws Exception {
    customer = new Customer();
  }

  // Test for the five types of stores
  @Test
  public void testForCorrectTypesOfStores() {
    assertThat(customer.getStore("Candy Store"), instanceOf(CandyStore.class));
    assertThat(customer.getStore("Flower Store"), instanceOf(FlowerStore.class));
    assertThat(customer.getStore("Food Store"), instanceOf(FoodStore.class));
    assertThat(customer.getStore("Birthday Store"), instanceOf(BirthdayStore.class));
    assertThat(customer.getStore("Party Store"), instanceOf(PartyStore.class));
  }

}
