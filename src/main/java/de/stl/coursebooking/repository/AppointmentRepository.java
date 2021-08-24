package de.stl.coursebooking.repository;

import de.stl.coursebooking.model.Appointment;
import de.stl.coursebooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
