package com.differentdoors.colengo.models;

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
public class CResults<T> {
    @JsonProperty("TotalItems")
    private Integer totalItems;
    @JsonProperty("CurrentPage")
    private Integer currentPage;
    @JsonProperty("TotalPages")
    private Integer totalPages;
    @JsonProperty("Items")
    private List<T> items;
}
