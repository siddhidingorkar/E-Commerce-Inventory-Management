package Resources;

import java.util.ArrayList;

// extends showcases use of polymorphism
public class Inventory extends ItemList {
    private final ArrayList<Product> inventory;

    public Inventory() {
        inventory = new ArrayList<Product>();

        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();
        Product p5 = new Product();
        Product p6 = new Product();
        Product p7 = new Product();
        Product p8 = new Product();

        // Product p1
        p1.setProductName("iPhone 12                    ");
        p1.setDescription("Product Red                  ");
        p1.setPrice(49900);
        p1.setProductId(101);

        // Product p2
        p2.setProductName("iPhone 13                     ");
        p2.setDescription("Midnight Blue                 ");
        p2.setPrice(79900);
        p2.setProductId(102);

        // Product p3
        p3.setProductName("iPhone 13 Pro                 ");
        p3.setDescription("Gold                          ");
        p3.setPrice(105900);
        p3.setProductId(103);

        // Product p4
        p4.setProductName("iPhone 14                     ");
        p4.setDescription("Starlight                     ");
        p4.setPrice(89900);
        p4.setProductId(104);

        // Product p5
        p5.setProductName("iPhone 14 Pro Max             ");
        p5.setDescription("Deep Purple                   ");
        p5.setPrice(174900);
        p5.setProductId(105);

        p6.setProductName("Apple Watch SE 2023           ");
        p6.setDescription("Midnight Black                ");
        p6.setPrice(29900);
        p6.setProductId(106);

        p7.setProductName("Apple USC C to Lightning Cable");
        p7.setDescription("1 meter                       ");
        p7.setPrice(1900);
        p7.setProductId(107);

        p8.setProductName("MacBook Air M1                ");
        p8.setDescription("Space Grey                    ");
        p8.setPrice(109900);
        p8.setProductId(108);

        inventory.add(0, p1);
        inventory.add(1, p2);
        inventory.add(2, p3);
        inventory.add(3, p4);
        inventory.add(4, p5);
        inventory.add(5, p6);
        inventory.add(6, p7);
        inventory.add(7, p8);
    }

    public ArrayList<Product> getInventory() {
        return inventory;
    }
}