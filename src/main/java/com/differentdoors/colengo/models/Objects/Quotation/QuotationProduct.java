package com.differentdoors.colengo.models.Objects.Quotation;

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
public class QuotationProduct {
    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("ProductId")
    private Integer productId;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Note")
    private String note;
    @JsonProperty("ConfigKey")
    private String configKey;
    @JsonProperty("Url")
    private String url;
    @JsonProperty("Product3DScreenshotUrl")
    private String product3DScreenshotUrl;
    @JsonProperty("Amount")
    private Integer amount;
    @JsonProperty("Price")
    private QuotationPrice price;
    @JsonProperty("Discount")
    private QuotationPrice discount;
}
