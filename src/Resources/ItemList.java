package Resources;

import java.util.ArrayList;

public class ItemList {
    private final ArrayList<Product> items;

    public ItemList() {
        items = new ArrayList<Product>();
    }

    public void addItem(Product p) {
        items.add(p);
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public boolean remove(Product a) {
        return items.remove(a);
    }

    public boolean exists(int product_id) {
        for (int i = 0; i < 5; i++) {
            if (product_id == items.get(i).getProductId()) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        items.clear();
    }
}
