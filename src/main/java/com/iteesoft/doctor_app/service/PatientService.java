package com.iteesoft.doctor_app.service;

import com.iteesoft.doctor_app.model.Patient;

import java.util.Optional;

public interface PatientService {
    Patient savePatient(Patient patient);
    Optional<Patient> findPatientByEmailAndPassword(String email, String password);
    Patient findPatientById(Long id);
}
