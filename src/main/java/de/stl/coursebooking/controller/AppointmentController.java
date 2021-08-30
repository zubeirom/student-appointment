package de.stl.coursebooking.controller;

import de.stl.coursebooking.dto.AppointmentDto;
import de.stl.coursebooking.model.Appointment;
import de.stl.coursebooking.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private IAppointmentService appointmentService;

    @GetMapping("/appointments")
    public String viewAppointments() {
        return "appointments";
    }

    @GetMapping("/create-appointment")
    public String createAppointmentView() {
        return "createAppointment";
    }

    @PostMapping("/appointments")
    @ResponseBody
    public void bookAppointment(@RequestBody AppointmentDto appointmentDto) {
        appointmentService.createAppointment(appointmentDto);
    }

    @GetMapping("/api/appointments/{student}")
    @ResponseBody
    public List<Appointment> findAppointmentByStudent(@PathVariable("student") String student) {
        return appointmentService.findAppointmentsByStudent(student);
    }
}
