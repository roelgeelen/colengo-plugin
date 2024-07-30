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
    private Integer id;
    private Integer email;
    private String firstName;
    private String lastName;
    private String shopUserId;
    private String created;
    private String modified;
    private List<QuotationProduct> products;
}
