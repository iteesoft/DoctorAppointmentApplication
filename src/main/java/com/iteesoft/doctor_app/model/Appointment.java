package com.iteesoft.doctor_app.model;

import com.iteesoft.doctor_app.AppointmentStatus;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static javax.persistence.GenerationType.AUTO;

@Getter
@Setter
@Entity
@Table(name="appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private LocalDate appointmentDate;
//    private LocalTime startTime;
//    private LocalTime endTime;
    private String timeSlot;
    private AppointmentStatus status;


    @ManyToOne
    private Doctor doctor;

    @OneToOne
    private Patient patient;
}
