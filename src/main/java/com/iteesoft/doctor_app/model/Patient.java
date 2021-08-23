package com.iteesoft.doctor_app.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import static javax.persistence.GenerationType.*;

@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String genotype;
    private String email;
    private String password;

    @OneToOne
    private Appointment appointment;
}
