package edu.bu.met.cs665.customers;

import java.util.List;
import edu.bu.met.cs665.products.Product;
import edu.bu.met.cs665.stores.Store;
import edu.bu.met.cs665.stores.StoreFactory;

public class Customer {
   // Factory method for getting a store instance
   Store getStore(String storeName) {
    return StoreFactory.getStore(storeName);
  }
   // Get a list of the current products from the store instance
   public List<Product> getProductsFromStore() {
    return null;
  }
   // From a list of products, select the product to be submitted in the next order
   public List<Product> selectProducts(List<Product> allProducts) {
    return null;
  }
   // Place an order at a store with the list of products in the order
   public void placeOrder(List<Product> products) {
  }
}
