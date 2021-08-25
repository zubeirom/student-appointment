package de.stl.coursebooking.controller;

import de.stl.coursebooking.dto.AvailabilityDto;
import de.stl.coursebooking.model.Availability;
import de.stl.coursebooking.service.IAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AvailabilityController {

    @Autowired
    private IAvailabilityService availabilityService;

    @GetMapping("/manage-availability")
    public String createAvailView() {
        return "manageAvail";
    }

    @RequestMapping(value="/availabilities/{lecturer}", method = RequestMethod.GET)
    @ResponseBody
    public List<Availability> getAvailabilities(@PathVariable("lecturer") String lecturer) {
        return availabilityService.findByLecturer(lecturer);
    }

    @PostMapping("/availabilities")
    @ResponseBody
    public void createAvails(@RequestBody AvailabilityDto availabilityDto) {
        System.out.println(availabilityDto);
    }

}
