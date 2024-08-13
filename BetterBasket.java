package catalogue;

import java.io.Serializable;
import java.util.Collections;

/**
 * Write a description of class BetterBasket here.
 *
 * @author  Your Name
 * @version 1.0
 */
public class BetterBasket extends Basket {

  private static final long serialVersionUID = 1L;

  @Override
  public boolean add(Product product) {
    // Check if the product already exists in the basket
    for (Product p : this) {
      if (p.getProductNum().equals(product.getProductNum())) {
        p.setQuantity(p.getQuantity() + product.getQuantity());
        sortBasket();
        return true;
      }
    }
    // If the product does not exist, add it
    super.add(product);
    sortBasket();
    return true;
  }

  private void sortBasket() {
    // Sort the basket by product number (String comparison)
    Collections.sort(this, (p1, p2) -> p1.getProductNum().compareTo(p2.getProductNum()));
  }
}



