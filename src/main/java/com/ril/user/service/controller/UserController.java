package com.ril.user.service.controller;
import com.ril.user.service.response.UserDetails;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class UserController {

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDetails getUserDetails(@RequestParam String userId){
        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(userId);
        userDetails.setName("Ayush");
        userDetails.setPhoneNumber("9973013524");
        return userDetails;
    }
}
