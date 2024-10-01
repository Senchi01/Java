package lecture3;

public class shopper {
	public static void main(String[] args) {
		Customer ccn = new Customer("me");

		Product book = new Product("book of beba fett");
		Product record = new Product("Dark side of the moon");

		ccn.addProduct(book);
		ccn.addProduct(record);
		System.out.println(ccn.getName()+  ": ");
		System.out.println(ccn.showProduct());

		System.out.println(book.showOwner());

	}
	


	
}
