package com.iteesoft.doctor_app.service.impl;

import com.iteesoft.doctor_app.model.Appointment;
import com.iteesoft.doctor_app.model.Doctor;
import com.iteesoft.doctor_app.repository.AppointmentRepository;
import com.iteesoft.doctor_app.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;


    @Override
    public List<Appointment> findAllByDoctor_Id(Long id) {
        return appointmentRepository.findAllByDoctor_Id(id);
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment) ;
    }

    @Override
    public Appointment findAppointmentById(Long id) {
        return appointmentRepository.findAppointmentById(id);
    }


}