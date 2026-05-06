package com.duoc.auramove.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebClientConfig {
    
    @Value("${openmeteo.base-url}")
    private String openMeteoBaseUrl;
    
    @Bean
    public WebClient weatherWebClient(){
        return WebClient.builder()
                .baseUrl(openMeteoBaseUrl)
                .defaultHeader("Accept", "application/json")
                .build();
    }
}
