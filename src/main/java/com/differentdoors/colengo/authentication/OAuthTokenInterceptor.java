package com.differentdoors.colengo.authentication;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class OAuthTokenInterceptor implements ClientHttpRequestInterceptor {
    private final TokenService tokenService;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        request.getHeaders().add("Authorization", "PublicApi " + tokenService.getRefreshedToken().getAccessToken());
        return execution.execute(request, body);
    }
}