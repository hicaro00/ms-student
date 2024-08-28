package com.alumnos.code.application.outPort;

import com.alumnos.code.domain.models.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentPersistance {

     Mono<String> createStudent(Student studentDomain);
     Flux<Student> getStudentByState(String state);


}
