package de.stl.coursebooking.service;

import de.stl.coursebooking.model.Availability;

import java.util.List;

public interface IAvailability {
    public List<Availability> findByLecturer(String email);
}
