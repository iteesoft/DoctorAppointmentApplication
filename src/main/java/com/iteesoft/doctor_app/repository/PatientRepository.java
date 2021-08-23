package com.iteesoft.doctor_app.repository;

import com.iteesoft.doctor_app.model.Doctor;
import com.iteesoft.doctor_app.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Optional<Patient> findPatientByEmailAndPassword(String email, String password);
}
