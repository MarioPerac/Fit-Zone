package org.unibl.etf.ip.fitzone.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.fitzone.base.CrudJpaService;
import org.unibl.etf.ip.fitzone.models.dto.Program;
import org.unibl.etf.ip.fitzone.models.entites.UserEntity;
import org.unibl.etf.ip.fitzone.models.entites.UserHasProgramEntity;
import org.unibl.etf.ip.fitzone.repositories.UserHasProgramRepository;
import org.unibl.etf.ip.fitzone.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService extends CrudJpaService<UserEntity, String> {

    private UserHasProgramRepository userHasProgramRepository;
    public UserService(UserRepository userRepository, UserHasProgramRepository userHasProgramRepository, ModelMapper modelMapper) {
        super(userRepository, UserEntity.class, modelMapper);
        this.userHasProgramRepository = userHasProgramRepository;
    }

    public List<Program> getUserPrograms(String username){

        List<UserHasProgramEntity> userHasProgramEntities = userHasProgramRepository.getUserHasProgramEntitiesByUserUsername(username);

        return userHasProgramEntities.stream().map(u -> modelMapper.map(u.getProgramEntity(), Program.class)).collect(Collectors.toList());
    }
}
