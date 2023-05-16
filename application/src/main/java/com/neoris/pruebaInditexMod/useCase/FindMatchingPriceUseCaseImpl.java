package com.neoris.pruebaInditexMod.useCase;

import com.neoris.pruebaInditexMod.entities.Price;
import com.neoris.pruebaInditexMod.repository.PriceRepository;
import com.neoris.pruebaInditexMod.usecases.FindMatchingPriceUsesCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FindMatchingPriceUseCaseImpl implements FindMatchingPriceUsesCases {
    @Autowired
    private PriceRepository priceRepository;

    public FindMatchingPriceUseCaseImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }


    @Override
    public Price findMatchingPrices(Long brandId, Long productId, LocalDateTime dateTime) {
        return priceRepository.findMatchingPrices(brandId, productId, dateTime);
    }
}
