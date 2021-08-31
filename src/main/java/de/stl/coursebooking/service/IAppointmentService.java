package de.stl.coursebooking.service;

import de.stl.coursebooking.dto.AppointmentDto;
import de.stl.coursebooking.model.Appointment;

import java.io.IOException;
import java.util.List;

public interface IAppointmentService {
    public void createAppointment(AppointmentDto appointmentDto) throws IOException;

    public List<Appointment> findAppointmentsByStudent(String student);

    public List<Appointment> findAppointmentsByLecturer(String lecturer);

    public void confirmAppointment(Long id) throws IOException;
}
