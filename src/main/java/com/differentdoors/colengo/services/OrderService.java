package com.differentdoors.colengo.services;

import com.differentdoors.colengo.models.Objects.Order.Order;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {
    @Value("${different_doors.colengo.url}")
    private String URL;

    @Autowired
    @Qualifier("Colengo")
    private RestTemplate restTemplate;

    private final ObjectMapper objectMapper = JsonMapper.builder()
            .findAndAddModules()
            .serializationInclusion(JsonInclude.Include.NON_NULL)
            .build();

    @Retryable(value = ResourceAccessException.class, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public Order getOrderDetails(String id) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("path", "orders/" + id + "/details");

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL);

        return restTemplate.getForObject(builder.buildAndExpand(urlParams).toUri(), Order.class);
    }

    @Retryable(value = ResourceAccessException.class, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public void updateOrderStatus(String id, int status) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("path", "orders/" + id + "/updateorderstatus");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL);

        Map<String, Integer> map = new HashMap<>();
        map.put("Status", status);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(map, headers);
        restTemplate.exchange(builder.buildAndExpand(urlParams).toUri(), HttpMethod.POST, requestEntity, String.class);
    }
}
