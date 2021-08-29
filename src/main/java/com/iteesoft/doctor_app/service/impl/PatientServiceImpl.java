package com.iteesoft.doctor_app.service.impl;

import com.iteesoft.doctor_app.model.Patient;
import com.iteesoft.doctor_app.repository.PatientRepository;
import com.iteesoft.doctor_app.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> findPatientByEmailAndPassword(String email, String password){
        return patientRepository.findPatientByEmailAndPassword(email,password);
    }

    @Override
    public Patient findPatientById(Long id) {
        return patientRepository.getById(id);
    }

}
