package com.iteesoft.doctor_app.service;

import com.iteesoft.doctor_app.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<Doctor> getAllDoctors();
    Doctor saveDoctor(Doctor doctor);
    Doctor findDoctorById(Long id);
    void deleteDoctorById(Long id);
    Optional<Doctor> findDoctorByEmailAndPassword(String email, String password);

}
