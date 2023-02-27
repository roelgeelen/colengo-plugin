package com.differentdoors.colengo.models.Objects;

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
public class Shipment {
    @JsonProperty("OrderId")
    private Integer orderId;
    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Status")
    private Integer status;
    @JsonProperty("TrackAndTraceId")
    private String trackAndTraceId;
    @JsonProperty("ExpectedDeliveryDate")
    private String expectedDeliveryDate;
    @JsonProperty("Price")
    private Double price;
    @JsonProperty("ShipmentMethodId")
    private Integer shipmentMethodId;
}
