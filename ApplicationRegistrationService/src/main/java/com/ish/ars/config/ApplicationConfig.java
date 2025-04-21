package com.ish.ars.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean(name = "Template")
    public RestTemplate createTemplate(){
        return new RestTemplate();
    }
}
