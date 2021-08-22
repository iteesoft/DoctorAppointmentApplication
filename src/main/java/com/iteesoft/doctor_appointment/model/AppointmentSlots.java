package com.iteesoft.doctor_appointment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table
public class AppointmentSlots {
    @Id
    @GeneratedValue
    private Long id;
    private Timestamp startTime;
    private Timestamp endTime;


    private Doctor doctor;
}
