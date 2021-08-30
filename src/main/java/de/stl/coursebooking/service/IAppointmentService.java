package de.stl.coursebooking.service;

import de.stl.coursebooking.dto.AppointmentDto;
import de.stl.coursebooking.model.Appointment;

import java.util.List;

public interface IAppointmentService {
    public void createAppointment(AppointmentDto appointmentDto);

    public List<Appointment> findAppointmentsByStudent(String student);
}
