package com.hxqh.serviceinterface.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ocean lin on 2019/1/6.
 *
 * @author Ocean lin
 */
@RestController
@RequestMapping(value = "service")
public class ServiceController {

    @RequestMapping("hello")
    public String hello() {
        return "hello world";
    }
}
