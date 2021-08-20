package de.stl.coursebooking.service;

import de.stl.coursebooking.dto.UserRegistrationDto;
import de.stl.coursebooking.model.CustomUserDetails;
import de.stl.coursebooking.model.User;
import de.stl.coursebooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    public void addStudent(UserRegistrationDto userRegistrationDto) {
        if(userExists(userRegistrationDto.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User exists already");
        }
        User newUser = new User(userRegistrationDto.getEmail(), userRegistrationDto.getPassword(), userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(), "STUDENT");
        userRepo.save(newUser);
    }

    public boolean userExists(String email) {
        User user = userRepo.findByEmail(email);
        return user == null;
    }
}
