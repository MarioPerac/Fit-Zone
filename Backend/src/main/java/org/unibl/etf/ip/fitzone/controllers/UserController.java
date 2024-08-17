package org.unibl.etf.ip.fitzone.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.fitzone.base.CrudController;
import org.unibl.etf.ip.fitzone.base.CrudJpaService;
import org.unibl.etf.ip.fitzone.base.CrudService;
import org.unibl.etf.ip.fitzone.models.dto.Program;
import org.unibl.etf.ip.fitzone.models.dto.User;
import org.unibl.etf.ip.fitzone.models.requests.UserRequest;
import org.unibl.etf.ip.fitzone.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController extends CrudController<String, UserRequest, User> {

   private UserService userService;

   public UserController(UserService userService){
       super(userService, User.class);
       this.userService = userService;
   }

   @GetMapping("/{username}/programs")
    public ResponseEntity<List<Program>> getUserPrograms(@PathVariable String username){
        return ResponseEntity.ok(userService.getUserPrograms(username));
   }

   @GetMapping("/{username}/programs/active")
    public ResponseEntity<List<Program>> getUserActivePrograms(@PathVariable String username){
       return ResponseEntity.ok(userService.getUserActivePrograms(username));
   }

    @GetMapping("/{username}/programs/finished")
    public ResponseEntity<List<Program>> getUserFinishedPrograms(@PathVariable String username){
        return ResponseEntity.ok(userService.getUserFinishedPrograms(username));
    }
}
