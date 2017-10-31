package com.iterror.libu.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by tony.yan on 2017/10/31.
 */
@SpringBootApplication
@ComponentScan
@Configuration
@ImportResource("application-context.xml")
public class TaskApplication {

    private static final Logger logger = LoggerFactory.getLogger(TaskApplication.class);

    public static void main(String[] args) {
        logger.info("简单Quartz微服务入口函数编码-" + System.getProperty("file.encoding"));

        SpringApplication.run(TaskApplication.class, args);

        System.out.println("【【【【【【 简单Quartz微服务 】】】】】】已启动.");
    }
}
