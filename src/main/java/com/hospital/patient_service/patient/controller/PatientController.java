package com.hospital.patient_service.patient.controller;

import com.hospital.patient_service.patient.dto.PatientDTO;
import com.hospital.patient_service.patient.dto.PatientRequestDto;
import com.hospital.patient_service.patient.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatient(){
        return ResponseEntity.ok().body(patientService.getAllPatient());
    }
    @PostMapping
    public ResponseEntity<PatientDTO> onboardPatient(
            @Valid @RequestBody PatientRequestDto patientRequestDto
    ){

        return ResponseEntity.ok().body(patientService.insertPatient(patientRequestDto));
    }
    @DeleteMapping( "{id}")
    public ResponseEntity<String> deletePatient(@PathVariable UUID id ) {

        if(patientService.removePatientByID(id)){
            return ResponseEntity.ok("Patient removed successfully");
        }
        return ResponseEntity.internalServerError().body("Something went wrong");
    }

    @PostMapping("{id}")
    public ResponseEntity<String> setDischargeStatus(@PathVariable UUID id) throws SQLException {

     if(patientService.dischargePatientByID(id)){
         return ResponseEntity.ok("Patient discharged on:"+ LocalDateTime.now());
     }
        throw new ResponseStatusException(HttpStatus.CONFLICT, "Patient already discharged");
    }
}
