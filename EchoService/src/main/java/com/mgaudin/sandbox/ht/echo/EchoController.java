package com.mgaudin.sandbox.ht.echo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/")
public class EchoController {
    @RequestMapping(method = RequestMethod.POST)
    public String echo(@RequestBody(required = false) String input) throws UnknownHostException {
        return String.format("%s (from %s)", input == null ? "" : input, InetAddress.getLocalHost().getHostAddress());
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String getIP() throws UnknownHostException {
        return String.format("{ \"ip\": \"%s\" }", InetAddress.getLocalHost().getHostAddress());
    }
}
