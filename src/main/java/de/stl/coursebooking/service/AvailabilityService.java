package de.stl.coursebooking.service;

import de.stl.coursebooking.model.Availability;
import de.stl.coursebooking.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilityService implements IAvailabilityService {
    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Override
    public List<Availability> findByLecturer(String email) {
        return availabilityRepository.findByLecturer(email);
    }
}
