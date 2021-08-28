package com.iteesoft.doctor_app.service;

import com.iteesoft.doctor_app.model.Appointment;
import com.iteesoft.doctor_app.model.Doctor;
import com.iteesoft.doctor_app.repository.AppointmentRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    List<Appointment> findAllByDoctor_Id(Long id);
    Appointment saveAppointment(Appointment appointment);
    Appointment findAppointmentById(Long id);
}
