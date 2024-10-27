package Dominospizza;

import java.util.ArrayList;
import java.util.Scanner;

public class DominosPizza {
	static ArrayList<Pizza> menu = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static String adminUsername = "admin";
    static String adminPassword = "password";

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Admin Login");
            System.out.println("2. Customer Dashboard");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    customerDashboard();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void adminLogin() {
        System.out.print("Enter admin username: ");
        String username = scanner.next();
        System.out.print("Enter admin password: ");
        String password = scanner.next();

        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            adminDashboard();
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    static void adminDashboard() {
        while (true) {
            System.out.println("\n1. Create Menu");
            System.out.println("2. View Menu");
            System.out.println("3. Add Menu Item");
            System.out.println("4. Remove Menu Item");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createMenu();
                    break;
                case 2:
                    displayMenu();
                    break;
                case 3:
                    addMenuItem();
                    break;
                case 4:
                    removeMenuItem();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void customerDashboard() {
        System.out.print("Enter customer name: ");
        String customerName = scanner.next();

        Order order = new Order(customerName);

        while (true) {
            System.out.println("\n1. View Menu");
            System.out.println("2. Order Pizza");
            System.out.println("3. Update Order");
            System.out.println("4. Remove Order");
            System.out.println("5. Apply Coupon");
            System.out.println("6. Checkout");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayMenu();
                    break;
                case 2:
                    orderPizza(order);
                    break;
                case 3:
                    updateOrder(order);
                    break;
                case 4:
                    removeOrder(order);
                    break;
                case 5:
                    applyCoupon(order);
                    break;
                case 6:
                    checkout(order);
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void createMenu() {
        System.out.print("Enter number of menu items: ");
        int numItems = scanner.nextInt();

        for (int i = 0; i < numItems; i++)

    {
        System.out.print("Enter pizza name: ");
        String name = scanner.next();
        System.out.print("Enter pizza price: ");
        double price = scanner.nextDouble();

        Pizza pizza = new Pizza(name, price);
        menu.add(pizza);
    }
    System.out.println("Menu created successfully!");
}

static void displayMenu() {
    System.out.println("Menu:");
    for (int i = 0; i < menu.size(); i++) {
        System.out.println((i + 1) + ". " + menu.get(i).name + " - $" + menu.get(i).price);
    }
}

static void addMenuItem() {
    System.out.print("Enter pizza name: ");
    String name = scanner.next();
    System.out.print("Enter pizza price: ");
    double price = scanner.nextDouble();

    Pizza pizza = new Pizza(name, price);
    menu.add(pizza);
    System.out.println("Menu item added successfully!");
}

static void removeMenuItem() {
    displayMenu();
    System.out.print("Enter menu item number to remove: ");
    int choice = scanner.nextInt();

    if (choice > 0 && choice <= menu.size()) {
        menu.remove(choice - 1);
        System.out.println("Menu item removed successfully!");
    } else {
        System.out.println("Invalid choice!");
    }
}

static void orderPizza(Order order) {
    displayMenu();
    System.out.print("Enter pizza number to order: ");
    int choice = scanner.nextInt();

    if (choice > 0 && choice <= menu.size()) {
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        for (int i = 0; i < quantity; i++) {
            order.addPizza(menu.get(choice - 1));
        }
        System.out.println("Pizza added to order!");
    } else {
        System.out.println("Invalid choice!");
    }
}
static void updateOrder(Order order) {
    order.displayOrder();
    System.out.print("Enter pizza number to update: ");
    int choice = scanner.nextInt();

    if (choice > 0 && choice <= order.pizzas.size()) {
        displayMenu();
        System.out.print("Enter new pizza number: ");
        int newChoice = scanner.nextInt();

        if (newChoice > 0 && newChoice <= menu.size()) {
            order.pizzas.set(choice - 1, menu.get(newChoice - 1));
            System.out.println("Order updated successfully!");
        } else {
            System.out.println("Invalid choice!");
        }
    } else {
        System.out.println("Invalid choice!");
    }
}

static void removeOrder(Order order) {
    order.displayOrder();
    System.out.print("Enter pizza number to remove: ");
    int choice = scanner.nextInt();

    if (choice > 0 && choice <= order.pizzas.size()) {
        order.pizzas.remove(choice - 1);
        System.out.println("Pizza removed from order!");
    } else {
        System.out.println("Invalid choice!");
    }
}

static void applyCoupon(Order order) {
    System.out.print("Enter coupon code: ");
    order.couponCode = scanner.next();

    if (order.couponCode.equals("DOMINOS10")) {
        System.out.println("Coupon applied successfully!");
    } else {
        System.out.println("Invalid coupon code!");
    }
}

static void checkout(Order order) {
    order.displayOrder();
    System.out.println("Thank you for ordering!");
}
}