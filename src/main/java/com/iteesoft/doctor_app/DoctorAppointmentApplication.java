package com.iteesoft.doctor_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DoctorAppointmentApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", "8082");
        SpringApplication.run(DoctorAppointmentApplication.class, args);
        System.out.println("hello world");
    }

}
