package com.iteesoft.doctor_appointment.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

public class Doctor {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private Appointment appointment;
}
