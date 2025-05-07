package com.hospital.patient_service.patient.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private UUID id;
    @NonNull
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String email;
    private String address;
    private Date  dateOfBirth;
    private Date registeredDate;

}
