package com.hxqh.analysis.model;

import java.io.Serializable;


/**
 * The persistent class for the merchant database table.
 * 
 */
public class Merchant implements Serializable {
	private static final long serialVersionUID = 1L;

	private int merchantid;

	private String merchantarea;

	private String merchantname;

	public Merchant() {
	}

	public int getMerchantid() {
		return this.merchantid;
	}

	public void setMerchantid(int merchantid) {
		this.merchantid = merchantid;
	}

	public String getMerchantarea() {
		return this.merchantarea;
	}

	public void setMerchantarea(String merchantarea) {
		this.merchantarea = merchantarea;
	}

	public String getMerchantname() {
		return this.merchantname;
	}

	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}

}