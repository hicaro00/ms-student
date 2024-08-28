package com.alumnos.code.infrastructure.in.dtos;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto implements Serializable {

  @Id
  private String id;
  private String name;
  private String lastName;
  private String state;
  private String age;

}
