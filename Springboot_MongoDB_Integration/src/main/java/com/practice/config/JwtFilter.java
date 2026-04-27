package com.practice.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtFilter extends GenericFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) request;
        String authHeader=req.getHeader("Authorization");

        if(authHeader!=null && authHeader.startsWith("Bearer ")){
            String token=authHeader.substring(7);
            try{
                String username=JwtUtil.extractUsername(token);

                if(username!=null){
                    System.out.println("Token valid for user: "+username);
                }
            }catch (Exception e){
                System.out.println("Invalid Token");
            }
        }else {
            System.out.println("No token found");
        }
        chain.doFilter(request,response);
    }
}
