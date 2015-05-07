package com.mgaudin.sandbox.ht.echo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class EchoController {
    @RequestMapping(value = "/")
    public String echo(@RequestBody String input) throws UnknownHostException {
        return String.format("%s (from %s)", input, InetAddress.getLocalHost().getHostAddress());
    }
}
