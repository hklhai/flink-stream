package com.hxqh.analysis.model;

import java.io.Serializable;


/**
 * The persistent class for the merchantshop database table.
 * 
 */
public class Merchantshop implements Serializable {
	private static final long serialVersionUID = 1L;

	private int merchantshopid;

	private int merchantid;

	private String merchantshopname;

	public Merchantshop() {
	}

	public int getMerchantshopid() {
		return this.merchantshopid;
	}

	public void setMerchantshopid(int merchantshopid) {
		this.merchantshopid = merchantshopid;
	}

	public int getMerchantid() {
		return this.merchantid;
	}

	public void setMerchantid(int merchantid) {
		this.merchantid = merchantid;
	}

	public String getMerchantshopname() {
		return this.merchantshopname;
	}

	public void setMerchantshopname(String merchantshopname) {
		this.merchantshopname = merchantshopname;
	}

}