package com.angelo.boot;

import com.angelo.boot.autoconfigure.web.AngeloProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class BootApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BootApplication.class);
        /**
         * 由于OnAngeloCondition matches返回false, 条件不满足
         * 故会出现 No qualifying bean of type 'com.angelo.boot.autoconfigure.web.AngeloProperties' available
         */
        System.out.println(applicationContext.getBean(AngeloProperties.class).getAge());
    }
}
