package com.patientservice.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequestDto {
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Enter a valid email")
    private String email;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Date of Birth is required")
    private String dateOfBirth;

    @NotNull(message = "Registered Date is required")
    private String registeredDate;


}

