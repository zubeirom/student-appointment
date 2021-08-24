package de.stl.coursebooking.controller;

import de.stl.coursebooking.dto.UserDto;
import de.stl.coursebooking.model.User;
import de.stl.coursebooking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/current-user")
    @ResponseBody
    public UserDto currentUser(Principal principal) {
        User user = userService.findUserByEmail(principal.getName());
        return new UserDto(user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole());
    }

//    @GetMapping("/lecturers")
//    @ResponseBody
//    public List<User> getLecturers() {}
}
