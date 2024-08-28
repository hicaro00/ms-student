package com.alumnos.code.infrastructure.out.persistenceImplement;

import com.alumnos.code.application.exepciones.GetStudentByStateException;
import com.alumnos.code.application.outPort.StudentPersistance;
import com.alumnos.code.domain.models.Student;
import com.alumnos.code.infrastructure.out.mapper.DocumentMappeer;
import com.alumnos.code.infrastructure.out.mapper.MapperUltimo;
import com.alumnos.code.infrastructure.out.repository.StudentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentPersistenceImplements implements StudentPersistance{


    private final StudentRepository studentRepository;
    private final MapperUltimo mapperUltimo;


    public StudentPersistenceImplements(StudentRepository studentRepository, MapperUltimo mapperUltimo) {
        this.studentRepository = studentRepository;


        this.mapperUltimo = mapperUltimo;
    }

    @Override
    public Mono<String> createStudent(Student studentDomain) {
        return studentRepository.save(mapperUltimo.toStudentDocument(studentDomain))
                .map(studentDocument -> "se Guardo con exito en la  base de DATOS")
                .onErrorReturn("Error al guardar en la base de datos");
    }

    @Override
    public Flux<Student> getStudentByState(String state) {
        return studentRepository.findByState(state)
                .map(mapperUltimo::toStudentDomain)
                .onErrorMap(e -> new GetStudentByStateException("Error en la conexion a base de datos"));
    }
}
