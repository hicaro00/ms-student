package com.alumnos.code.application.servicesimpl;

import com.alumnos.code.application.mapper.StudentMapperManual;
import com.alumnos.code.application.outPort.StudentPersistance;
import com.alumnos.code.domain.models.Student;
import com.alumnos.code.infrastructure.in.dtos.StudentRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplementTest {

    private StudentPersistance studentPersistence;
    private StudentMapperManual studentMapperManual;
    private StudentServiceImplement studentServiceImplement;


    @BeforeEach

    public void setup() {                  // este metodo se ejecuta antes de cada test

        studentPersistence = Mockito.mock(StudentPersistance.class); // mock de la clase StudentPersistance
        studentMapperManual = Mockito.mock(StudentMapperManual.class); // mock de la clase StudentMapperManual
        studentServiceImplement = new StudentServiceImplement(studentPersistence, studentMapperManual); //  instancia de la clase StudentServiceImplement
    }


    @Test
    void createStudent() {

        StudentRequestDto studentRequestDto = new StudentRequestDto();  //  instancia de la clase StudentRequestDto
            // se crea un mock de la clase StudentPersistance
        Mockito.when(studentMapperManual.toStudentDomain(studentRequestDto)).thenReturn(new Student());  // se crea un mock de la clase StudentMapperManual
        Mockito.when(studentPersistence.createStudent(Mockito.any(Student.class))).thenReturn(Mono.just("Success")); // se crea un mock de la clase StudentPersistance


        StepVerifier.create(studentServiceImplement.createStudent(studentRequestDto))// se crea un StepVerifier con el metodo createStudent de la clase StudentServiceImplement
                .expectNext("Success")  // se espera que el siguiente valor sea "Success"
                .verifyComplete();  // se verifica que se haya completado

    }

    @Test
    void getStudentByState() {

        }

}