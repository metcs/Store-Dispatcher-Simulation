package edu.bu.met.cs665.orders;

import java.util.List;
import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.products.Product;
import edu.bu.met.cs665.stores.Store;

public class Order {
    private Customer customer;
    List<Product> products;
    private Store store;
    private boolean keepOrderFrozen;
    protected String typeOfOrder;
    
    public Order(List<Product> products, Customer customer, Store store){
      // Determine if this order will need to be frozen based on the products in the order
      for(Product product: products){
        if(product.needsFreezer()){
          // If a single product needs to be frozen, the whole order needs to be frozen.
          this.keepOrderFrozen = true;
          break;
        }
      }
      this.products = products;
      this.customer = customer;
      this.store = store;
      this.setTypeOfOrder();
    }
    
    private void setTypeOfOrder() {
      this.typeOfOrder =  "Normal Order";
    }
    
    public String getTypeOfOrder(){
      return this.typeOfOrder;
    }

    public boolean getKeepFrozen(){
      return this.keepOrderFrozen;
    }
    
    public Store getStore(){
      return this.store;
    }
    
    public Customer getCustomer(){
      return this.customer;
    }
    public String toString(){
      StringBuffer returnString = new StringBuffer();
      for(Product product: products){
        returnString.append(product.toString() + ", ");
      }
      if(returnString.length() > 0){
        return returnString.toString().substring(0, returnString.length()-2);
      }
      return returnString.toString();
    }
    
    public List<Product> getProducts(){
      return this.products;
    }
}
