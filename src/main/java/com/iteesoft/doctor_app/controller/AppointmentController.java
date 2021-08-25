package com.iteesoft.doctor_app.controller;

import com.iteesoft.doctor_app.DTO.AppointmentDto;
import com.iteesoft.doctor_app.DTO.LoginDto;
import com.iteesoft.doctor_app.model.Appointment;
import com.iteesoft.doctor_app.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/patdashboard/appointment_search")
    public String getAppointmentsByDoctor(Model model){
        AppointmentDto appointmentDto = new AppointmentDto();
        model.addAttribute("appointmentDto", appointmentDto);
        return "patdashboard";
    }

    @PostMapping("/patdashboard/appointment_search")
    public String getAppointmentsByDoctor(HttpServletRequest request, HttpSession session, Model model){
        if(session.getAttribute("userPat") == null){ return "/";}
        else {

            LocalDate date = LocalDate.parse(request.getParameter("doctor"));
            Long id = Long.parseLong("appointmentdate");
            List<Appointment> list = appointmentService.findAllByAppointmentDateAndAndDoctor_Id(date,id);
            if(list == null){

            } else{
                model.addAttribute("listOfAppointment",list);
            }
        }
    }

    }


