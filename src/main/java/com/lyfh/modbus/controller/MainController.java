package com.lyfh.modbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LinShuifeng on 2019/5/28
 * E-Mail: shuifenglin216076@sohu-inc.com
 */
@Controller
public class MainController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String show(Model model){
        model.addAttribute("uid","123456789");
        model.addAttribute("name","Jerry");
        return "index";
    }
}
