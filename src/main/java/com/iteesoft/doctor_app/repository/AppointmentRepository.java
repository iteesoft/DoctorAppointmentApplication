package com.iteesoft.doctor_app.repository;

import com.iteesoft.doctor_app.model.Appointment;
import com.iteesoft.doctor_app.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    List<Appointment> findAllByAppointmentDateAndAndDoctor_Id(LocalDate date,Long id);


//    findAllAppointmentsByDoctorIdAndDate(Long id, LocalDate date);
}
