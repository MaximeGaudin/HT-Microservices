package com.mgaudin.sandbox.ht.echo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class EchoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EchoServiceApplication.class, args);
    }

    @RequestMapping(value = "/")
    public String echo(@RequestBody String input, HttpServletRequest request) throws UnknownHostException {
        return String.format("%s (from %s)", input, InetAddress.getLocalHost().getHostAddress());
    }
}
