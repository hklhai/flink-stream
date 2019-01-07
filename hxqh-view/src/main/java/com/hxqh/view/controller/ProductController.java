package com.hxqh.view.controller;

import com.hxqh.common.batch.ProductAnaly;
import com.hxqh.view.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "searchproductanaly")
    public ProductAnaly searchproductanaly(long prdouctid, String datetime) {
        return productService.listProductAnaly(prdouctid, datetime);
    }

}
