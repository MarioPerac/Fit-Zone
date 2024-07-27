package org.unibl.etf.ip.fitzone.controllers;

import org.springframework.web.bind.annotation.*;
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
    public boolean login(@RequestBody LoginRequest req){
    return loginService.login(req.getUsername(), req.getPassword());
    }
}
