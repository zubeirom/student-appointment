package de.stl.coursebooking.controller;

import de.stl.coursebooking.dto.UserRegistrationDto;
import de.stl.coursebooking.model.User;
import de.stl.coursebooking.repository.UserRepository;
import de.stl.coursebooking.service.IUserService;
import de.stl.coursebooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {

    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String postRegister(@RequestBody UserRegistrationDto userRegistrationDto) {
        userService.addStudent(userRegistrationDto);
        return "successfulRegistration";
    }

    @GetMapping("/success-registration")
    public String successfulRegistration() {
        return "successfulRegistration";
    }

}
