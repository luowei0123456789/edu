package com.luowei.service_edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = {"com.luowei"})
@EnableSwagger2
@EnableDiscoveryClient
@EnableFeignClients
public class EduService {
    public static void main(String[] args) {
        SpringApplication.run(EduService.class,args);
    }
}
