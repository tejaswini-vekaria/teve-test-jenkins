package com.thymeleaf.start.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class EmployeeDTO {

    private Long id;

    @Size(min = 3,max = 20)
    @NotEmpty(message = "name should not empty")
    @NotNull(message = "name should not empty")
    @NotBlank(message = "name should not blank")
    private String name;

    @Email(regexp = "[a-zA-z0-9.@]")
    private String email;

    @NotBlank(message = "department should not blank")
    private String department;
}
