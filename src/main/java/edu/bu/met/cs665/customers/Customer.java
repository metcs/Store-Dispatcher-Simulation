package edu.bu.met.cs665.customers;

/**
 * Class that represents a customer that will place an order from a store.
 */
import edu.bu.met.cs665.dispatchers.StoreDispatcher;
import edu.bu.met.cs665.products.Product;
import edu.bu.met.cs665.stores.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Customer {
  // For the time being assume the customer can only buy this many products at a time.
  // This is for the purpose of randomly selecting products to purchase.
  static int maxNumItemsCustomerCanBuy = 10;
  private Store store;
  private int distanceFromStore;
  private Map<Store, Integer> distanceFromEachStore;
  private boolean hasBirthday;

  /**
   * Constructor.
   * @param store The store instance that this customer is shopping at.
   */
  public Customer(Store store) {
    this.store = store;
    // Get the initial random assignment of distance for this customer from each of the
    // registered stores.
    this.distanceFromEachStore =
        StoreDispatcher.getInstance().makeRandomInitialDistanceAssignments();
    // Set a random distance from the store
    distanceFromStore = new Random().nextInt(50);
    // Randomly choose if customer has a birthday
    if (distanceFromStore > 47 || distanceFromStore < 2) {
      this.hasBirthday = true;
    } else {
      this.hasBirthday = false;
    }
  }

  public Map<Store, Integer> getDistanceFromEachStore() {
    return this.distanceFromEachStore;
  }

  public boolean getHasBirthday() {
    return this.hasBirthday;
  }

  public int getDistanceFromStore() {
    return this.distanceFromStore;
  }

  /**
   * This is the method that takes care of the steps to randomly placing an order for a customer.
   */
  public void order() {
    List<Product> allProductsInStore = store.getProducts();
    List<Product> selectedProducts = selectProducts(allProductsInStore);
    placeOrder(store, selectedProducts);
  }


  public Store getStore() {
    return this.store;
  }

  /**
   * A method for randomly selecting products for this "shopping trip" from among
   * the products in the store.
   * @param allProducts  All of the products in the store the customer is shopping at.
   * @return A List of Product objects selected from among all of the products.
   */
  public List<Product> selectProducts(List<Product> allProducts) {
    List<Product> selectedProducts = new ArrayList<>();
    // Randomly choose the number of products to be purchased/selected
    int numProductsToBuy = new Random().nextInt(maxNumItemsCustomerCanBuy);
    // For the number of products to be chosen
    int randomProductIndex;
    for (int i = 0; i < numProductsToBuy; i++) {
      // Add a random product from the list of all products to the list of selected products
      randomProductIndex = new Random().nextInt(allProducts.size());
      selectedProducts.add(allProducts.get(randomProductIndex));
    }
    return selectedProducts;
  }


  // Place an order at a store with the list of products in the order
  private void placeOrder(Store store, List<Product> products) {
    store.createOrder(products, this);
  }
}
