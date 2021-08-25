package com.iteesoft.doctor_app.controller;

import com.iteesoft.doctor_app.model.Doctor;
import com.iteesoft.doctor_app.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping("/doctors")
    public String viewAllDoctors(Model model,HttpSession session){
        model.addAttribute("listOfDoctors",doctorService.getAllDoctors());
        session.setAttribute("listOfDoctors",doctorService.getAllDoctors());
        if(session.getAttribute("userPat") == null|| session.getAttribute("userDoc") == null){
            return "redirect:/";
        } else {
            return "/doctorsList";
        }
    }

    @GetMapping("/newDoctorPage")
    public String addNewDoctor(Model model){
        model.addAttribute("newDoctor",new Doctor());
        return "doc_signup_form";
    }

    @PostMapping("/new_doctor")
    public String saveNewDoctor(@ModelAttribute("newDoctor") Doctor doctor){
        doctorService.saveDoctor(doctor);
        return "redirect:/";
    }

    @GetMapping("/docdashboard")
    public String viewDocDashboard(Model model, HttpSession session){
        if(session.getAttribute("userDoc") == null){
            return "redirect:/";
        }else {
            Doctor doctor = (Doctor) session.getAttribute("userDoc");
            model.addAttribute("doctor",doctor);
        }
        return "docdashboard";
    }

}
