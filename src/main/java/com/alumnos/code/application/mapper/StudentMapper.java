package com.alumnos.code.application.mapper;

import com.alumnos.code.domain.models.Student;
import com.alumnos.code.infrastructure.in.dtos.StudentRequestDto;
import com.alumnos.code.infrastructure.in.dtos.StudentResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface StudentMapper {


}
