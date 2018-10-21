package com.example.demo.web.mapper;

import java.util.List;

public interface DemoMapper<E, D> {

    E mapToEntity(D dto);

    D mapToDto(E entity);

    List<E> mapToEntity(List<D> dtoList);
}
