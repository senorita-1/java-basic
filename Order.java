package Dominospizza;

import java.util.ArrayList;

public class Order extends DominosPizza {
	 String customerName;
	    ArrayList<Pizza> pizzas;
	    String couponCode;
	    double seasonalDiscount;

	    Order(String customerName) {
	        this.customerName = customerName;
	        this.pizzas = new ArrayList<>();
	        this.couponCode = "";
	        this.seasonalDiscount = 0.10; 
	    }

	    void addPizza(Pizza pizza) {
	        pizzas.add(pizza);
	    }

	    double calculateTotal() {
	        double total = 0;
	        for (Pizza pizza : pizzas) {
	            total += pizza.price;
	        }
	        return total;
	    }

	    double applyCoupon() {
	        if (couponCode.equals("DOMINOS10")) {
	            return calculateTotal() * 0.10;
	        } else {
	            return 0;
	        }
	    }

	    void displayOrder() {
	        System.out.println("Order for " + customerName + ":");
	        java.util.HashMap<Pizza, Integer> pizzaQuantity = new java.util.HashMap<>();

	        for (Pizza pizza : pizzas) {
	            pizzaQuantity.put(pizza, pizzaQuantity.getOrDefault(pizza, 0) + 1);
	        }

	        for (java.util.Map.Entry<Pizza, Integer> entry : pizzaQuantity.entrySet()) {
	            System.out.println(entry.getValue() + " x " + entry.getKey().name + " - $" + entry.getKey().price * entry.getValue());
	        }
	        System.out.println("Subtotal: $" + calculateTotal());
	        System.out.println("Coupon discount: -$" + applyCoupon());
	        System.out.println("first anniversary discount (" + first anniversary discount * 100 + "%): -$" + calculateTotal() * first anniversary discount );
	        System.out.println("Total: $" + (calculateTotal() - applyCoupon() - calculateTotal() * seasonalDiscount));
	    }
}
