package com.inditex.pruebainditexmod.usecase;

import com.neoris.pruebaInditexMod.entities.Price;
import com.neoris.pruebaInditexMod.repository.PriceRepository;
import com.neoris.pruebaInditexMod.useCase.FindMatchingPriceUseCaseImpl;
import com.neoris.pruebaInditexMod.usecases.FindMatchingPriceUsesCases;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FindMatchingPriceUseCaseTest {

    @Mock
    PriceRepository priceRepository;
    @Mock
    Price price;

    @InjectMocks
    FindMatchingPriceUseCaseImpl findMatchingPriceUsesCases;

    AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllPrices() {
        Long brandId = Long.valueOf(1);
        Long productId = Long.valueOf(35455);
        String dateTimeString = "2020-06-14T18:30:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        Price expectedPrice = new Price();
        when(priceRepository.findMatchingPrices(brandId, productId, dateTime)).thenReturn(expectedPrice);
        assertEquals(expectedPrice, expectedPrice);

    }
}
