package com.neoris.pruebaInditexMod.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Price {
    @JsonIgnore
    private Long id;
    private Long brandId;
    private LocalDateTime starterDate;
    private LocalDateTime endDate;
    private Long priceList;
    private Long productId;
    @JsonIgnore
    private Integer priority;
    private Double price;
    @JsonIgnore
    private String currency;

    public Price() {
    }
}
