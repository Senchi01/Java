package lecture3;

public class Product {
	private String name;
	private Customer owner;
	public Product(String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	public void setOwner(Customer owner) {
		this.owner = owner;
	}
	public String showOwner() {
		if (owner != null) {
			return owner.getName();
		} else {
			return "no owner";
		}
	}
}
