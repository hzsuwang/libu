package com.iterror.libu.admin;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by tony.yan on 2017/10/10.
 */
@Controller
public class Login {
    @Autowired
    private Dao dao;

    @RequestMapping("/home")
    public String home() {
        System.out.println(dao);
        return "name";
    }
}
