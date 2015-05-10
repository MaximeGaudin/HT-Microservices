package com.mgaudin.sandbox.ht.echo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class EchoController {
    private final Long artificialWait;

    @Autowired
    public EchoController(
            @Value("${latency.artificial.wait}") Long artificialWait) {
        this.artificialWait = artificialWait;
    }


    @RequestMapping(value = "/")
    public String echo(@RequestBody(required = false) String input) throws UnknownHostException, InterruptedException {
        Thread.sleep(artificialWait);

        if (input == null) {
            return InetAddress.getLocalHost().getHostAddress();
        }

        return String.format("%s (from %s)", input, InetAddress.getLocalHost().getHostAddress());
    }
}
