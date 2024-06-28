package com.bsejawal.resttemplate.config;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        //The standard JDK HTTP library does not support HTTP PATCH. So I needed to use the Apache HttpComponents request factory.
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        restTemplate.setRequestFactory(requestFactory);

        //add your headers
        String authHeaderValue = "Bearer your_token_here";
        HeaderRequestInterceptor authInterceptor = new HeaderRequestInterceptor("Authorization", authHeaderValue);
        restTemplate.setInterceptors(Collections.singletonList(authInterceptor));
        return restTemplate;
    }
}
