package de.stl.coursebooking.repository;

import de.stl.coursebooking.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
}
