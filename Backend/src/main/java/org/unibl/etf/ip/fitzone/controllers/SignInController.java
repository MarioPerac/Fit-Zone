package org.unibl.etf.ip.fitzone.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.fitzone.models.dto.User;
import org.unibl.etf.ip.fitzone.services.SignInService;

@RestController
@RequestMapping("/api/signin")
public class SignInController {

    private final SignInService signInService;

    public SignInController(SignInService signInService){
        this.signInService = signInService;
    }

    @PostMapping
    public ResponseEntity<Boolean> signIn(User user){

        return signInService.signIn(user) ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
