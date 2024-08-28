package com.alumnos.code.infrastructure.out.repository;


import com.alumnos.code.infrastructure.out.document.StudentDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StudentRepository extends ReactiveMongoRepository< StudentDocument, String> {

    Flux<StudentDocument> findByState(String state);
}
