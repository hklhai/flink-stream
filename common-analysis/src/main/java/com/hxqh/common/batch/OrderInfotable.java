package com.hxqh.common.batch;

/**
 * Created by Ocean lin on 2019/1/5.
 *
 * @author Ocean lin
 */
public class OrderInfotable {

    public String orderid;
    public String userid;
    public String  merchantid;
    public double  orderamount;
    public String paytype;
    public String paytime;
    public String red;
    public String cashcoupon;
    public String productid;
    public String saleid;
    public String createtime;


    public OrderInfotable() {
    }

    public OrderInfotable(String orderid, String userid, String merchantid, double orderamount, String paytype, String paytime, String red, String cashcoupon, String productid, String saleid, String createtime) {
        this.orderid = orderid;
        this.userid = userid;
        this.merchantid = merchantid;
        this.orderamount = orderamount;
        this.paytype = paytype;
        this.paytime = paytime;
        this.red = red;
        this.cashcoupon = cashcoupon;
        this.productid = productid;
        this.saleid = saleid;
        this.createtime = createtime;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    public double getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(double orderamount) {
        this.orderamount = orderamount;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public String getCashcoupon() {
        return cashcoupon;
    }

    public void setCashcoupon(String cashcoupon) {
        this.cashcoupon = cashcoupon;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getSaleid() {
        return saleid;
    }

    public void setSaleid(String saleid) {
        this.saleid = saleid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
