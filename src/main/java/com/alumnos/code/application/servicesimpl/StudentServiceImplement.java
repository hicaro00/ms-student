package com.alumnos.code.application.servicesimpl;


import com.alumnos.code.application.exepciones.CreateStudenExeption;
import com.alumnos.code.application.exepciones.GetStudentByStateException;
import com.alumnos.code.application.mapper.StudentMapperManual;
import com.alumnos.code.application.outPort.StudentPersistance;
import com.alumnos.code.application.services.StudentService;
import com.alumnos.code.infrastructure.in.dtos.StudentRequestDto;
import com.alumnos.code.infrastructure.in.dtos.StudentResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

public class StudentServiceImplement implements StudentService {

  private final StudentPersistance studentPersistence;
  private final StudentMapperManual studentMapperManual;

    public StudentServiceImplement(StudentPersistance studentPersistence, StudentMapperManual studentMapperManual) {
        this.studentPersistence = studentPersistence;
        this.studentMapperManual = studentMapperManual;
    }


    @Override
    public Mono<String> createStudent(StudentRequestDto studentRequestDto) {
        return studentPersistence.createStudent(studentMapperManual.toStudentDomain(studentRequestDto))
                .onErrorMap(e -> new CreateStudenExeption("Error al guardar en la base de datos"));
    }

    @Override
    public Flux<StudentResponseDto> getStudentByState(String state) {
        return studentPersistence.getStudentByState(state)
                .map(studentMapperManual::toStudentResponse)
                .onErrorMap(e -> new GetStudentByStateException("Error al obtener los estudiantes por estado"));
    }
}
