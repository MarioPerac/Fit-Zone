package org.unibl.etf.ip.fitzone.services;

import org.springframework.stereotype.Service;
import org.unibl.etf.ip.fitzone.models.entites.UserEntity;
import org.unibl.etf.ip.fitzone.repositories.UserRepository;

@Service
public class LoginService {

    private UserRepository userRepository;

    public LoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean login(String username, String password){
        UserEntity userEntity = userRepository.findByUsername(username);

        if(userEntity == null)
            return false;

        return userEntity.getPassword().equals(password);
    }
}
