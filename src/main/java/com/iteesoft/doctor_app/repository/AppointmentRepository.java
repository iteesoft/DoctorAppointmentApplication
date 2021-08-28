package com.iteesoft.doctor_app.repository;

import com.iteesoft.doctor_app.model.Appointment;
import com.iteesoft.doctor_app.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    List<Appointment> findAllByDoctor_Id(Long id);
    Appointment findAppointmentById(Long id);


//    findAllAppointmentsByDoctorIdAndDate(Long id, LocalDate date);
}
