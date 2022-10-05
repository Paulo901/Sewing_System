package com.api.Sewing_System.coreConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webMvcConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {


        WebMvcConfigurer.super.addCorsMappings(registry);
    }
}
