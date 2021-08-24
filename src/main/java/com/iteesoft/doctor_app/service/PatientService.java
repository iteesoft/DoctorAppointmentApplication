package com.iteesoft.doctor_app.service;

import com.iteesoft.doctor_app.model.Patient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface PatientService {
    Patient savePatient(Patient patient);
    Optional<Patient> findPatientByEmailAndPassword(String email, String password);
}