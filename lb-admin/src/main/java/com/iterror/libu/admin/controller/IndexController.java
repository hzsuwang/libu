package com.iterror.libu.admin.controller;

import com.google.common.collect.Maps;
import com.iterror.libu.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(Model model) {
        System.out.println("userService="+userService);
        Map user = Maps.newHashMap();
        user.put("id", 1);
        user.put("name", "曹操");
        user.put("description", "一代枭雄");
        model.addAttribute("user", user);
        return "index";
    }

}
