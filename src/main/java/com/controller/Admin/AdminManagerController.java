package com.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Admin")
public class AdminManagerController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("name","首页");
        return "PCfront/index";
    }


}
