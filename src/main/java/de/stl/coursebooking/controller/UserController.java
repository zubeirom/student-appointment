package de.stl.coursebooking.controller;

import de.stl.coursebooking.model.User;
import de.stl.coursebooking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/current-user")
    @ResponseBody
    public User currentUser(Principal principal) {
        return userService.findUserByEmail(principal.getName());
    }
}
