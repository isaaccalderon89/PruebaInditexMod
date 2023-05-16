package com.neoris.pruebaInditexMod.infrastructure.mapper.inmemory;

import com.neoris.pruebaInditexMod.entities.Price;
import com.neoris.pruebaInditexMod.infrastructure.domain.entity.InMemoryPriceRepositoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface InMemoryPriceEntityMapper extends InMemoryEntityMapper<Price, InMemoryPriceRepositoryEntity>{
    InMemoryPriceEntityMapper INSTANCE = Mappers.getMapper(InMemoryPriceEntityMapper.class);

    @Override
    @Mapping(source="id", target= "id")
    Price toDomainEntity(InMemoryPriceRepositoryEntity inmemoryEntity);
}
