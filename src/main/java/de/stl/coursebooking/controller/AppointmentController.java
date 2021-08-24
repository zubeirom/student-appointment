package de.stl.coursebooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppointmentController {

    @GetMapping("/appointments")
    public String viewAppointments() {
        return "appointments";
    }

    @GetMapping("/create-appointment")
    public String createAppointmentView() {
        return "createAppointment";
    }
}
