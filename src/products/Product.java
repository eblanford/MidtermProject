/*
 * Product Class
 * Used to store all of the information of a specific product in an order
 */

package products;

public class Product {
	private String name;
	private String category;
	private String description;
	private int price;
	private int quantity;

	// Constructors
	public Product() {
		this.name = "";
		this.category = "";
		this.description = "";
		this.price = 0;
		this.quantity = 0;
	}

	// Constructor for a product before quantity is defined (default qty set to 1)
	public Product(String name, String category, String description, int price) {
		super();
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.quantity = 1;
	}

	// Generic getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// formatted to print to a text file in order receipt can be split later using :
	@Override
	public String toString() {
		return name + ":" + category + ":" + description + ":" + price + ":" + quantity;
	}
}
