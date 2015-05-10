package com.mgaudin.sandbox.ht.echo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class EchoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EchoServiceApplication.class, args);
    }
}
