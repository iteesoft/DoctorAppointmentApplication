package com.iteesoft.doctor_app.controller;

import com.iteesoft.doctor_app.model.Appointment;
import com.iteesoft.doctor_app.model.Doctor;
import com.iteesoft.doctor_app.model.Patient;
import com.iteesoft.doctor_app.service.AppointmentService;
import com.iteesoft.doctor_app.service.DoctorService;
import com.iteesoft.doctor_app.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;


    @GetMapping("/appointment_search")
    public String getAppointmentsByDoctor(Model model){
        return "patdashboard";
    }


    @PostMapping("/appointment_search")
    public String getAppointmentsByDoctor(HttpSession session,@RequestParam(value = "doctor") String doctorId){
        if(session.getAttribute("userPat") == null){ return "/";}
        else {
            Long id = Long.parseLong(doctorId);
            session.setAttribute("doctor_id",id);

        }
        return "patdashboard";

    }
    @GetMapping("/listOfAppointments")
    public String appointments(Model model,HttpSession session){
        Long id = (Long) session.getAttribute("doctor_id");
        List<Appointment> list = appointmentService.findAllByDoctor_Id(id);
        model.addAttribute("listOfAppointments",list);
       return "patdashboard";
    }

    @GetMapping("/new_appointment")
    public String getAppointmentDetails( HttpSession session,Model model){
        Long id = (Long) session.getAttribute("doctor_id");
        List<Appointment> list = appointmentService.findAllByDoctor_Id(id);
        ArrayList<String> timeSlots = new ArrayList<>();
        if(list.size() > 0){
            for (Appointment appointment : list) {
                String timeSlot = appointment.getTimeSlot();
                if (timeSlot != null) {
                    timeSlots.add(timeSlot);
                }
            }
        }

        System.out.println("here now");

        if(timeSlots.contains("8AM-10AM")){
            System.out.println("here1");
            model.addAttribute("l1","true");
        } else{model.addAttribute("l1","false");}

        if(timeSlots.contains("10AM-12PM")){
            System.out.println("here2");
            model.addAttribute("l2","true");
        } else{model.addAttribute("l2","false");}

        if(timeSlots.contains("12PM-2PM")){
            System.out.println("here3");
            model.addAttribute("l3","true");
        } else{model.addAttribute("l3","false");}

        if(timeSlots.contains("2PM-4PM")){
            System.out.println("here4");
            model.addAttribute("l4","true");
        } else{model.addAttribute("l4","false");}
        return "appointment_form";
    }

    @PostMapping("/new_appointment")
    public String saveAppointment(HttpServletRequest request, HttpSession session) throws ParseException {
        Long id = (Long) session.getAttribute("doctor_id");
        Doctor doctor = doctorService.findDoctorById(id);
        Patient patient = (Patient) session.getAttribute("userPat");
        session.setAttribute("patient_id",patient.getId());
        System.out.println(doctor);
        System.out.println(patient);
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate((new SimpleDateFormat("dd-MM-yyyy")).parse(request.getParameter("appointmentDate")));
        appointment.setDoctor(doctor);
        appointment.setTimeSlot(request.getParameter("timeSlot"));
        appointment.setPatient(patient);
        appointment.setStatus("Pending");
        appointmentService.saveAppointment(appointment);
        return "redirect:/patdashboard";
    }

    @GetMapping("/listOfAppointments/edit/{id}")
    public String editAppointmentForm(@PathVariable Long id,Model model){
        model.addAttribute("appointment",appointmentService.findAppointmentById(id));
        return "edit_appointment";
    }

    @PostMapping("/listOfAppointments/edit/{id}")
    public String UpdateAppointment(@ModelAttribute("appointment") Appointment appointment, @PathVariable Long id, HttpSession session, HttpServletRequest request) throws ParseException {
        Appointment existingAppointment = appointmentService.findAppointmentById(id);
        existingAppointment.setId(id);
        //Date date = new SimpleDateFormat("yyyy-MM-dd").parse(appointment.getAppointmentDate())
        existingAppointment.setAppointmentDate((new SimpleDateFormat("dd-MM-yyyy")).parse(request.getParameter("appointmentDate")));
        existingAppointment.setTimeSlot(appointment.getTimeSlot());
        existingAppointment.setStatus(appointment.getStatus());
        existingAppointment.setDoctor(doctorService.findDoctorById((Long) session.getAttribute("doctor_id")));
        existingAppointment.setPatient(patientService.findPatientById((Long) session.getAttribute("patient_id")));
        appointmentService.saveAppointment(existingAppointment);
        return "redirect:/docdashboard";
    }

    @GetMapping("/listOfAppointments/{id}")
    public String transferAppointmentForm(Model model){
        model.addAttribute("listOfDoctors", doctorService.getAllDoctors());
        return "transfer_appointment";
    }

    @PostMapping("/listOfAppointments/{id}")
    public String transferAppointment(HttpServletRequest request,@PathVariable Long id,HttpSession session){
        Appointment appointment = appointmentService.findAppointmentById(id);
        Long id1 = appointment.getId();
        Date date = appointment.getAppointmentDate();
        String timeSlot = appointment.getTimeSlot();
        String status = appointment.getStatus();
        Doctor doctor = doctorService.findDoctorById(Long.parseLong(request.getParameter("doctor")));
        Patient patient = patientService.findPatientById((Long) session.getAttribute("patient_id"));
        Appointment appointment1 = new Appointment();
        appointment1.setId(id1);
        appointment1.setAppointmentDate(date);
        appointment1.setStatus(status);
        appointment1.setTimeSlot(timeSlot);
        appointment1.setDoctor(doctor);
        appointment1.setPatient(patient);
        appointmentService.saveAppointment(appointment1);
        return "docdashboard";
    }

    }


