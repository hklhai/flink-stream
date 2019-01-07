package com.hxqh.view.service;

import com.hxqh.common.batch.ProductAnaly;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Ocean lin on 2019/1/6.
 *
 * @author Ocean lin
 */
@FeignClient(value = "hxqh-interface")
public interface ProductService {

    @RequestMapping("/product/listProductAnaly")
    ProductAnaly listProductAnaly(@RequestParam(value = "productid") long productid,
                                  @RequestParam(value = "timedate") String timedate);
}
