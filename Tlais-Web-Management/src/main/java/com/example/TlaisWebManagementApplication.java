package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //开启了对servlet组件的支持
@SpringBootApplication
public class TlaisWebManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TlaisWebManagementApplication.class, args);
    }

}
