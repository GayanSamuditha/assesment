package com.demo.api.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Gayan Samuditha
 */

@Configuration
public class RestServiceCorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {

            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/items").allowedOrigins("http://localhost:8080");
            }
        };
    }
}
