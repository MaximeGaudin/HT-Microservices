package com.mgaudin.sandbox.ht.echo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.*;
import java.io.IOException;

@Service
public class LatencyFilter implements Filter {
    private final Long artificialWait;

    @Autowired
    public LatencyFilter(
            @Value("${latency.artificial.wait}") Long artificialWait) {
        this.artificialWait = artificialWait;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            Thread.sleep(artificialWait);
        } catch (InterruptedException e) {}

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
