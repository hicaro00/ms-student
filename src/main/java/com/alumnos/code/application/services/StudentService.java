package com.alumnos.code.application.services;


import com.alumnos.code.infrastructure.in.dtos.StudentRequestDto;
import com.alumnos.code.infrastructure.in.dtos.StudentResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {

  Mono<String> createStudent (StudentRequestDto studentDto);

  Flux<StudentResponseDto> getStudentByState (String state);

}
