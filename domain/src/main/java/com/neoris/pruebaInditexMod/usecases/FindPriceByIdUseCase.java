package com.neoris.pruebaInditexMod.usecases;

import com.neoris.pruebaInditexMod.entities.Price;

public interface FindPriceByIdUseCase {

    Price findPriceById(Long id);
}
