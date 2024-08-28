package com.alumnos.code.domain.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

  private String studentId;
  private String name;
  private String lastName;
  private String state;
  private String age;

}
