package com.iterror.libu.admin;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by tony.yan on 2017/10/29.
 */
@SpringBootApplication
@ImportResource(value="classpath:data-source.xml")
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication();
        app.setBannerMode(Banner.Mode.OFF);
        app.run(Application.class, args);
    }
}
