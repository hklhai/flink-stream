package com.hxqh.common.batch;

/**
 * Created by Ocean lin on 2019/1/5.
 *
 * @author Ocean lin
 */
public class OrderInfotable {

    public String orderid;
    public String userid;
    public String  mechartid;
    public double  orderamount;
    public String paytype;
    public String paytime;
    public String hbamount;
    public String djjamount;
    public String productid;
    public String huodongnumber;
    public String createtime;

    public OrderInfotable() {
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

    public String getMechartid() {
        return mechartid;
    }

    public void setMechartid(String mechartid) {
        this.mechartid = mechartid;
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

    public String getHbamount() {
        return hbamount;
    }

    public void setHbamount(String hbamount) {
        this.hbamount = hbamount;
    }

    public String getDjjamount() {
        return djjamount;
    }

    public void setDjjamount(String djjamount) {
        this.djjamount = djjamount;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getHuodongnumber() {
        return huodongnumber;
    }

    public void setHuodongnumber(String huodongnumber) {
        this.huodongnumber = huodongnumber;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
