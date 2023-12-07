package com.sutanu.main;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//CorsConfig.java

@Configuration
public class CorsConfig implements WebMvcConfigurer {

 @Override
 public void addCorsMappings(CorsRegistry registry) {
     registry.addMapping("/employees")
             .allowedOrigins("http://127.0.0.1:5500/")
             .allowedMethods("GET", "POST", "PUT", "DELETE");
     // Add more configuration as needed
 }
}

