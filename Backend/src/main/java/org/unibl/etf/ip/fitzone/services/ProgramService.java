package org.unibl.etf.ip.fitzone.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.fitzone.base.CrudJpaService;
import org.unibl.etf.ip.fitzone.models.entites.ProgramEntity;
import org.unibl.etf.ip.fitzone.models.entites.UserHasProgramEntity;
import org.unibl.etf.ip.fitzone.models.requests.ProgramRequest;
import org.unibl.etf.ip.fitzone.repositories.ProgramRepository;
import org.unibl.etf.ip.fitzone.repositories.UserHasProgramRepository;


@Service
public class ProgramService extends CrudJpaService<ProgramEntity, Integer> {

    private UserHasProgramRepository userHasProgramRepository;
    public ProgramService(ProgramRepository programRepository, ModelMapper modelMapper, UserHasProgramRepository userHasProgramRepository){
        super(programRepository, ProgramEntity.class, modelMapper);

        this.userHasProgramRepository = userHasProgramRepository;
    }

    public void createProgram(ProgramRequest programRequest){
        ProgramEntity programEntity = jpaRepository.saveAndFlush(modelMapper.map(programRequest, ProgramEntity.class));
        entityManager.refresh(programEntity);

        UserHasProgramEntity userHasProgramEntity = new UserHasProgramEntity(programRequest.getUsername(), programEntity.getId());
        userHasProgramEntity = userHasProgramRepository.saveAndFlush(userHasProgramEntity);
        entityManager.refresh(userHasProgramEntity);
    }
}
