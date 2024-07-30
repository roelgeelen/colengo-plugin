package com.differentdoors.colengo.models.Objects.Quotation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    private Integer id;
    private Integer productId;
    private String title;
    private String note;
    private String configKey;
    private String url;
    private String product3DScreenshotUrl;
    private Integer amount;
    private QuotationPrice price;
    private QuotationPrice discount;
}
