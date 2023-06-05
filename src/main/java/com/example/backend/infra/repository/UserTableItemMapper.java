package com.example.backend.infra.repository;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import com.example.backend.domain.model.User;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserTableItemMapper {
    User tableItemToModel(UserTableItem tableItem);
    
    UserTableItem modelToTableItem(User model);    
}
