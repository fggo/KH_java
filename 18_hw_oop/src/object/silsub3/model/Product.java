package object.silsub3.model;

public class Product {
	private String productID;
	private String productName;
	private String productArea;
	private int price;
	private double tax;

	public Product(){}
	
	public Product(String productID, String productName, String productArea, int price, double tax) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productArea = productArea;
		this.price = price;
		this.tax = tax;
	}

	public void information() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return productID + "  " + productName + "  " + productArea
				+ "  " + price + "  " + tax;
	}

	public String getProductID() { return productID; }
	public void setProductID(String productID) { this.productID = productID; }
	public String getProductName() { return productName; }
	public void setProductName(String productName) { this.productName = productName; }
	public String getProductArea() { return productArea; }
	public void setProductArea(String productArea) { this.productArea = productArea; }
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
	public double getTax() { return tax; }
	public void setTax(double tax) { this.tax = tax; }
}
