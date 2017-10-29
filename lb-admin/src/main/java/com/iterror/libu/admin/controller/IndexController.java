package com.iterror.libu.admin.controller;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        Map user = Maps.newHashMap();
        user.put("id", 1);
        user.put("name", "曹操");
        user.put("description", "一代枭雄");
        model.addAttribute("user", user);
        return "index";
    }

}
