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
    private Integer id;
    private String name;
    private String line1;
    private String line2;
    private String street;
    private Integer houseNumber;
    private String houseNumberSuffix;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String companyName;
}
