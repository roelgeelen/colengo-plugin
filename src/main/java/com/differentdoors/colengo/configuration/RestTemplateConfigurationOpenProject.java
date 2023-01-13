package com.differentdoors.colengo.configuration;

import com.differentdoors.colengo.authentication.OAuthTokenInterceptor;
import com.differentdoors.colengo.authentication.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfigurationOpenProject {

    @Autowired
    private TokenService tokenService;

    @Bean(name = "Colengo")
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(15))
                .setReadTimeout(Duration.ofSeconds(15))
                .interceptors(new OAuthTokenInterceptor(tokenService)).build();
    }
}
