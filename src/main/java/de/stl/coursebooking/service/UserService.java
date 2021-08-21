package de.stl.coursebooking.service;

import de.stl.coursebooking.dto.UserRegistrationDto;
import de.stl.coursebooking.model.CustomUserDetails;
import de.stl.coursebooking.model.User;
import de.stl.coursebooking.repository.UserRepository;
import de.stl.coursebooking.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    public void addStudent(UserRegistrationDto userRegistrationDto) {
        String encryptedPassword = passwordEncoder.encode(userRegistrationDto.getPassword());
        User newUser = new User(userRegistrationDto.getEmail(), encryptedPassword, userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(), Role.STUDENT);
        try {
            userRepo.save(newUser);
        } catch(DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User exists already");
        }
    }

    public User findUserByEmail(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public List<User> getAllLecturer() {
        return userRepo.findByRole(Role.STUDENT);
    }
}
