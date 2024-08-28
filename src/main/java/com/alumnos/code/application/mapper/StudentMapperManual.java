package com.alumnos.code.application.mapper;

import com.alumnos.code.domain.models.Student;
import com.alumnos.code.infrastructure.in.dtos.StudentRequestDto;
import com.alumnos.code.infrastructure.in.dtos.StudentResponseDto;
import org.springframework.stereotype.Component;

@Component
public class StudentMapperManual {



        public StudentResponseDto toStudentResponse(Student student) {
            StudentResponseDto studentResponseDto = new StudentResponseDto();
            studentResponseDto.setId(student.getStudentId());
            studentResponseDto.setName(student.getName());
            studentResponseDto.setLastName(student.getLastName());
            studentResponseDto.setAge(student.getAge());
            studentResponseDto.setState(student.getState());
            return studentResponseDto;
        }

        public Student toStudentDomain(StudentRequestDto studentRequestDto) {
            Student student = new Student();
            student.setName(studentRequestDto.getName());
            student.setLastName(studentRequestDto.getLastName());
            student.setAge(studentRequestDto.getAge());
            student.setState(studentRequestDto.getState());
            return student;
        }



}
