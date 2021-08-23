package com.iteesoft.doctor_app.repository;

import com.iteesoft.doctor_app.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    Optional<Doctor> findDoctorByEmailAndPassword(String email,String password);
}
