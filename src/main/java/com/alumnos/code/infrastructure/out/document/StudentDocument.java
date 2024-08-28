package com.alumnos.code.infrastructure.out.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDocument {

    @Id
    private String studentId;
    private String name;
    private String lastName;
    private String state;
    private String age;

}
