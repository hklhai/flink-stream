package com.hxqh.analysis.model;

import java.io.Serializable;


/**
 * The persistent class for the producttype database table.
 * 
 */
public class Producttype implements Serializable {
	private static final long serialVersionUID = 1L;

	private int productcategoryid;

	private String productcategoryname;

	private String producttypelevel;

	public Producttype() {
	}

	public int getProductcategoryid() {
		return this.productcategoryid;
	}

	public void setProductcategoryid(int productcategoryid) {
		this.productcategoryid = productcategoryid;
	}

	public String getProductcategoryname() {
		return this.productcategoryname;
	}

	public void setProductcategoryname(String productcategoryname) {
		this.productcategoryname = productcategoryname;
	}

	public String getProducttypelevel() {
		return this.producttypelevel;
	}

	public void setProducttypelevel(String producttypelevel) {
		this.producttypelevel = producttypelevel;
	}

}