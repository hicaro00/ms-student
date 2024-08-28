package com.alumnos.code.infrastructure.exeptionhandler;

import com.alumnos.code.application.exepciones.CreateStudenExeption;
import com.alumnos.code.application.exepciones.GetStudentByStateException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class GloblaExeptionHandler {

    @ExceptionHandler(CreateStudenExeption.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mono<String> handleCreateStudentException(CreateStudenExeption e, ServerWebExchange exchange){
        return Mono.just("Error al crear el estudiante: "+e.getMessage());
    }

    @ExceptionHandler(GetStudentByStateException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mono<String> handleGetStudentByStateException(GetStudentByStateException e, ServerWebExchange exchange) {
        return Mono.just("Error al obtener los estudiantes por estado: " + e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Mono<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, ServerWebExchange exchange) {
        return Mono.just("Error de validación: " + e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
