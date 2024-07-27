package org.unibl.etf.ip.fitzone.controllers;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.fitzone.models.requests.LoginRequest;
import org.unibl.etf.ip.fitzone.services.LoginService;

@RestController
@RequestMapping("/api/login")
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
