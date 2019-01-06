package com.hxqh.serviceinterface.controller;


import com.hxqh.common.batch.ProductAnaly;
import com.hxqh.serviceinterface.util.HbaseUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ocean lin on 2019/1/6.
 *
 * @author Ocean lin
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @RequestMapping("listProductAnaly")
    public ProductAnaly listProductAnaly(long productid, String timedate) {
        ProductAnaly productAnaly = new ProductAnaly();
        try {
            String chengjiaocount = HbaseUtil.getdata("productinfo", productid + "==" + timedate, "info", "chengjiaocount");
            String weichegnjiao = HbaseUtil.getdata("productinfo", productid + "==" + timedate, "info", "weichegnjiao");

            productAnaly.setProductid(productid);
            productAnaly.setDateString(timedate);
            productAnaly.setWeichegnjiao(Long.valueOf(weichegnjiao));
            productAnaly.setChengjiaocount(Long.valueOf(chengjiaocount));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productAnaly;
    }

}
