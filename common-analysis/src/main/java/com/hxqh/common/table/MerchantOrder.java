package com.hxqh.common.table;

/**
 * Created by Ocean lin on 2019/1/6.
 *
 * @author Ocean lin
 */
public class MerchantOrder {

    private String merchantid;
    private double orderamout;
    private long countvalue;

    public MerchantOrder() {
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    public double getOrderamout() {
        return orderamout;
    }

    public void setOrderamout(double orderamout) {
        this.orderamout = orderamout;
    }

    public long getCountvalue() {
        return countvalue;
    }

    public void setCountvalue(long countvalue) {
        this.countvalue = countvalue;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MerchantOrder{");
        sb.append("merchantid='").append(merchantid).append('\'');
        sb.append(", orderamout=").append(orderamout);
        sb.append(", countvalue=").append(countvalue);
        sb.append('}');
        return sb.toString();
    }
}
