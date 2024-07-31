package org.unibl.etf.ip.fitzone.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.fitzone.models.dto.User;
import org.unibl.etf.ip.fitzone.models.entites.UserEntity;
import org.unibl.etf.ip.fitzone.models.requests.UserRequest;
import org.unibl.etf.ip.fitzone.repositories.UserRepository;

@Service
public class SignUpService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    @PersistenceContext
    EntityManager entityManager;

    public SignUpService(UserRepository userRepository, ModelMapper modelMapper){
        this.userRepository =userRepository;
        this.modelMapper = modelMapper;
    }


    @Transactional
    public boolean signUp(UserRequest userRequest){


        if(userRequest.getName().isEmpty() || userRequest.getSurname().isEmpty() || userRequest.getMail().isEmpty())
            return false;

        UserEntity userEntity = modelMapper.map(userRequest, UserEntity.class);

        userEntity = userRepository.saveAndFlush(userEntity);
        entityManager.refresh(userEntity);

        return true;
    }
}
