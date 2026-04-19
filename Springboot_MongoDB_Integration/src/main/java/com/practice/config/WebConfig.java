package com.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {

            public void addCorsMapping(CorsRegistry registry){
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("*");
            }
        };
    }
}
/*
WebConfig (Spring MVC level)
WebMvcConfigurer
👉 Works at:
Controller level
👉 Handles:
CORS for normal requests
Mapping URLs
👉 BUT ❌ does NOT control Spring Security
 */