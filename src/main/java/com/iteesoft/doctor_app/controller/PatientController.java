package com.iteesoft.doctor_app.controller;

import com.iteesoft.doctor_app.model.Doctor;
import com.iteesoft.doctor_app.model.Patient;
import com.iteesoft.doctor_app.service.DoctorService;
import com.iteesoft.doctor_app.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    DoctorService doctorService;

    @GetMapping("/newPatientPage")
    public String addNewPatient(Model model){
        model.addAttribute("newPatient",new Patient());
        return "pat_signup_form";
    }

    @PostMapping("/new_patient")
    public String saveNewPatient(@ModelAttribute("newPatient") Patient patient){
        patientService.savePatient(patient);
        return "redirect:/";
    }

    @GetMapping("/patdashboard")
    public String viewPatDashboard(Model model, HttpSession session){
        if(session.getAttribute("userPat") == null){
            return "redirect:/";
        } else {
            Patient patient = (Patient) session.getAttribute("userPat");
            model.addAttribute("listOfDoctors", doctorService.getAllDoctors());
            model.addAttribute("patient",patient);
        }
        return "patdashboard";
    }


}
