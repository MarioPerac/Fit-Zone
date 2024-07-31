package org.unibl.etf.ip.fitzone.services;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.fitzone.base.CrudJpaService;
import org.unibl.etf.ip.fitzone.models.entites.UserEntity;
import org.unibl.etf.ip.fitzone.repositories.UserRepository;

@Service
public class UserService extends CrudJpaService<UserEntity, String> {

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        super(userRepository, UserEntity.class, modelMapper);

    }
}
