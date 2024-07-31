package org.unibl.etf.ip.fitzone.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.fitzone.models.dto.Login;
import org.unibl.etf.ip.fitzone.models.dto.User;
import org.unibl.etf.ip.fitzone.models.requests.LoginRequest;
import org.unibl.etf.ip.fitzone.services.LoginService;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<User> login(@RequestBody LoginRequest req){
        User user = loginService.login(req.getUsername(), req.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
