package com.hxqh.view.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ocean lin on 2019/1/6.
 *
 * @author Ocean lin
 */

@FeignClient(value = "hxqh-interface")
public interface TestService {

    @RequestMapping("/service/hello")
    String test();

}
