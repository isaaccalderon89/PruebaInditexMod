package com.neoris.pruebaInditexMod.usecases;

import com.neoris.pruebaInditexMod.entities.Price;

import java.time.LocalDateTime;

public interface FindMatchingPriceUsesCases {
    Price findMatchingPrices(Long brandId, Long productId, LocalDateTime dateTime);
}
