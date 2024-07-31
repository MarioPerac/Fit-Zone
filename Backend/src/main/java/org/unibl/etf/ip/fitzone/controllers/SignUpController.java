package org.unibl.etf.ip.fitzone.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.fitzone.models.dto.User;
import org.unibl.etf.ip.fitzone.models.requests.UserRequest;
import org.unibl.etf.ip.fitzone.services.SignUpService;

@RestController
@RequestMapping("/api/signup")
public class SignUpController {

    private final SignUpService signUpService;


    public SignUpController(SignUpService signUpService){
        this.signUpService = signUpService;
    }

    @PostMapping
    public ResponseEntity<Boolean> signUp(@RequestBody UserRequest userRequest){
    System.out.println(userRequest.toString());
        return signUpService.signUp(userRequest) ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
