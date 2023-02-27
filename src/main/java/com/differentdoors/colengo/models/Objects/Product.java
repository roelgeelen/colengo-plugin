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
public class Product {
    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Url")
    private String url;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ShowInStore")
    private Boolean ShowInStore;
    @JsonProperty("Price")
    private String Price;
    @JsonProperty("OriginalPrice")
    private String OriginalPrice;
    @JsonProperty("ShortDescription")
    private String ShortDescription;
    @JsonProperty("DescriptionHtml")
    private String DescriptionHtml;
    @JsonProperty("SocialMediaLine")
    private String SocialMediaLine;
    @JsonProperty("Notes")
    private String Notes;
}
