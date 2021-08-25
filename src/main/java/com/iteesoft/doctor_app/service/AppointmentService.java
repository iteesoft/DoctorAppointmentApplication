package com.iteesoft.doctor_app.service;

import com.iteesoft.doctor_app.model.Appointment;
import com.iteesoft.doctor_app.model.Doctor;
import com.iteesoft.doctor_app.repository.AppointmentRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    List<Appointment> findAllByAppointmentDateAndAndDoctor_Id(LocalDate date, Long id);
}
