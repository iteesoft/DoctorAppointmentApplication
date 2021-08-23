package com.iteesoft.doctor_app.model;

import com.iteesoft.doctor_app.AppointmentStatus;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;
import static javax.persistence.GenerationType.AUTO;

@Getter
@Setter
@Entity
@Table(name="appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private AppointmentStatus status;


    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    @OneToOne
    private Patient patient;
}
