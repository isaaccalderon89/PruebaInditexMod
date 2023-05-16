package com.inditex.pruebainditexmod.usecase;

import com.neoris.pruebaInditexMod.entities.Price;
import com.neoris.pruebaInditexMod.repository.PriceRepository;
import com.neoris.pruebaInditexMod.useCase.FindAllPriceCaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FindAllPriceUseCaseTest {

    @Mock
    PriceRepository priceRepository;

    List<Price> priceList;

    @InjectMocks
    FindAllPriceCaseImpl findAllPriceCaseImpl;

    AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllPrices(){
        when(priceRepository.findAllPrice()).thenReturn(priceList);
        List<Price> result = findAllPriceCaseImpl.findAllPrice();
        assertEquals(priceList,result);

    }
}
