package com.assignment.web.model;

public class product {
	private String productName;
	private int productid;
	private int price;
	private String productdesc;
	public product() {
	
	}
	public product(int prodid, String productName,int price,String productdesc) {
		super();
		this.productName = productName;
		this.productdesc = productdesc;
		this.productid = productid;
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public product(String productName, int productid, int price, String productdesc) {
		super();
		this.productName = productName;
		this.productid = productid;
		this.price = price;
		this.productdesc = productdesc;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProductdesc() {
		return productdesc;
	}
	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}
}
	