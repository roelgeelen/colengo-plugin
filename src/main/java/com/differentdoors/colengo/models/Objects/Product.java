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
    private Integer id;
    private String url;
    private String name;
    private Boolean ShowInStore;
    private String Price;
    private String OriginalPrice;
    private String ShortDescription;
    private String DescriptionHtml;
    private String SocialMediaLine;
    private String Notes;
}
