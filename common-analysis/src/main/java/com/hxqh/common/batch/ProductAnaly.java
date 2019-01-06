package com.hxqh.common.batch;

/**
 * Created by Ocean lin on 2019/1/5.
 *
 * @author Ocean lin
 */
public class ProductAnaly {

    private long productid;

    private String dateString;
    /**
     * 成交
     */
    private long chengjiaocount;
    /**
     * 未成交
     */
    private long weichegnjiao;
    /**
     * 分组key
     */
    private String groupbyfield;

    public ProductAnaly() {
    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public long getChengjiaocount() {
        return chengjiaocount;
    }

    public void setChengjiaocount(long chengjiaocount) {
        this.chengjiaocount = chengjiaocount;
    }

    public long getWeichegnjiao() {
        return weichegnjiao;
    }

    public void setWeichegnjiao(long weichegnjiao) {
        this.weichegnjiao = weichegnjiao;
    }

    public String getGroupbyfield() {
        return groupbyfield;
    }

    public void setGroupbyfield(String groupbyfield) {
        this.groupbyfield = groupbyfield;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductAnaly{");
        sb.append("productid=").append(productid);
        sb.append(", dateString='").append(dateString).append('\'');
        sb.append(", chengjiaocount=").append(chengjiaocount);
        sb.append(", weichegnjiao=").append(weichegnjiao);
        sb.append(", groupbyfield='").append(groupbyfield).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
