package org.unibl.etf.ip.fitzone.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.fitzone.base.CrudJpaService;
import org.unibl.etf.ip.fitzone.models.entites.ProgramEntity;
import org.unibl.etf.ip.fitzone.repositories.ProgramRepository;


@Service
public class ProgramService extends CrudJpaService<ProgramEntity, Integer> {

    public ProgramService(ProgramRepository programRepository, ModelMapper modelMapper){
        super(programRepository, ProgramEntity.class, modelMapper);
    }
}
