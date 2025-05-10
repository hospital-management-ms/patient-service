package com.hospital.patient_service.patient.dto;

import lombok.Data;

@Data
public class PatientDTO {
    private String id;
    private String name;
    private String email;
    private String address;
    private String dateOfBirth;
    private boolean isDischarge;
    private String dischargeDate;
}
