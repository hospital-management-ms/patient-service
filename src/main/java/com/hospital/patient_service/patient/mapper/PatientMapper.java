package com.hospital.patient_service.patient.mapper;

import com.hospital.patient_service.patient.dto.PatientDTO;
import com.hospital.patient_service.patient.dto.PatientRequestDto;
import com.hospital.patient_service.patient.model.Patient;

import java.sql.Date;
import java.time.LocalDate;

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

    public static Patient toModel(PatientRequestDto patientRequestDto){

        Patient patient = new Patient();
        patient.setName(patientRequestDto.getName());
        patient.setEmail(patientRequestDto.getEmail());
        patient.setAddress(patientRequestDto.getAddress());
        patient.setDateOfBirth(Date.valueOf(LocalDate.parse(patientRequestDto.getDateOfBirth())));
        patient.setRegisteredDate(Date.valueOf(LocalDate.parse(patientRequestDto.getRegisteredDate())));

        return patient;
    }

    public static Patient toModel(PatientDTO patientDto){

        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setEmail(patientDto.getEmail());
        patient.setAddress(patientDto.getAddress());
        patient.setDateOfBirth(Date.valueOf(LocalDate.parse(patientDto.getDateOfBirth())));

        return patient;
    }
}
