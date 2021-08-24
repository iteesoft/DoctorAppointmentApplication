package com.iteesoft.doctor_app.service.impl;

import com.iteesoft.doctor_app.model.Doctor;
import com.iteesoft.doctor_app.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Override
    public List<Doctor> getAllDoctors() {
        return null;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return null;
    }

    @Override
    public Doctor findDoctorById(Long id) {
        return null;
    }

    @Override
    public void deleteDoctorById(Long id) {

    }

    @Override
    public Optional<Doctor> findDoctorByEmailAndPassword(String email, String password) {
        return Optional.empty();
    }
}
