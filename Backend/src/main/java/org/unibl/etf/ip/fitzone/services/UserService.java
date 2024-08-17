package org.unibl.etf.ip.fitzone.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.fitzone.base.CrudJpaService;
import org.unibl.etf.ip.fitzone.models.dto.Program;
import org.unibl.etf.ip.fitzone.models.entites.EnrolmentEntity;
import org.unibl.etf.ip.fitzone.models.entites.UserEntity;
import org.unibl.etf.ip.fitzone.models.entites.UserHasProgramEntity;
import org.unibl.etf.ip.fitzone.repositories.EnrolmentRepository;
import org.unibl.etf.ip.fitzone.repositories.UserHasProgramRepository;
import org.unibl.etf.ip.fitzone.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService extends CrudJpaService<UserEntity, String> {

    private UserHasProgramRepository userHasProgramRepository;
    private EnrolmentRepository enrolmentRepository;
    public UserService(UserRepository userRepository,
                       UserHasProgramRepository userHasProgramRepository,
                       EnrolmentRepository enrolmentRepository,
                       ModelMapper modelMapper) {
        super(userRepository, UserEntity.class, modelMapper);
        this.userHasProgramRepository = userHasProgramRepository;
        this.enrolmentRepository = enrolmentRepository;
    }

    public List<Program> getUserPrograms(String username){

        List<UserHasProgramEntity> userHasProgramEntities = userHasProgramRepository.getUserHasProgramEntitiesByUserUsername(username);

        return userHasProgramEntities.stream().map(u -> modelMapper.map(u.getProgramEntity(), Program.class)).collect(Collectors.toList());
    }

    public List<Program> getUserActivePrograms(String username){
        List<EnrolmentEntity> enrolmentEntities = enrolmentRepository.getAllByUsernameAndProgramEntity_IsActive(username, true);
        return enrolmentEntities.stream().map(e -> modelMapper.map(e.getProgramEntity(), Program.class)).collect(Collectors.toList());
    }

    public List<Program> getUserFinishedPrograms(String username){
        List<EnrolmentEntity> enrolmentEntities = enrolmentRepository.getAllByUsernameAndProgramEntity_IsActive(username, false);
        return enrolmentEntities.stream().map(e -> modelMapper.map(e.getProgramEntity(), Program.class)).collect(Collectors.toList());
    }
}
