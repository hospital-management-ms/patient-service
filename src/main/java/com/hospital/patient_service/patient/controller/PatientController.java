package com.hospital.patient_service.patient.controller;

import com.hospital.patient_service.patient.dto.PatientDTO;
import com.hospital.patient_service.patient.dto.PatientRequestDto;
import com.hospital.patient_service.patient.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
