package products;

public class Product {
	private String name;
	private String category;
	private String description;
	private int price;
	private int quantity;

	public Product() {
		this.name = "";
		this.category = "";
		this.description = "";
		this.price = 0;
		this.quantity = 0;
	}

	public Product(String name, String category, String description, int price) {
		super();
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.quantity = 1;
	}

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

	@Override
	public String toString() {
		return name + ":" + category + ":" + description + ":" + price + ":" + quantity;
	}
}
