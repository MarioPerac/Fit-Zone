package org.unibl.etf.ip.fitzone.services;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.unibl.etf.ip.fitzone.base.CrudJpaService;
import org.unibl.etf.ip.fitzone.exceptions.NotFoundException;
import org.unibl.etf.ip.fitzone.models.dto.Program;
import org.unibl.etf.ip.fitzone.models.dto.UserHasProgram;
import org.unibl.etf.ip.fitzone.models.entites.ProgramEntity;
import org.unibl.etf.ip.fitzone.models.entites.UserHasProgramEntity;
import org.unibl.etf.ip.fitzone.models.requests.ProgramRequest;
import org.unibl.etf.ip.fitzone.repositories.ProgramRepository;
import org.unibl.etf.ip.fitzone.repositories.UserHasProgramRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProgramService extends CrudJpaService<ProgramEntity, Integer> {

    private UserHasProgramRepository userHasProgramRepository;
    private ProgramRepository programRepository;
    public ProgramService(ProgramRepository programRepository, ModelMapper modelMapper, UserHasProgramRepository userHasProgramRepository){
        super(programRepository, ProgramEntity.class, modelMapper);
        this.programRepository = programRepository;
        this.userHasProgramRepository = userHasProgramRepository;
    }

    public Program createProgram(ProgramRequest programRequest){
        ProgramEntity programEntity = jpaRepository.saveAndFlush(modelMapper.map(programRequest, ProgramEntity.class));
        entityManager.refresh(programEntity);

        UserHasProgramEntity userHasProgramEntity = new UserHasProgramEntity(programRequest.getUsername(), programEntity.getId());
        userHasProgramEntity = userHasProgramRepository.saveAndFlush(userHasProgramEntity);
        entityManager.refresh(userHasProgramEntity);

        return modelMapper.map(programEntity, Program.class);
    }

    public Page<UserHasProgram> getProgramsToUser(String username, Pageable pageable){
        Page<UserHasProgramEntity> userHasProgramEntity = null;

        if("unsigned".equals(username)){
            userHasProgramEntity = userHasProgramRepository.findAll(pageable);
        }else {
           userHasProgramEntity = userHasProgramRepository.getByUserUsernameNot(username, pageable);
        }

        List<UserHasProgram> programs = userHasProgramEntity.stream()
                .filter(u -> u.getProgramEntity().getIsActive())
                .map(u -> new UserHasProgram(modelMapper.map(u.getProgramEntity(), Program.class), u.getUserUsername(), u.getUserEntity().getName() + " " + u.getUserEntity().getSurname()))
                .collect(Collectors.toList());

        return new PageImpl<>(programs, pageable, userHasProgramEntity.getTotalElements());
    }

    public Program finsishProgram(Integer id) throws NotFoundException {

        if(!programRepository.existsById(id))
            throw new NotFoundException();

        ProgramEntity programEntity = programRepository.findById(id).get();

        programEntity.setIsActive(false);
        programEntity = programRepository.saveAndFlush(programEntity);
        entityManager.refresh(programEntity);

        return modelMapper.map(programEntity, Program.class);
    }
}
