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
public class Order {
    private Integer productId;
    private Integer shopUserId;
    private String firstName;
    private String lastName;
    private String userComment;

//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Europe/Paris")
//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//    @JsonProperty("Created")
//    private Instant created;
//
//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Europe/Paris")
//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//    @JsonProperty("Modified")
//    private Instant modified;
    private Integer shopUserAddressId;
    private Integer billingAddressId;
    private TotalPrice totalPrice;
}
