package com.example.orderservice.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

@Configuration
public class PageConfig {
    @Autowired
    public void configure(ObjectMapper objectMapper){
        objectMapper.addMixIn(Page.class,PageOutput.class);
    }
    @JsonIgnoreProperties({"sort", "pageable", "empty"})
    @JsonPropertyOrder({"number", "size", "total_pages", "total_elements", "first",
            "number_of_elements", "last", "content"})
    public interface PageOutput {
        @JsonProperty("total_pages")
        int getTotalPages();
        @JsonProperty("total_elements")
        long getTotalElements();
        @JsonProperty("number_of_elements")
        int getNumberOfElements();
    }
}
