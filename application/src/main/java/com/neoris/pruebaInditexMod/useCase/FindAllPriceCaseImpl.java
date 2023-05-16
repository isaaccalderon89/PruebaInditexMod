package com.neoris.pruebaInditexMod.useCase;

import com.neoris.pruebaInditexMod.entities.Price;
import com.neoris.pruebaInditexMod.repository.PriceRepository;
import com.neoris.pruebaInditexMod.usecases.FindAllPriceUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllPriceCaseImpl implements FindAllPriceUseCase {

    @Autowired
    private PriceRepository priceRepository;

    public FindAllPriceCaseImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public List<Price> findAllPrice() {
        return priceRepository.findAllPrice();
    }
}
