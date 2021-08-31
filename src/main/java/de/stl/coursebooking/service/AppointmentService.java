package de.stl.coursebooking.service;

import de.stl.coursebooking.dto.AppointmentDto;
import de.stl.coursebooking.model.Appointment;
import de.stl.coursebooking.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public void createAppointment(AppointmentDto appointmentDto) throws IOException {
        Appointment appointment = new Appointment(appointmentDto.getStudent(), appointmentDto.getLecturer(), appointmentDto.getParticipants(), appointmentDto.getDescription(), appointmentDto.getStartsAt(), appointmentDto.getEndsAt());
        appointmentRepository.save(appointment);
        emailService.sendBookedAppointment(appointment);
    }

    @Override
    public List<Appointment> findAppointmentsByStudent(String student) {
        return appointmentRepository.findAppointmentsByStudent(student);
    }

    @Override
    public List<Appointment> findAppointmentsByLecturer(String lecturer) {
        return appointmentRepository.findAppointmentsByLecturer(lecturer);
    }

    @Override
    public void confirmAppointment(Long id) throws IOException {
        appointmentRepository.confirmAppointment(id);
        Appointment appointment = appointmentRepository.findAppointmentsById(id);
        emailService.sendConfirmedAppointment(appointment);
    }
}
