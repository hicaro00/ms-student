package com.alumnos.code.infrastructure.in.controllers;


import com.alumnos.code.application.services.StudentService;
import com.alumnos.code.infrastructure.in.dtos.StudentRequestDto;
import com.alumnos.code.infrastructure.in.dtos.StudentResponseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/student")
@Slf4j
@Validated
public class StudentController {

  private  StudentService studentService;


  @PostMapping(value = "create",produces = "application/json", consumes = "application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Mono<String>> createStudent(@Valid @RequestBody StudentRequestDto studentDtoRequest){
    return new ResponseEntity<>(studentService.createStudent(studentDtoRequest), HttpStatus.CREATED);
  }

  @GetMapping(value = "/{state}",produces ="application/json")
  public ResponseEntity<Flux<StudentResponseDto>> getStudentByState(@PathVariable @Pattern(regexp = "^[a-zA-Z]*$",
          message = "El estado solo puede contener letras" ) String state){
    return new ResponseEntity<>(studentService.getStudentByState(state), HttpStatus.OK);
  }

}
