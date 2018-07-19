package edu.bu.met.cs665.orders;

import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.products.Product;
import edu.bu.met.cs665.products.SimpleChocolateBox;
import edu.bu.met.cs665.products.SimpleFlowerArrangement;
import edu.bu.met.cs665.stores.Store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is a special type of order that is sent to a customer automatically as separate order when.
 * they place a regular order on their birthday
 * 
 * @author Richard Hanks
 *
 */
public class BirthdayOrder extends Order {
  static List<Product> birthdayProducts =
      new ArrayList<>(Arrays.asList(new SimpleChocolateBox(), new SimpleFlowerArrangement()));

  /**
   * Java doc to satisfy the style guide.  It's a constructor.
   * @param customer The customer instance for this order.
   * @param store  The store instance for this order.
   */
  public BirthdayOrder(Customer customer, Store store) {
    // Birthday orders get a certain combination of products defined in birthdayProducts
    super(birthdayProducts, customer, store);
    this.setTypeOfOrder();
  }


  private void setTypeOfOrder() {
    this.typeOfOrder = "Birthday Order";
  }

  public String getTypeOfOrder() {
    return this.typeOfOrder;
  }

}
