package com.hxqh.view.controller;

import com.hxqh.view.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ocean lin on 2019/1/6.
 *
 * @author Ocean lin
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("test")
    public String test() {
        return testService.test();
    }
}
