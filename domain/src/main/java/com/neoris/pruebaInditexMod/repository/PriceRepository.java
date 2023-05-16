package com.neoris.pruebaInditexMod.repository;

import com.neoris.pruebaInditexMod.entities.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {

    List<Price> findAllPrice();

    Price findPriceById(Long id);

    Price findMatchingPrices(Long brandId, Long productId, LocalDateTime dateTime);
}
