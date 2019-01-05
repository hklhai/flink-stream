package com.hxqh.analysis.model;

import java.io.Serializable;


/**
 * The persistent class for the product database table.
 * 
 */
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	private int productid;

	private double activityprice;

	private double price;

	private String productname;

	private int producttypeid;

	public Product() {
	}

	public int getProductid() {
		return this.productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public double getActivityprice() {
		return this.activityprice;
	}

	public void setActivityprice(double activityprice) {
		this.activityprice = activityprice;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getProducttypeid() {
		return this.producttypeid;
	}

	public void setProducttypeid(int producttypeid) {
		this.producttypeid = producttypeid;
	}

}