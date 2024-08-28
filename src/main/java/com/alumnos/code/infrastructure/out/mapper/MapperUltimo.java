package com.alumnos.code.infrastructure.out.mapper;

import com.alumnos.code.domain.models.Student;
import com.alumnos.code.infrastructure.out.document.StudentDocument;
import org.springframework.stereotype.Component;

@Component
public class MapperUltimo {


        public  Student toStudentDomain(StudentDocument studentDocument) {
            Student student = new Student();
            student.setStudentId(studentDocument.getStudentId());
            student.setName(studentDocument.getName());
            student.setLastName(studentDocument.getLastName());
            student.setState(studentDocument.getState());
            student.setAge(studentDocument.getAge());
            return student;
        }

        public  StudentDocument toStudentDocument(Student student) {
            StudentDocument studentDocument = new StudentDocument();
            studentDocument.setStudentId(student.getStudentId());
            studentDocument.setName(student.getName());
            studentDocument.setLastName(student.getLastName());
            studentDocument.setState(student.getState());
            studentDocument.setAge(student.getAge());
            return studentDocument;
        }

}
