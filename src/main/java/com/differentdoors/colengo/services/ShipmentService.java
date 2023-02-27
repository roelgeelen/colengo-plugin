package com.differentdoors.colengo.services;

import com.differentdoors.colengo.models.CResults;
import com.differentdoors.colengo.models.Objects.Order.Order;
import com.differentdoors.colengo.models.Objects.Shipment;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
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
public class ShipmentService {
    @Value("${different_doors.colengo.url}")
    private String URL;

    private final ObjectMapper objectMapper = JsonMapper.builder()
            .findAndAddModules()
            .serializationInclusion(JsonInclude.Include.NON_NULL)
            .build();

    @Autowired
    @Qualifier("Colengo")
    private RestTemplate restTemplate;

    @Retryable(value = ResourceAccessException.class, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public CResults<Shipment> getOrderShipmentList(String id) throws Exception {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("path", "ordershipments/" + id + "/list");

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL);

        return objectMapper.readValue(restTemplate.getForObject(builder.buildAndExpand(urlParams).toUri(), String.class), new TypeReference<CResults<Shipment>>() {
        });
    }
}
