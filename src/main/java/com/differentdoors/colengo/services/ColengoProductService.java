package com.differentdoors.colengo.services;

import com.differentdoors.colengo.models.Objects.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class ColengoProductService {
    @Value("${different_doors.colengo.url}")
    private String URL;

    @Autowired
    @Qualifier("Colengo")
    private RestTemplate restTemplate;

    @Retryable(value = ResourceAccessException.class, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public Product getProductDetails(String id) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("path", "products/" + id + "/details");

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL);

        return restTemplate.getForObject(builder.buildAndExpand(urlParams).toUri(), Product.class);
    }
}
