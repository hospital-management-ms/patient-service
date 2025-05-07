package com.hospital.patient_service.patient.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString
public class PatientRequestDto {

    @NotBlank(message = "Name is required")
    @Size(max=100,message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Not a valid mail")
    private String email;

    @NotBlank(message = "Address is required")
    @Size(max=300,message = "Name address exceed 100 characters")
    private String address;

    @NotBlank(message = "DateOfBirth is required")
    private String dateOfBirth;

    @NotBlank(message = "RegisteredDate is required")
    private String registeredDate;


}
