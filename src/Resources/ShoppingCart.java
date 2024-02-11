package Resources;

import java.util.ArrayList;

// extends showcases use of polymorphism
// ShoppingCart is of type ItemList
public class ShoppingCart extends ItemList {
    private final ArrayList<Product> cart;

    public ShoppingCart() {
        cart = new ArrayList<Product>();
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Product p : cart) {
            totalPrice += p.getPrice();
        }
        return totalPrice;
    }

}
