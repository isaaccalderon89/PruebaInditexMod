package com.inditex.pruebainditexmod.usecase;

import com.neoris.pruebaInditexMod.entities.Price;
import com.neoris.pruebaInditexMod.repository.PriceRepository;
import com.neoris.pruebaInditexMod.useCase.FindPriceByIdUsesCaseImpl;
import com.neoris.pruebaInditexMod.usecases.FindPriceByIdUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FindPriceByIdUseCaseTest {

    @Mock
    PriceRepository priceRepository;

    Price price;
    @InjectMocks
    FindPriceByIdUsesCaseImpl findPriceByIdUsesCase;

    AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllPrices(){
        Long id = Long.valueOf(1);
        when(priceRepository.findPriceById(id)).thenReturn(price);
        Price result = findPriceByIdUsesCase.findPriceById(id);
        assertEquals(price,result);

    }
}
