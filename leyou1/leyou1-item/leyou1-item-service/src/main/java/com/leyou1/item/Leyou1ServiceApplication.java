package com.leyou1.item;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.leyou1.item.mapper")
public class Leyou1ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(Leyou1ServiceApplication.class,args);
    }
}
