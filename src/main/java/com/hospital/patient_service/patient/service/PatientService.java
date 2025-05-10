package com.hospital.patient_service.patient.service;

import com.hospital.patient_service.patient.dto.PatientDTO;
import com.hospital.patient_service.patient.dto.PatientRequestDto;
import com.hospital.patient_service.patient.mapper.PatientMapper;
import com.hospital.patient_service.patient.model.Patient;
import com.hospital.patient_service.patient.repository.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public boolean removePatientByID(UUID patientId) throws SQLException {

        Optional<Patient> patient = patientRepository.findById(patientId);
        if (patient.isEmpty()) {
            throw new SQLException("patient id not found");
        }
        patientRepository.delete(patient.get());
        return true;
    }

    public boolean dischargePatientByID(UUID patientId) throws SQLException {

        Optional<Patient> patient = patientRepository.findById(patientId);
        if (patient.isEmpty()) {
            throw new SQLException("patient id not found");
        }

        if(patient.get().isDischarge()){
            return false;
        }
         Patient nonNullPatient = patient.get();
        nonNullPatient.setDischarge(true);
        nonNullPatient.setDischargeDate(Date.valueOf(LocalDate.now()));
         patientRepository.save(nonNullPatient);


        return true;
    }
}
