package com.example.backend.infra.repository;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import com.example.backend.domain.model.Todo;

@Mapper(componentModel = ComponentModel.SPRING)
public interface TodoTableItemMapper {
    Todo tableItemToModel(TodoTableItem tableItem);
    
    TodoTableItem modelToTableItem(Todo model);    
}
