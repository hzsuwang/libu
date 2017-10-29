package com.iterror.libu.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by tony.yan on 2017/10/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=LibuApplication.class)
@WebAppConfiguration
public class LibuApplicationTests {

    @Autowired
    Dao dao;

    @Test
    public void testdao() {
        System.out.println("test dao query size is :" + dao.query("tablname",null).size());
    }
}
