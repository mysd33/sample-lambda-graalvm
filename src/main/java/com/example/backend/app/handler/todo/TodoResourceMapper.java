package com.example.backend.app.handler.todo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

import com.example.backend.domain.model.Todo;

@Mapper(componentModel = ComponentModel.SPRING)
public interface TodoResourceMapper {

   
    @Mapping(target = "todoId", ignore = true)
    @Mapping(source = "todoTitle", target = "title")
    Todo resourceToModel(TodoResourceForInput resource);

    @Mapping(source = "title", target = "todoTitle")
    TodoResource modelToResource(Todo model);

}
