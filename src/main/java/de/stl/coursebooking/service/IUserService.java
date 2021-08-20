package de.stl.coursebooking.service;

import de.stl.coursebooking.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    public void addStudent(UserRegistrationDto userRegistrationDto);
}
