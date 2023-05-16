package com.neoris.pruebaInditexMod.infrastructure.repository;

import com.neoris.pruebaInditexMod.entities.Price;
import com.neoris.pruebaInditexMod.infrastructure.domain.entity.InMemoryPriceRepositoryEntity;
import com.neoris.pruebaInditexMod.infrastructure.mapper.inmemory.InMemoryPriceEntityMapper;
import com.neoris.pruebaInditexMod.infrastructure.repository.jpa.PriceJpaRepository;
import com.neoris.pruebaInditexMod.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class PriceEntityRepository implements PriceRepository {

    @Autowired
    private PriceJpaRepository priceJpaRepository;

    @Override
    public List<Price> findAllPrice() {
        List<InMemoryPriceRepositoryEntity> result = priceJpaRepository.findAll();
        return InMemoryPriceEntityMapper.INSTANCE.toDomainEntityList(result);
    }

    @Override
    public Price findPriceById(Long id) {
        Optional<InMemoryPriceRepositoryEntity> result = priceJpaRepository.findById(id);
        return result.map(InMemoryPriceEntityMapper.INSTANCE::toDomainEntity).orElse(null);
    }

    @Override
    public Price findMatchingPrices(Long brandId, Long productId, LocalDateTime dateTime) {
        InMemoryPriceRepositoryEntity result = priceJpaRepository.findMatchingPrices(dateTime, productId, brandId);
        return InMemoryPriceEntityMapper.INSTANCE.toDomainEntity(result);
    }

}
