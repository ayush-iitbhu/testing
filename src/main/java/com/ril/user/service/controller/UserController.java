package com.ril.user.service.controller;
import com.ril.user.service.request.UserRequest;
import com.ril.user.service.response.Response;
import com.ril.user.service.response.UserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@Slf4j
public class UserController {

    @GetMapping(value = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDetails getUserDetails(@RequestParam String userId){
        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(userId);
        userDetails.setName("Ayush");
        userDetails.setPhoneNumber("9973013524");
        return userDetails;
    }

    @PostMapping(value = "/saveUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response saveUserDetails(@RequestBody UserRequest request){
        log.info("Hello logs");
        // process the request
        return Response.builder().
                statusCode(1).
                message("Success").
                build();

    }

}
