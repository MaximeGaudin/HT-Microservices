package com.mgaudin.sandbox.ht.echo;

import org.apache.commons.io.IOUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.UnknownHostException;

@RestController
public class SpeakerController {
    private final String speakers;

    public SpeakerController() throws IOException {
        this.speakers = IOUtil.toString(
                this.getClass().getClassLoader().getResourceAsStream("speakers.json")
        );
    }

    @RequestMapping(value = "/speakers", produces = "application/json")
    public String getSpeakers() throws UnknownHostException {
        return this.speakers;
    }
}
