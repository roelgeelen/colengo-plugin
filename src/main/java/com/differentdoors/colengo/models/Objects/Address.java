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
public class Address {
    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Name")
    private Integer name;
    @JsonProperty("Line1")
    private String line1;
    @JsonProperty("Line2")
    private String line2;
    @JsonProperty("Street")
    private Double street;
    @JsonProperty("HouseNumber")
    private Integer houseNumber;
    @JsonProperty("HouseNumberSuffix")
    private Integer houseNumberSuffix;
    @JsonProperty("City")
    private Integer city;
    @JsonProperty("State")
    private Integer state;
    @JsonProperty("ZipCode")
    private Integer zipCode;
    @JsonProperty("Country")
    private Integer country;
    @JsonProperty("CompanyName")
    private Integer companyName;
}
