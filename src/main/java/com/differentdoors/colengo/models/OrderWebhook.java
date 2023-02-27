package com.differentdoors.colengo.models;

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
public class OrderWebhook {
    @JsonProperty("OrderAutomaticLoginUrl")
    private String orderAutomaticLoginUrl;
    @JsonProperty("OrderDate")
    private String orderDate;
    @JsonProperty("OrderInvoiceDownloadLink")
    private String orderInvoiceDownloadLink;
    @JsonProperty("OrderNumber")
    private String orderNumber;
    @JsonProperty("ShopUserAchievements")
    private String shopUserAchievements;
    @JsonProperty("ShopUserEmail")
    private String shopUserEmail;
    @JsonProperty("ShopUserId")
    private Integer shopUserId;
    @JsonProperty("ShopUserName")
    private String shopUserName;
    @JsonProperty("ShopUserTelephoneNumber")
    private String shopUserTelephoneNumber;
}
