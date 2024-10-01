package lecture3;

import java.util.ArrayList;

public class Customer {
	private String name;
	private ArrayList<Product> myStuff = new ArrayList<>();
	public Customer() {

	}
	public Customer(String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	public void addProduct(Product newProduct ) {
		myStuff.add(newProduct);
		newProduct.setOwner(this);
	}

	public String showProduct() {
		StringBuilder sb = new StringBuilder();
		for (Product p: myStuff) {
			sb.append(p.getName()+"\n");
		}
		return sb.toString();
	}
}
