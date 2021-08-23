package com.iteesoft.doctor_app.controller;

import com.iteesoft.doctor_app.DTO.LoginDto;
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
import java.util.Optional;

@Controller
public class GeneralController {

    DoctorService doctorService;
    PatientService patientService;

    @Autowired
    public GeneralController(DoctorService doctorService, PatientService patientService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @GetMapping(value ="/")
    public String homepage(Model model){
        model.addAttribute("loginDto", new LoginDto());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginDto") LoginDto loginDto, Model model, HttpSession httpSession){
        Optional<Doctor> userDoc = doctorService.findDoctorByEmailAndPassword(loginDto.getEmail(),loginDto.getPassword());
        Optional<Patient> userPat = patientService.findPatientByEmailAndPassword(loginDto.getEmail(),loginDto.getPassword());
        if(userDoc.isPresent()){
            Doctor doctor = userDoc.get();
            httpSession.setAttribute("user",doctor);
            return "redirect:/docdashboard";
        } else if(userPat.isPresent()){
            Patient patient = userPat.get();
            httpSession.setAttribute("user",patient);
            return "redirect:/patdashboard";
        } else{
         return "login";
        }
    }
}
