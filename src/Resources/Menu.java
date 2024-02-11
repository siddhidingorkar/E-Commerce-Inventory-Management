package Resources;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class CartEmpty extends Exception {
    String errorMessage;

    public CartEmpty(String message) {
        errorMessage = message;
    }

    public String getMessage() {
        return errorMessage;
    }
}

public class Menu {
    private ArrayList<Product> inventory;
    private ShoppingCart cart;
    private Scanner input;

    public Menu() {
        inventory = new ArrayList<Product>();
        cart = new ShoppingCart();
        input = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("====================================");
        System.out.println("Welcome to our E-commerce store!");
        System.out.println("====================================");
        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Remove Product from Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");

            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    viewInventory();
                    break;
                case 2:
                    addProductToCart();
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    removeProductFromCart();
                    break;
                case 5:
                    checkout();
                    System.exit(0);
                case 6:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Looks like your cart is empty! Try adding items to checkout.");
        }
        System.out.println("\n");
        System.out.println("====================================");
        System.out.println("Your Cart");
        System.out.println("====================================");
        System.out.println("\n");
        System.out.println("ID\tProduct Name\tDescription\tPrice");

        // calculating total cost
        double totalCost = 0.0;
        for (int i = 0; i < cart.getItems().size(); i++) {
            Product product = cart.getItems().get(i);
            totalCost += product.getPrice();
        }

        // displaying cart
        for (int i = 0; i < cart.getItems().size(); i++) {
            Product product = cart.getItems().get(i);
            System.out.println(product.getProductId() + "\t" + product.getProductName() + "\t"
                    + product.getDescription() + "\t" + product.getPrice());
        }

        System.out.println("\n");
        System.out.println("====================================");
        System.out.println("Total amount to be paid: $" + totalCost);
        System.out.println("====================================");

        System.out.println("Enter name:");
        input.nextLine();
        String name = input.nextLine();
        System.out.println("Enter billing address:");
        String billingAddress = input.nextLine();
        System.out.println("Enter phone number: ");
        long phoneNo = input.nextLong();

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("OrderDetails.txt", true));
            bw.write(name + "'s order: ");
            bw.newLine();
            for (int i = 0; i < cart.getItems().size(); i++) {
                Product product = cart.getItems().get(i);
                bw.write("# " + product.getProductName() + "\n\t$" + product.getPrice());
                bw.newLine();
            }
            bw.write("Total Billing Amount: $" + totalCost);
            bw.newLine();
            bw.write("Billing Address: " + billingAddress + ".");
            bw.newLine();
            bw.write("Phone Number: " + phoneNo + ".");
            bw.newLine();
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }

        System.out.println();
        System.out.println(
                name + ", thank you for shopping with us! Your order will reach you soon at " + billingAddress);
    }

    private void viewInventory() {
        inventory = new Inventory().getInventory();
        System.out.println("\nCurrent Inventory:\n");
        System.out.println("=====================================================================================================");
        System.out.println("ID\t\t\tProduct Name                  \t\t\tDescription                  \t\t\tPrice");

        // iterating over all inventory and displaying them
        System.out.println("====================================================================================================");
        for (int i = 0; i < inventory.size(); i++) {
            Product product = inventory.get(i);
            System.out.println(product.getProductId() + "\t\t\t" + product.getProductName() + "\t\t\t"
                    + product.getDescription() + "\t\t\t" + product.getPrice());
        }
        System.out.println("====================================================================================================");
    }

    private void addProductToCart() {
        System.out.println("\nEnter Product ID to add to cart:");
        int id = input.nextInt();
        boolean found = false;
        for (int i = 0; i < inventory.size(); i++) {
            Product product = inventory.get(i);
            if (product.getProductId() == id) {
                found = true;
                cart.addItem(product);
                System.out
                        .println(product.getProductName() + " " + product.getDescription() + " has been added to cart");
            }
        }

        if (!found) {
            System.out.println("The product id you entered either doesn't exist or is not available currently\n");
        }
    }

    private void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty.");
        } else {
            System.out.println("\nYour Cart:\n");
            System.out.println("ID\tProduct Name\tDescription\tPrice");

            // iterating over all items in cart and displaying them
            for (int i = 0; i < cart.getItems().size(); i++) {
                Product product = cart.getItems().get(i);
                System.out.println(product.getProductId() + "\t" + product.getProductName() + "\t"
                        + product.getDescription() + "\t" + product.getPrice());
            }
        }
    }

    private void removeProductFromCart() {
        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty.");
        } else {
            System.out.println("\nEnter Product ID to remove from cart:");
            int id = input.nextInt();
            boolean found = false;
            // find product and delete
            for (int i = 0; i < inventory.size(); i++) {
                Product product = inventory.get(i);
                if (product.getProductId() == id) {
                    found = true;
                    cart.remove(product);
                    System.out.println(
                            product.getProductName() + " " + product.getDescription() + " has been removed from cart");
                }
            }
            if (!found) {
                System.out.println("\nProduct not found in cart.");
            }
        }
    }
}