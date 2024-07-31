package org.unibl.etf.ip.fitzone.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.fitzone.models.dto.User;
import org.unibl.etf.ip.fitzone.models.entites.UserEntity;
import org.unibl.etf.ip.fitzone.repositories.UserRepository;

@Service
public class SignInService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    @PersistenceContext
    EntityManager entityManager;

    public SignInService(UserRepository userRepository, ModelMapper modelMapper){
        this.userRepository =userRepository;
        this.modelMapper = modelMapper;
    }


    public boolean signIn(User user){
        if(user.getName().isEmpty() || user.getSurname().isEmpty() || user.getMail().isEmpty())
            return false;

        UserEntity userEntity = modelMapper.map(user, UserEntity.class);

        userRepository.saveAndFlush(userEntity);
        entityManager.refresh(userEntity);

        return true;
    }
}
