package com.hxqh.analysis.model;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the order database table.
 * 
 */
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	private int orderid;

	private String cashcoupon;

	private int merchantid;

	private double orderamount;

	private double payamount;

	private Date paytime;

	private int paytype;

	private int productid;

	private double red;

	private int saleid;

	private int userid;

	public Order() {
	}

	public int getOrderid() {
		return this.orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getCashcoupon() {
		return this.cashcoupon;
	}

	public void setCashcoupon(String cashcoupon) {
		this.cashcoupon = cashcoupon;
	}

	public int getMerchantid() {
		return this.merchantid;
	}

	public void setMerchantid(int merchantid) {
		this.merchantid = merchantid;
	}

	public double getOrderamount() {
		return this.orderamount;
	}

	public void setOrderamount(double orderamount) {
		this.orderamount = orderamount;
	}

	public double getPayamount() {
		return this.payamount;
	}

	public void setPayamount(double payamount) {
		this.payamount = payamount;
	}

	public Date getPaytime() {
		return this.paytime;
	}

	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}

	public int getPaytype() {
		return this.paytype;
	}

	public void setPaytype(int paytype) {
		this.paytype = paytype;
	}

	public int getProductid() {
		return this.productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public double getRed() {
		return this.red;
	}

	public void setRed(double red) {
		this.red = red;
	}

	public int getSaleid() {
		return this.saleid;
	}

	public void setSaleid(int saleid) {
		this.saleid = saleid;
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}