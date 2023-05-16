package com.neoris.pruebainditexmod.infrastructure.controller;

import com.neoris.pruebaInditexMod.entities.Price;
import com.neoris.pruebaInditexMod.infrastructure.controller.PriceController;
import com.neoris.pruebaInditexMod.usecases.FindAllPriceUseCase;
import com.neoris.pruebaInditexMod.usecases.FindMatchingPriceUsesCases;
import com.neoris.pruebaInditexMod.usecases.FindPriceByIdUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PriceControllerTest {

    @Mock
    FindMatchingPriceUsesCases findMatchingPricesUseCase;
    @Mock
    FindPriceByIdUseCase findPriceByIdUsesCase;
    @Mock
    FindAllPriceUseCase findAllPriceUseCase;

    List<Price> priceList;

    Price price;

    @InjectMocks
    PriceController priceController;

    AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void FindAll() {
        when(findAllPriceUseCase.findAllPrice()).thenReturn(priceList);
        ResponseEntity<List<Price>> result = priceController.getByAllPrice();
        assertEquals(priceList, result.getBody());
    }

    @Test
    void FindById() {
        when(findPriceByIdUsesCase.findPriceById(1l)).thenReturn(price);
        ResponseEntity<Price> result = priceController.getPriceById(1L);
        assertEquals(price, result.getBody());
    }

    @Test
    void FindByMatchingPrice() {
        Long brandId = 1L;
        Long productId = (long) 35455L;
        String dateTime = "2020-06-14T18:30:00";
        LocalDateTime finalDate = LocalDateTime.of(2020, 6, 14, 18, 30, 0);
        Price expectedPrice = new Price();

        when(findMatchingPricesUseCase.findMatchingPrices(brandId, productId, finalDate))
                .thenReturn(expectedPrice);
        ResponseEntity<Price> response = priceController.getPriceByBrandIProductIdDateTime(brandId, productId, dateTime);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedPrice, response.getBody());
    }

}
