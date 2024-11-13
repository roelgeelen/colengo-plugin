package com.differentdoors.colengo.models.Auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Token {
    @JsonProperty("RefreshToken")
    private String refreshToken;
    @JsonProperty("AccessToken")
    private String accessToken;
    @JsonProperty("ExpiresIn")
    private Long expiresIn;
    @JsonIgnore
    private Instant obtained_at;

    public boolean isExpired() {
        return obtained_at == null || (obtained_at.toEpochMilli() + (expiresIn * 1000)) < Instant.now().toEpochMilli();
    }
}
