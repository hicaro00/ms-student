package com.alumnos.code.infrastructure.in.dtos;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentRequestDto implements Serializable {


  @NotBlank
  @NotNull
  private String name;
  @NotBlank
  @NotNull
  private String lastName;
  @NotBlank
  @NotNull
  private String state;
  @NotBlank
  @NotNull
  private String age;

}
