package com.bitpixeled.ankettoplamamerkezi.v1.converter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface GenericConverter <E, D> {
    E fromDto(D dto);
    D fromEntity(E entity);
//    E updateEntity(E entity, D dto);
    default List<D> createFromEntities(final Collection<E> entities) {
        return entities.stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }
    default List<E> createFromDtos(final Collection<D> dtos) {
        return dtos.stream()
                .map(this::fromDto)
                .collect(Collectors.toList());
    }
}

