package com.neoris.pruebaInditexMod.useCase;

import com.neoris.pruebaInditexMod.entities.Price;
import com.neoris.pruebaInditexMod.repository.PriceRepository;
import com.neoris.pruebaInditexMod.usecases.FindPriceByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindPriceByIdUsesCaseImpl implements FindPriceByIdUseCase {

    @Autowired
    private PriceRepository priceRepository;

    public FindPriceByIdUsesCaseImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price findPriceById(Long id) {
        return priceRepository.findPriceById(id);
    }
}
