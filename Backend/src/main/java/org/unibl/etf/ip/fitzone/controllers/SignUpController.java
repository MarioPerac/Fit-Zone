package org.unibl.etf.ip.fitzone.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.fitzone.models.dto.User;
import org.unibl.etf.ip.fitzone.models.requests.UserRequest;
import org.unibl.etf.ip.fitzone.services.SignUpService;

import java.io.IOException;

@RestController
@RequestMapping("/api/signup")
public class SignUpController {

    private final SignUpService signUpService;


    public SignUpController(SignUpService signUpService){
        this.signUpService = signUpService;
    }

    @PostMapping
    public ResponseEntity<Boolean> signUp(@RequestBody UserRequest userRequest){

        return signUpService.signUp(userRequest) ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/activate/{username}")
    public void activateAccount(HttpServletResponse response, @PathVariable String username) throws IOException {

        signUpService.activateAccount(username);
   // return signUpService.activateAccount(username) ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        response.sendRedirect("http://localhost:4200/login");
    }

}
