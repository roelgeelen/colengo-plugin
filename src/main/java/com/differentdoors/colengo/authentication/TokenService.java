package com.differentdoors.colengo.authentication;

import com.differentdoors.colengo.dal.RefreshToken;
import com.differentdoors.colengo.dal.repository.RefreshTokenRepository;
import com.differentdoors.colengo.models.Auth.Token;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Instant;
import java.util.*;


@Service
public class TokenService {
    @Value("${different_doors.colengo.url}")
    private String URL;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    private final RestTemplate simpleRestTemplate;
    private Token tokenCache;

    private final ObjectMapper objectMapper = JsonMapper.builder()
            .findAndAddModules()
            .serializationInclusion(JsonInclude.Include.NON_NULL)
            .build();

    public TokenService() {
        simpleRestTemplate = new RestTemplateBuilder().
                build();
    }

    public Token getRefreshedToken() {
        if (tokenCache == null || tokenCache.isExpired()) {
            tokenCache = refreshOAuthToken();
        }
        return tokenCache;
    }

    private Token refreshOAuthToken() {
        return loginWithRefreshToken(getRefreshToken());
    }

    private Token loginWithRefreshToken(String refreshToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Token token = new Token();
        token.setRefreshToken(refreshToken);

        HttpEntity<Object> request = null;
        try {
            request = new HttpEntity<>(objectMapper.writeValueAsString(token), headers);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Map<String, String> urlParams = new HashMap();
        urlParams.put("path", "tokens/renewtokens");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(this.URL);
        Token refreshedToken = simpleRestTemplate.postForObject(
                builder.buildAndExpand(urlParams).toUri(),
                request,
                Token.class
        );
        assert refreshedToken != null;
        refreshedToken.setObtained_at(Instant.now());
        saveNewRefreshToken(refreshedToken);
        return refreshedToken;
    }

    private String getRefreshToken() {
        Optional<RefreshToken> optionalRefreshToken = refreshTokenRepository.findByName("colengo");
        return optionalRefreshToken.map(RefreshToken::getRefreshToken).orElse(null);
    }

    private void saveNewRefreshToken(Token token) {
        Optional<RefreshToken> optionalRefreshToken = refreshTokenRepository.findByName("colengo");
        if (optionalRefreshToken.isPresent()) {
            RefreshToken refreshToken = optionalRefreshToken.get();
            refreshToken.setRefreshToken(token.getRefreshToken());
            refreshToken.setUpdated_at(new Date());
            refreshTokenRepository.save(refreshToken);
        }
    }
}