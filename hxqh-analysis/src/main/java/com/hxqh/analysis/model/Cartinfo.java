package com.hxqh.analysis.model;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the cartinfo database table.
 * 
 */
public class Cartinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int cartid;

	private int userid;

	private Date createtime;

	private int merchantid;

	private int num;

	private double productamount;

	private int productid;

	public Cartinfo() {
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getMerchantid() {
		return this.merchantid;
	}

	public void setMerchantid(int merchantid) {
		this.merchantid = merchantid;
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getProductamount() {
		return this.productamount;
	}

	public void setProductamount(double productamount) {
		this.productamount = productamount;
	}

	public int getProductid() {
		return this.productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

}