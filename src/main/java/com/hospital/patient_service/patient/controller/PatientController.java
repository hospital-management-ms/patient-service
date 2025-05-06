package com.hospital.patient_service.patient.controller;

import com.hospital.patient_service.patient.dto.PatientDTO;
import com.hospital.patient_service.patient.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
