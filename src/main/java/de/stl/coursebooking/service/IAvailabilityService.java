package de.stl.coursebooking.service;

import de.stl.coursebooking.dto.AvailabilityDto;
import de.stl.coursebooking.model.Availability;

import java.util.List;

public interface IAvailabilityService {
    public List<Availability> findByLecturer(String email);

    public void save(AvailabilityDto availabilityDto);

    public boolean exists(AvailabilityDto availabilityDto);

    public List<Availability> findAll();

    public void deleteAvail(Long id);
}
