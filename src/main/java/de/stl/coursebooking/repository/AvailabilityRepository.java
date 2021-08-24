package de.stl.coursebooking.repository;

import de.stl.coursebooking.model.Availability;
import de.stl.coursebooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

    @Query("SELECT u FROM Availability u WHERE u.lecturer = ?1")
    public List<Availability> findByLecturer(String email);

}
