package edu.bu.met.cs665.stores;


import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import edu.bu.met.cs665.dispatchers.Dispatcher;
import edu.bu.met.cs665.dispatchers.StoreDispatcher;
import edu.bu.met.cs665.products.EliteChocolateBox;
import edu.bu.met.cs665.products.Product;
import edu.bu.met.cs665.products.SimpleFlowerArrangement;

public class testBirthdayStore {
  Store store;
  @Before
  public void setUp() throws Exception {
    store = new BirthdayStore();
  }

  @Test
  public void testStoreProducts() {
//    List<Product> expectedProducts = new ArrayList<>(Arrays.asList(new EliteChocolateBox()));
    List<Product> actualProducts = store.getProducts();
    assertThat(actualProducts.get(0), instanceOf(EliteChocolateBox.class));
    assertThat(actualProducts.get(1), instanceOf(SimpleFlowerArrangement.class));
  }
  
  @Test
  public void testThatDispatcherIsASingleton(){
    Dispatcher expectedSingleton = StoreDispatcher.getInstance();
    Dispatcher actualDispatcher = store.getDispatcher();
    assertEquals(expectedSingleton, actualDispatcher);
  }

}
