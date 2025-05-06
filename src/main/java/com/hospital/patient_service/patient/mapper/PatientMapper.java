package com.hospital.patient_service.patient.mapper;

import com.hospital.patient_service.patient.dto.PatientDTO;
import com.hospital.patient_service.patient.model.Patient;

public class PatientMapper {

    public static PatientDTO toDTO(Patient patient){

        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId().toString());
        patientDTO.setName(patient.getName());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setDateOfBirth(patient.getDateOfBirth().toString());

        return patientDTO;
    }
}
