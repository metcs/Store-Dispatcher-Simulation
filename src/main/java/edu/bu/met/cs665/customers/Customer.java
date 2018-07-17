package edu.bu.met.cs665.customers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import edu.bu.met.cs665.dispatchers.StoreDispatcher;
import edu.bu.met.cs665.products.Product;
import edu.bu.met.cs665.stores.Store;
import edu.bu.met.cs665.stores.StoreFactory;

public class Customer {
    // For the time being assume the customer can only buy this many products at a time.
    // This is for the purpose of randomly selecting products to purchase.
    static int maxNumItemsCustomerCanBuy = 10;
    private String storeName;
    private Store store;
    private int distanceFromStore;
    private Map<Store, Integer> distanceFromEachStore;
    
    public Customer(String storeName){
      this.storeName = storeName;
      store = setStore(this.storeName);
      // Get the initial random assignment of distance for this customer from each of the
      // registered stores.
      this.distanceFromEachStore = StoreDispatcher.getInstance().makeRandomInitialDistanceAssignments();
      // Set a random distance from the store
      distanceFromStore = new Random().nextInt(50);
    }
    
    public Map<Store, Integer> getDistanceFromEachStore(){
      return this.distanceFromEachStore;
    }
    
    public int getDistanceFromStore(){
      return this.distanceFromStore;
    }
    
    /**
     * This is the method that takes care of the steps to randomly placing an order for a customer.
     */
    public void order(){
      List<Product> allProductsInStore = store.getProducts();
      List<Product> selectedProducts = selectProducts(allProductsInStore);
      placeOrder(store, selectedProducts);
    }
    
   /**
    * Factory method for setting the store instance.
    * @param storeName The name of the store to use as a lookup for the
    *        specific store instance type.
    * @return  The Store instance to be used.
    * @Precondition storeName is a valid name of a store type.
    */
   private Store setStore(String storeName) {
    return StoreFactory.getStore(storeName);
  }
   
   public Store getStore(){
     return this.store;
   }

   // From a list of products, select the product to be submitted in the next order
   public List<Product> selectProducts(List<Product> allProducts) {
    List<Product> selectedProducts = new ArrayList<>();
    // Randomly choose the number of products to be purchased/selected
    int numProductsToBuy = new Random().nextInt(maxNumItemsCustomerCanBuy);
    // For the number of products to be chosen
    int randomProductIndex;
    for(int i=0; i < numProductsToBuy; i++){
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
