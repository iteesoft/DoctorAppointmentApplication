package com.iteesoft.doctor_app.service.impl;

import com.iteesoft.doctor_app.model.Patient;
import com.iteesoft.doctor_app.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Override
    public Patient savePatient(Patient patient) {
        return null;
    }

    @Override
    public Optional<Patient> findPatientByEmailAndPassword(String email, String password) {
        return Optional.empty();
    }
}
