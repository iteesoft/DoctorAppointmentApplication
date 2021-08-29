package com.iteesoft.doctor_app.model;

import com.iteesoft.doctor_app.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;


@Getter
@Setter
@Entity
@Table(name="appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date appointmentDate;
    private String timeSlot;
    private String status;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Patient patient;


    public Appointment(){

    }
    public Appointment(Date appointmentDate, String timeSlot, String status, Doctor doctor, Patient patient) {
        this.appointmentDate = appointmentDate;
        this.timeSlot = timeSlot;
        this.status = status;
        this.doctor = doctor;
        this.patient = patient;
    }
}
