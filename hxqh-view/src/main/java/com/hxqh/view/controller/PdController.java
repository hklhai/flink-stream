package com.hxqh.view.controller;

import com.hxqh.view.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ocean lin on 2018/12/20.
 *
 * @author Ocean lin
 */

@Controller
@RequestMapping("pd")
public class PdController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("list")
    public String list(Model model) {
        String test = redisService.getStr("test");
        model.addAttribute("test", test);
        return "dsrdlist";
    }
}
