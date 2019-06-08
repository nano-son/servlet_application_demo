package me.nanostudio;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("do filter");
        chain.doFilter(req, res);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("filter init");
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy");
    }
}
