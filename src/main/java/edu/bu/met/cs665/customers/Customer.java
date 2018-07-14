package edu.bu.met.cs665.customers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import edu.bu.met.cs665.products.Product;
import edu.bu.met.cs665.stores.Store;
import edu.bu.met.cs665.stores.StoreFactory;

public class Customer {
    // For the time being assume the customer can only buy this many products at a time.
    // This is for the purpose of randomly selecting products to purchase.
    static int maxNumItemsCustomerCanBuy = 10;
    private String storeName;
    
    public Customer(String storeName){
      this.storeName = storeName;
    }
    
    /**
     * This is the method that takes care of the steps to randomly placing an order for a customer.
     */
    public void order(){
      Store store = getStore(this.storeName);
      List<Product> allProductsInStore = store.getProducts();
      List<Product> selectedProducts = selectProducts(allProductsInStore);
      placeOrder(store, selectedProducts);
    }
    
   // Factory method for getting a store instance
   private Store getStore(String storeName) {
    return StoreFactory.getStore(storeName);
  }

   // From a list of products, select the product to be submitted in the next order
   public List<Product> selectProducts(List<Product> allProducts) {
    List<Product> selectedProducts = new ArrayList<>();
    // Randomly choose the number of products to be purchased/selected
    int numProductsToBuy = new Random().nextInt(maxNumItemsCustomerCanBuy);
    // For the number of products to be chosen
    for(int i=0; i < numProductsToBuy; i++){
      // Add a random product from the list of all products to the list of selected products
      int randomProductIndex = new Random().nextInt(allProducts.size()-1);
      selectedProducts.add(allProducts.get(randomProductIndex));
    }
    return selectedProducts;
  }
   // Place an order at a store with the list of products in the order
   private void placeOrder(Store store, List<Product> products) {
       store.createOrder(products);
  }
}
