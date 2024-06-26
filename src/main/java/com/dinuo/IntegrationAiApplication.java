package com.dinuo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @Author dinuo
 * @Date: 2024/06/03/16:12
 */
@SpringBootApplication
public class IntegrationAiApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(IntegrationAiApplication.class, args);

    }

}
