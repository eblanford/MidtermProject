import java.util.ArrayList;
import java.util.Scanner;

import products.Product;
import utilities.Validator;

public class shoppingCart {
	//use in main to send as argument-ArrayList<Product> usersCart = new ArrayList<>();

	
	public static ArrayList<Product> addToCart(Product product, ArrayList<Product> cart){
		Scanner scan = new Scanner(System.in);
		product.setQuantity(Validator.getInt(scan, "How many " + product.getName() + " would you like?", 1));
		cart.add(product);
		return cart;
	}
	public static ArrayList<Product> removeFromCart(Product product, ArrayList<Product> cart){
		cart.remove(product);
		System.out.println(product.getName() + " has been removed from your shopping cart");
		return cart;
	}
	
	public static ArrayList<Product> emptyCart(ArrayList<Product> cart) {
		cart.clear();
		System.out.println("Your shopping cart has been emptied");
		return cart;
	}
	public static int sumCart(ArrayList<Product> cart) {
		int sum = 0;
		for(int i = 0;i<cart.size();i++) {
			sum += (cart.get(i).getPrice()) * (cart.get(i).getQuantity());
		}
		return sum; 
	}
	
}

