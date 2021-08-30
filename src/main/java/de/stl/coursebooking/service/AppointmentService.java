package de.stl.coursebooking.service;

import de.stl.coursebooking.dto.AppointmentDto;
import de.stl.coursebooking.model.Appointment;
import de.stl.coursebooking.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public void createAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment(appointmentDto.getStudent(), appointmentDto.getLecturer(), appointmentDto.getParticipants(), appointmentDto.getDescription(), appointmentDto.getStartsAt(), appointmentDto.getEndsAt());
        appointmentRepository.save(appointment);
    }
}
