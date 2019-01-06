package com.hxqh.common.batch;

import java.util.Date;

/**
 * Created by Ocean lin on 2019/1/5.
 *
 * @author Ocean lin
 */
public class OrderInfo {

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

    private Date  createtime;

    public OrderInfo() {
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getCashcoupon() {
        return cashcoupon;
    }

    public void setCashcoupon(String cashcoupon) {
        this.cashcoupon = cashcoupon;
    }

    public int getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(int merchantid) {
        this.merchantid = merchantid;
    }

    public double getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(double orderamount) {
        this.orderamount = orderamount;
    }

    public double getPayamount() {
        return payamount;
    }

    public void setPayamount(double payamount) {
        this.payamount = payamount;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public int getPaytype() {
        return paytype;
    }

    public void setPaytype(int paytype) {
        this.paytype = paytype;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public double getRed() {
        return red;
    }

    public void setRed(double red) {
        this.red = red;
    }

    public int getSaleid() {
        return saleid;
    }

    public void setSaleid(int saleid) {
        this.saleid = saleid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
