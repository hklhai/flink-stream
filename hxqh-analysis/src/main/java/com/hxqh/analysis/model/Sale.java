package com.hxqh.analysis.model;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the sale database table.
 * 
 */
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	private int saleid;

	private int productid;

	private Date saleendtime;

	private String salename;

	private Date salestarttime;

	public Sale() {
	}

	public int getSaleid() {
		return this.saleid;
	}

	public void setSaleid(int saleid) {
		this.saleid = saleid;
	}

	public int getProductid() {
		return this.productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public Date getSaleendtime() {
		return this.saleendtime;
	}

	public void setSaleendtime(Date saleendtime) {
		this.saleendtime = saleendtime;
	}

	public String getSalename() {
		return this.salename;
	}

	public void setSalename(String salename) {
		this.salename = salename;
	}

	public Date getSalestarttime() {
		return this.salestarttime;
	}

	public void setSalestarttime(Date salestarttime) {
		this.salestarttime = salestarttime;
	}

}