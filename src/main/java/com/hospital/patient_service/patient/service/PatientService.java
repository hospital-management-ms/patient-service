package com.hospital.patient_service.patient.service;

import com.hospital.patient_service.patient.dto.PatientDTO;
import com.hospital.patient_service.patient.dto.PatientRequestDto;
import com.hospital.patient_service.patient.mapper.PatientMapper;
import com.hospital.patient_service.patient.model.Patient;
import com.hospital.patient_service.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

      private final PatientRepository patientRepository;

      public PatientService(PatientRepository patientRepository){
          this.patientRepository=patientRepository;
      }

      public List<PatientDTO>  getAllPatient(){

            List<Patient> patients = patientRepository.findAll();
            return patients.stream().map(PatientMapper::toDTO).toList();
      }

      public PatientDTO insertPatient(PatientRequestDto patientRequestDto) {
          Patient result = patientRepository.save(PatientMapper.toModel(patientRequestDto));
          return PatientMapper.toDTO(result);
      }

}
