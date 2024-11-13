package com.differentdoors.colengo.models.Objects.Order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TotalPrice {
    @JsonProperty("Amount")
    private Double amount;
    @JsonProperty("Currency")
    private String currency;
    @JsonProperty("DisplayName")
    private String displayName;
    @JsonProperty("Sign")
    private String sign;
    @JsonProperty("IsDefault")
    private Boolean isDefault;
}
