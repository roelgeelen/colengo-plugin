package com.differentdoors.colengo.models.Objects.Quotation;

import com.differentdoors.colengo.models.Objects.Order.TotalPrice;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quotation {
    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Email")
    private Integer email;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("ShopUserId")
    private String shopUserId;
    @JsonProperty("Created")
    private String created;
    @JsonProperty("Modified")
    private String modified;
    @JsonProperty("Products")
    private List<QuotationProduct> products;
}
