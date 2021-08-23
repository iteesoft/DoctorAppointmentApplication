package com.iteesoft.doctor_app.service.impl;

import com.iteesoft.doctor_app.model.Doctor;
import com.iteesoft.doctor_app.repository.DoctorRepository;
import com.iteesoft.doctor_app.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor findDoctorById(Long id) {
        return doctorRepository.getById(id);
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Optional<Doctor> findDoctorByEmailAndPassword(String email, String password){
        return doctorRepository.findDoctorByEmailAndPassword(email,password);
    }
}
