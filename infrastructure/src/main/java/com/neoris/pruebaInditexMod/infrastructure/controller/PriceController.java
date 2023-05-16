package com.neoris.pruebaInditexMod.infrastructure.controller;

import com.neoris.pruebaInditexMod.entities.Price;
import com.neoris.pruebaInditexMod.infrastructure.repository.PriceEntityRepository;
import com.neoris.pruebaInditexMod.usecases.FindAllPriceUseCase;
import com.neoris.pruebaInditexMod.usecases.FindMatchingPriceUsesCases;
import com.neoris.pruebaInditexMod.usecases.FindPriceByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class PriceController {
    @Autowired
    private FindMatchingPriceUsesCases findMatchingPricesUseCase;
    @Autowired
    private FindPriceByIdUseCase findPriceByIdUsesCase;
    @Autowired
    private FindAllPriceUseCase findAllPriceUseCase;
    private PriceEntityRepository priceEntityRepository;

    public PriceController(FindMatchingPriceUsesCases findMatchingPricesUseCase, FindPriceByIdUseCase findPriceByIdUsesCase, FindAllPriceUseCase findAllPriceUseCase, PriceEntityRepository priceEntityRepository) {
        this.findMatchingPricesUseCase = findMatchingPricesUseCase;
        this.findPriceByIdUsesCase = findPriceByIdUsesCase;
        this.findAllPriceUseCase = findAllPriceUseCase;
        this.priceEntityRepository = priceEntityRepository;
    }

    /**
     * Este método lo he creado para comprobar que la conexión a la Base de Datos funciona correctamente
     * @return una lista con todos los datos que hay dentro.
     */
    @GetMapping(value = "/price", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Price>> getByAllPrice(){
        return ResponseEntity.ok(findAllPriceUseCase.findAllPrice());
    }

    /**
     * Este método lo he creado porque me daba un fallo y quería comprobar si el problema estaba en la llamada
     * al controller.
     * @return una cadena de texto
     */
    @GetMapping(value = "/prueba", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPrueba(){
        return ResponseEntity.ok("Prueba controlador");
    }

    /**
     * Este método lo he añadido para ver si la búsqueda por parámetros lo realiza correctamente. Ahora voy a añadir
     * el resto de atributos que pide la prueba.
     * @param id Recibe por parámetros un id que he añadido a la tabla.
     * @return una Json con los datos de la entidad que pasamos por parámetros
     */
    @GetMapping(value = "/price/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Price> getPriceById(@PathVariable Long id){
        return ResponseEntity.ok(findPriceByIdUsesCase.findPriceById(id));
    }

    @GetMapping(value = "/price/{brandId}/{productId}/{dateTime}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Price> getPriceByBrandIProductIdDateTime(@PathVariable Long brandId,@PathVariable Long productId,@PathVariable String dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime finalDate = LocalDateTime.parse(dateTime, formatter);
        return ResponseEntity.ok(findMatchingPricesUseCase.findMatchingPrices(brandId,productId,finalDate));
    }

}
