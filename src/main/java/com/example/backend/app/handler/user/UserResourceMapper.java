package com.example.backend.app.handler.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

import com.example.backend.domain.model.User;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserResourceMapper {
    
    @Mapping(source = "userName", target = "name")
    User resourceToModel(UserResource resource);
    
    @Mapping(source = "name", target = "userName")
    UserResource modelToResource(User model);

}
