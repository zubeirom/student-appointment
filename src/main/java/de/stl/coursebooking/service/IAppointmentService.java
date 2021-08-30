package de.stl.coursebooking.service;

import de.stl.coursebooking.dto.AppointmentDto;

public interface IAppointmentService {
    public void createAppointment(AppointmentDto appointmentDto);
}
