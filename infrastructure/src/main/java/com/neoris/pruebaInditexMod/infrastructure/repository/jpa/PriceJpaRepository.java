package com.neoris.pruebaInditexMod.infrastructure.repository.jpa;

import com.neoris.pruebaInditexMod.infrastructure.domain.entity.InMemoryPriceRepositoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PriceJpaRepository extends JpaRepository<InMemoryPriceRepositoryEntity, Long> {

    @Query("SELECT p FROM InMemoryPriceRepositoryEntity p WHERE p.brandId = :brandId AND p.productId = :productId AND p.starterDate <= :dateTime AND p.endDate >= :dateTime ORDER BY p.priority DESC LIMIT 1")
    InMemoryPriceRepositoryEntity findMatchingPrices(

            @Param("dateTime") LocalDateTime dateTime,

            @Param("productId") Long productId,

            @Param("brandId") Long brandId);
}
