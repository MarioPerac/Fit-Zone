package org.unibl.etf.ip.fitzone.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.fitzone.base.CrudController;
import org.unibl.etf.ip.fitzone.base.CrudJpaService;
import org.unibl.etf.ip.fitzone.base.CrudService;
import org.unibl.etf.ip.fitzone.models.dto.User;
import org.unibl.etf.ip.fitzone.models.requests.UserRequest;
import org.unibl.etf.ip.fitzone.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController extends CrudController<String, UserRequest, User> {

   private UserService userService;

   public UserController(UserService userService){
       super(userService, User.class);
       this.userService = userService;
   }
}
